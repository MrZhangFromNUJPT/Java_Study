package Study.Collection_Study;

import java.util.HashSet;


@SuppressWarnings({"all"})
public class mainTest_1 {
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();
        employees.add(new Employee("zzp",19000,new MyDate(1999,1,26)));
        employees.add(new Employee("zzp",18000,new MyDate(1999,1,26)));
        employees.add(new Employee("zyz",18000,new MyDate(1999,1,26)));
        System.out.println("employees="+employees);
    }
}