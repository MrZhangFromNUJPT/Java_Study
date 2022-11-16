package com.company;
import java.util.concurrent.TimeUnit;
/**
 * @author ZhiPengZhang
 * @date 2022/11/8 21:02
 * @description
 **/

@SuppressWarnings("all")
class T
{
    static class Data{
        //volatile   int number =0;
        int number =0;
        public void add()
        {
            this.number = number +1;
        }
    }
    // 启动两个线程，一个work线程，一个main线程，work线程修改number值后，查看main线程的number
    private static void testVolatile() {
        Data myData = new Data();
        //第1个线程，work线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(2);
                myData.add();
                System.out.println(Thread.currentThread().getName()+"\t update number value :"+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "workThread").start();
        //第2个线程，main线程
        while (myData.number == 0){
            //main线程还在找0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
        System.out.println(Thread.currentThread().getName()+"\t mission is over，main get number is:"+myData.number);
    }
    public static void main(String[] args) {
        testVolatile();
    }
}
