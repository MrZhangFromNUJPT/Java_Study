package Study.JDBC_Study;

import Study.JDBC_Study.Utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ZhiPengZhang
 * @date 2022/11/9 14:04
 * @description 演示事务
 **/
@SuppressWarnings("all")
public class Transaction_ {
    //没有使用事务
    @Test
    void noTransaction() {
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "update account set balance=balance-100 where id=1";
        String sql2 = "update account set balance=balance+100 where id=2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            //执行第一条
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            int i = 1 / 0;
            //执行第二条
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //使用事务
    @Test
    void useTransaction() {
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "update account set balance=balance-100 where id=1";
        String sql2 = "update account set balance=balance+100 where id=2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            //取消默认提交
            connection.setAutoCommit(false);
            //执行第一条
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            //抛出异常
            //int i = 1 / 0;
            //执行第二条
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            System.out.println("执行发生异常，撤销执行");
            try {
                //在这里回滚,无参默认回滚到事务开始的地方
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
