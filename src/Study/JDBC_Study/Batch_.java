package Study.JDBC_Study;

import Study.JDBC_Study.Utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ZhiPengZhang
 * @date 2022/11/9 14:18
 * @description 演示批处理
 **/
@SuppressWarnings("all")
public class Batch_ {
    //不使用批处理
    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        JDBCUtils.close(null, preparedStatement, connection);
    }

    //使用批处理
    //需要在url参数里加上  ?rewriteBatchedStatements=true
    //即 url=jdbc:mysql://localhost:3306/db01?rewriteBatchedStatements=true
    @Test
    public void useBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            //将sql语句加入批处理包中->看源码
            preparedStatement.addBatch();
            //当有一千条时，批量执行
            if ((i + 1) % 1000 == 0) {
                //批量执行
                preparedStatement.executeBatch();
                //清空
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        JDBCUtils.close(null, preparedStatement, connection);
    }

}
