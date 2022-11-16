package Study.Reflection_Study;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 18:21
 * @Description 猫类，演示反射机制
 */
public class Cat {
    private String name = "Tom";
    public int age = 5;
    public String sex = "公";

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hi() {
        System.out.println("hi,tom");
    }

    public void cry() {
        System.out.println("cry,tom");
    }
}
