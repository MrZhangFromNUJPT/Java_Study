package Study.Annotation_Study;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-16 20:08
 * @Description 计算器类
 */
public class Calculator {
    @Check
    public void add() {
        System.out.println("1 + 0 = " + (1 + 0));
    }

    @Check
    public void sub() {
        System.out.println("1 - 0 = " + (1 - 0));
    }

    @Check
    public void mul() {
        System.out.println("1 * 0 = " + (1 * 0));
    }

    @Check
    public void div() {
        System.out.println("1 / 0 = " + (1 / 0));
    }
    @Check
    public void show(){
        String s = null;
        s.toString();
    }
}
