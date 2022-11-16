package Study.JDBC_Study;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.NonRegisteringDriver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author ZhiPengZhang
 * @date 2022/11/7 15:16
 * @description java连接mysql的五种方式
 **/
@SuppressWarnings("all")
public class JDBCConnect {
    //方式一：使用Driver类
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db01";
        // 将用户名和密码封装到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        Connection connect = driver.connect(url, properties);
        connect.close();

        System.out.println(connect);
    }

    //方式二：使用反射加载Driver类
    @Test
    public void connect02() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //使用反射加载Driver类，动态加载，更加灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db01";
        // 将用户名和密码封装到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        Connection connect = driver.connect(url, properties);
        connect.close();

        System.out.println(connect);
    }

    //方式三：使用DriverManager类(都是静态方法)替代Driver类进行统一管理
    @Test
    public void connect03() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        // 创建url user和 password，也可以创建Properties对象存储user和 password
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "root";

        DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url, user, password);

        connect.close();
        System.out.println(connect);
    }

    //方式四：方式三的简化，使用Class.forName自动完成注册驱动，简化代码;使用的最多的方式 ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆
    @Test
    public void connect04() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //使用反射加载Driver类
        //在加载Driver类时自动完成注册（看源码）
//        public class Driver extends NonRegisteringDriver implements java.sql.Driver {
//            public Driver() throws SQLException {
//            }
//            1、静态代码块在类加载的时候会执行
//            static {
//                try {
//                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());        注册的语句，和方式三DriverManager.registerDriver(driver)一样
//                } catch (SQLException var1) {
//                    throw new RuntimeException("Can't register driver!");
//                }
//            }
//        }
        //这句话不写也行，但是建议加上
        Class.forName("com.mysql.jdbc.Driver");
        // 创建url user和 password
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "root";

        Connection connect = DriverManager.getConnection(url, user, password);
        connect.close();

        System.out.println(connect);
    }

    //方式五：在方式四的基础上使用配置文件，让连接更灵活
    @Test
    public void connect05() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        //通过properites对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Study\\JDBC_Study\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connect = DriverManager.getConnection(url, user, password);
        connect.close();

        System.out.println(connect);
    }
}
