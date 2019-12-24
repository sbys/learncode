package ThreadPool;

public class Main {
    public static void main(String[]args) throws InterruptedException {
        FixedThreadPool fixedThreadPool=new FixedThreadPool(3,4);
        for(int i=0;i<10;i++)
        fixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("trhead: "+Thread.currentThread().getName());
                }
            }
        });
        fixedThreadPool.shutDown();
    }
}
