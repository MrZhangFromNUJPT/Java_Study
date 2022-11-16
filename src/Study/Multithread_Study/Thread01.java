package Study.Multithread_Study;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();
        System.out.println("主线程");
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程"+i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    private int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("子线程" + (i++));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==80) break;
        }
    }
}
