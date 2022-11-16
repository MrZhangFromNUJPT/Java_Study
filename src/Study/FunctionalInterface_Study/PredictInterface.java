package Study.FunctionalInterface_Study;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author ZhiPengZhang
 * @date 2022/10/26 19:08
 * @description   Predict接口的test方法检验是否满足条件，及其and,or,negate方法（多个判断）
 **/
public class PredictInterface {
    public static void main(String[] args) {
        String[] info = {"古力娜扎,女","赵丽颖,女","马尔扎哈,男","迪丽热巴,女"};
        ArrayList<String> arrayList =predictInfo(info,
                s->s.split(",")[0].length()==4,
                s-> "女".equals(s.split(",")[1]));
        System.out.println(arrayList);
    }

    private static  ArrayList<String>  predictInfo(String[] info, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : info) {
            if(pre1.and(pre2).test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
