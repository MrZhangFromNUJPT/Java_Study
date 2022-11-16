package Study.JDBC_Study.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author ZhiPengZhang
 * @date 2022/11/8 19:04
 * @description 这是一个mysql工具类，完成mysql的连接和关闭资源
 **/
@SuppressWarnings("all")
public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //静态代码块初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\Study\\JDBC_Study\\mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");

        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            //1、将编译异常转成运行异常
            //2、使得调用者可以选择捕获该异常或者默认处理该异常，比较方便
            throw new RuntimeException(e);

        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //1、将编译异常转成运行异常
            //2、使得调用者可以选择捕获该异常或者默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //关闭资源
    /*
        1、ResultSet
        2、Statement或者PreparedStatement
        3、Connection
        4、如果需要关闭资源则传入对象，否则传入null
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
