package Study.CodeBlock_Study;

class Father {
    private static int n1 = getVal01();

    static {
        System.out.println("Father的静态代码块");
    }

    {
        System.out.println("Father的普通代码块");
    }

    private int n2 = getVal02();

    public static int getVal01() {
        System.out.println("getVal01");
        return 10;
    }

    public static int getVal02() {
        System.out.println("getVal02");
        return 10;
    }
    public Father(){
        //super()
        //普通代码块
        System.out.println("Father构造器被调用");
    }
}

class Son extends Father {
    private static int n3 = getVal03();

    static {
        System.out.println("Son的静态代码块");
    }

    {
        System.out.println("Son的普通代码块");
    }

    private int n4 = getVal04();

    public static int getVal03() {
        System.out.println("getVal03");
        return 10;
    }

    public static int getVal04() {
        System.out.println("getVal04");
        return 10;
    }

    public Son(){
        //super()
        //普通（非静态）代码块
        System.out.println("Son构造器被调用");
    }

}

class main{
    public static void main(String[] args) {
        //（1）进行类的加载
        //1.1 先加载父类，再加载子类，此时所有静态成员和静态代码块被执行（按定义顺序）
        //（2）创建对象
        //2.1从子类的构造器开始->父类构造器->子类代码块和成员初始化->子类构造器显式内容
        new Son();
        //类加载
//        getVal01---------------父类静态1
//        Father的静态代码块-------父类静态2
//        getVal03---------------子类静态1
//        Son的静态代码块----------子类静态2
        //调用super()
//        Father的普通代码块-------父类代码块/成员初始化1
//        getVal02---------------父类代码块/成员初始化2
//        Father构造器被调用-------父类构造器内容
        //子类的代码块和成员初始化调用
//        Son的普通代码块----------子类代码块/成员初始化1
//        getVal04---------------子类代码块/成员初始化2
        //构造器显式内容
//        Son构造器被调用----------子类构造器内容

    }
}
