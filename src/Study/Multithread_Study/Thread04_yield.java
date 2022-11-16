package Study.Multithread_Study;

public class Thread04_yield {
    public static void main(String[] args) throws InterruptedException {
        T2 t = new T2();
        t.start();
        for(int i=0;i<20;i++){
            System.out.println("hi"+(i+1));
            Thread.sleep(1000);
            if(i==4) {
                System.out.println("礼让子线程");//礼让并不成功，系统资源足够执行两个线程
                Thread.yield();
            }
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("hello"+(i+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}