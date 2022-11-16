package Study.Generic_Study;

import java.util.ArrayList;
import java.util.Comparator;

public class mainTest_3 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("zzz", 8000, new MyDate(1999, 1, 26)));
        employees.add(new Employee("aaa", 9000, new MyDate(1999, 2, 26)));
        employees.add(new Employee("zzz", 100000, new MyDate(1998, 3, 26)));
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName() != o2.getName()) {
                    return o1.getName().compareTo(o2.getName());
                } else
                    return o1.getBirthday().compareTo(o2.getBirthday());
            }
        }
        );
        for(Employee I:employees)
            System.out.println(I);
    }
}
