package Study.JDBC_Study;

import Study.JDBC_Study.Utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author ZhiPengZhang
 * @date 2022/11/8 19:17
 * @description 使用JDBCUtils工具类完成查询和dml
 **/

@SuppressWarnings("all")
public class JDBCUtils_Test {
    @Test
    public void testDML() {
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "update actor set name=? where id=?";

        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void testSelect() {
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "select * from actor";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");//获取该行第1列
                String name = resultSet.getString("name");//获取该行第2列
                String sex = resultSet.getString("sex");//获取该行第3列
                Date date = resultSet.getDate("borndate");//获取该行第4列
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
