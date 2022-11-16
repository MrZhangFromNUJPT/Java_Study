package Study.Generic_Study;

import org.junit.jupiter.api.Test;
import java.util.*;

@SuppressWarnings({"all"})
public class Homework01 {
    static class DAO<T>{
        Map<String,T> map=new HashMap<>();

        public void test(){
            DAO<Users> usersDAO = new DAO<Users>();
            usersDAO.save("1",new Users(10,"zzz"));
            usersDAO.save("2",new Users(11,"aaa"));
            usersDAO.save("3",new Users(12,"bbb"));
            System.out.println("get方法测试");
            System.out.println(usersDAO.get("2"));
            System.out.println("update方法测试");
            usersDAO.update("1",new Users(11,"ccc"));
            System.out.println(usersDAO);
            System.out.println("list方法测试");
            List<Users> list = usersDAO.list();
            System.out.println(list);
            System.out.println("delete方法测试");
            usersDAO.delete("1");
            System.out.println(usersDAO);
        }


        public void save(String id,T entity){
            this.map.put(id,entity);
        }

        public T get(String id){
            return this.map.get(id);
        }

        public void update(String id,T entity){
            this.map.put(id,entity);
        }

        public List<T> list(){
            Collection<T> set = this.map.values();
            ArrayList<T> ts = new ArrayList<>();
            for(T t:set){
                ts.add(t);
            }
            return ts;
        }

        public void delete(String id){
            this.map.remove(id);
        }


        public String toString() {
            return "DAO{" +
                    "map=" + map +
                    '}';
        }
    }
}
class Users{
    private int age;
    private String name;

    public Users() {
    }

    public Users(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
