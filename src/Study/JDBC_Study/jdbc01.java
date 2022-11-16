package Study.JDBC_Study;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author ZhiPengZhang
 * @date 2022/11/7 14:35
 * @description 第一个jdbc程序，完成简单的操作
 **/
public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作：在项目下创建一个文件夹例如libs
        // 将 mysql.jar拷贝到该目录下点击add to project加入到项目中
        //1.注册驱动
        Driver driver = new Driver();

        //2.得到连接
        //(1)jdbc:msql:// 规定好表示协议，通过jdbc的方式连接mysql
        //(2)localhost 主机，可以是ip地址
        //(2)3306 表示mysql监听的端口
        //(4)db01 连接到mysql dbms的哪个数据库
        //(5) mysql的连接本质就是前面学过的socket连接
        String url = "jdbc:mysql://localhost:3306/db01";
        // 将用户名和密码封装到Properties对象
        Properties properties = new Properties();
        //用户名
        properties.setProperty("user", "root");
        //密码
        properties.setProperty("password", "root");
        Connection connect = driver.connect(url, properties);

        //3.执行sql
        // 增删改语句
        //String sql = "insert into actor values (null,'刘德华','男','1970-11-11','110')";
        //String sql = "update actor set `name`='周星驰' where `name`='刘德华'";
        String sql = "delete from actor where id=1";
        // statement用于执行静态的SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        // 如果是dml语句，返回的就是影响行数
        int rows = statement.executeUpdate(sql);
        System.out.println(rows>0?"成功":"失败");
        //4.关闭资源连接
        statement.close();
        connect.close();
    }
}
