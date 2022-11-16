package Study.Multithread_Study;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(" " + (++i) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 10) break;
        }
    }
}