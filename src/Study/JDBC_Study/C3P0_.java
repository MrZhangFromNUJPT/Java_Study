package Study.JDBC_Study;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author ZhiPengZhang
 * @date 2022/11/9 15:17
 * @description 演示c3p0的使用
 **/
@SuppressWarnings("all")
public class C3P0_ {
    //方式1，相关的参数在程序中指定，如url、user、password等
    @Test
    public void testC3P0_01() throws Exception {
        //1、创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //通过配置文件获取连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Study\\JDBC_Study\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //给数据源comboPooledDataSource设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl(url);

        //设置 初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置 最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //测试5000次连接时长
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//核心方法,从连接池中获取一个连接
            //System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

    //方式2，使用配置文件模板完成
    //将c3p0提供的c3p0-config.xml拷贝到src目录下，该文件指定了和连接池相关的参数
    @Test
    public void testC3P0_02() throws Exception {
        //1、创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mySource");
        //测试5000次连接时长
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//核心方法,从连接池中获取一个连接
            //System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

}
