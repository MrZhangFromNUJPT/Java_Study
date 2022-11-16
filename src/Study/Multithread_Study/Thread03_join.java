package Study.Multithread_Study;

public class Thread03_join {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        for(int i=0;i<20;i++){
            System.out.println("hi"+(i+1));
            Thread.sleep(1000);
            if(i==4) {
                System.out.println("让子线程插队");
                t.join();
            }
        }
    }
}

class T extends Thread{
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