package Study.JDBC_Study;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

/**
 * @author ZhiPengZhang
 * @date 2022/11/7 15:50
 * @description 演示select语句返回ResultSet，并取出结果
 **/
@SuppressWarnings("all")
public class ResultSet_ {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Study\\JDBC_Study\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //1、注册驱动
        Class.forName(driver);
        //2、获取连接
        Connection connect = DriverManager.getConnection(url, user, password);
        //3、得到Statement
        Statement statement = connect.createStatement();
        //4、组织 select sql
        String sql = "select id,name,sex,borndate from actor";
        //执行给定的SQL语句，该语句返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);
        //使用while循环
        while (resultSet.next()) {//让光标向后移动，如果没有更多行，返回false
            int id = resultSet.getInt(1);//获取该行第1列
            String name = resultSet.getString(2);//获取该行第2列
            String sex = resultSet.getString(3);//获取该行第3列
            Date date = resultSet.getDate(4);//获取该行第4列
            System.out.println(id+"\t"+name+"\t"+sex+"\t"+date);
        }
        /*  结果：
               2	刘德华	男	1970-12-12
               3	jack	男	1990-12-12
        */
        //释放资源
        resultSet.close();
        statement.close();
        connect.close();
    }
}
