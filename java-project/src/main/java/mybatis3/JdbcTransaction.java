package mybatis3;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/1/10.
 */
public class JdbcTransaction implements Transaction {
    private DataSource dataSource;
    private Connection connection;
//    默认自动提交
    private boolean autoCommmit = true;

    public JdbcTransaction(DataSource ds, boolean desiredAutoCommit) {
        dataSource = ds;
        autoCommmit = desiredAutoCommit;
    }

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            openConnect();
        }
        return connection;
    }

    private void openConnect() throws SQLException {
        connection = this.dataSource.getConnection();
        connection.setAutoCommit(autoCommmit);
    }

    @Override
    public void commit() throws SQLException {
        if (connection != null && !autoCommmit) {
            connection.commit();
        }
    }

    @Override
    public void rollback() throws SQLException {
        if (connection != null && autoCommmit) {
            connection.rollback();
        }
    }

    @Override
    public void close() throws SQLException {
        if(connection != null) {
            resetAutoCommit();
            connection.close();
        }
    }

    private void resetAutoCommit() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public Integer getTimeout() throws SQLException {
        return null;
    }
}
