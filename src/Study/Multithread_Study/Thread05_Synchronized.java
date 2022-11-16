package Study.Multithread_Study;

public class Thread05_Synchronized {
    public static void main(String[] args) throws InterruptedException {
        SellTicket01 sellTicket01 = new SellTicket01();
        Thread thread01 = new Thread(sellTicket01);
        Thread thread02 = new Thread(sellTicket01);
        Thread thread03 = new Thread(sellTicket01);

        thread01.start();
        thread02.start();
        thread03.start();
//        while(thread01.getState()!=Thread.State.TERMINATED&&thread02.getState()!=Thread.State.TERMINATED&&thread03.getState()!=Thread.State.TERMINATED)
//        {
//            System.out.println("thread01"+thread01.getState()+"       thread02"+thread02.getState()+"       thread03"+thread03.getState());
//            Thread.sleep(1000);
//        }
    }
}


//
class SellTicket01 implements Runnable{
    private static int ticketNum = 100;
    private boolean loop = true;
    Object obj = new Object();

    @Override
    public void run() {
        while(loop){
            sell();
        }
    }

    //同步方法，锁在this对象      同步代码块,锁在this或者其他类上
    public /*synchronized*/ void sell() {
        synchronized (obj){
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() +
                    " 剩余" + (--ticketNum));
        }
    }

}
