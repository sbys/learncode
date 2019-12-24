package ThreadPool;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool {
    private BlockingQueue<Runnable> tasks=new LinkedBlockingQueue<>();
    private Worker[] workers=null;
    private volatile  boolean isRun=true;
    public class Worker extends  Thread{
        @Override
        public void run() {
            while (isRun||tasks.size()>0){
                Runnable task=null;
                try {
                    if(isRun)
                    task=tasks.take();
                    else
                        task=tasks.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run();

            }

        }
    }

    public FixedThreadPool(int fixSize,int taskSize) throws InterruptedException {
        this.tasks=new LinkedBlockingQueue<>(taskSize);
        this.workers=new Worker[fixSize];
        for(int i=0;i<fixSize;i++){
            workers[i]=new Worker();
            workers[i].start();
        }
    }
    public boolean submit(Runnable task){
        if(isRun)
        return this.tasks.offer(task);
        else
            return false;
    }
    public void shutDown(){
        this.isRun=false;
        for(Worker worker:workers){
            if(worker.getState().equals(Thread.State.BLOCKED))
                worker.interrupt();
        }

    }
}
