package Study.JDBC_Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @author ZhiPengZhang
 * @date 2022/11/8 15:24
 * @description 演示PreparedStatement使用
 **/
@SuppressWarnings("all")
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01", "root", "root");
        String sql = "select id,`name`,sex,borndate from actor";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);//这里写入sql
        System.out.println(preparedStatement.toString());
        ResultSet resultSet = preparedStatement.executeQuery();//执行select语句，不用再写入sql了
        while (resultSet.next()) {
            int id = resultSet.getInt(1);//获取该行第1列     也可以   int id = resultSet.getInt("id")来获取，这个方法更好
            String name = resultSet.getString("name");//获取该行第2列  String name = resultSet.getString("name")
            String sex = resultSet.getString(3);//获取该行第3列
            Date date = resultSet.getDate("borndate");//获取该行第4列
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        /* 注意占位符的运用。setString方法会自动添加单引号，不能用来设置表名和数据库名等，只能用于传入where等语句中的字符串量。
        setInt 只可以输入 Int
        String sql = "select ? from ?";//select id,name,sex,borndate from actor
        PreparedStatement preparedStatement = connection.prepareStatement(sql);//这里写入sql
        preparedStatement.setString(1,"id,`name`,sex,borndate"); //此方法会自动添加单引号
        preparedStatement.setString(2,"actor");
        System.out.println(preparedStatement.toString());  ------->select 'id,`name`,sex,borndate' from 'actor' 会报错
         */
    }
}
