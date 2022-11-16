package Study.Multithread_Study;

public class HomeWork {
    public static void main(String[] args) {
        Card card = new Card();
        new Thread(card).start();
        new Thread(card).start();
    }

}

class Card extends Thread {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            if (money <= 0) {
                System.out.println("没钱了");
                break;
            }
            getMoney();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void getMoney() {
        money -= 1000;
        System.out.println(Thread.currentThread().getName() + "拿了1000，还剩" + money);
    }
}