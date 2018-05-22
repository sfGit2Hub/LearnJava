package mybatis3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/14.
 */
public class SqlSession {
    private Configuration configuration;
    public SqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public Object update(){
        return null;
    }

    public <E> List<E> selectList(Class<E> clazz, String statement, Object... parameters) throws SQLException, InstantiationException, IllegalAccessException {
        PreparedStatement preStatement = getConnection().prepareStatement(statement);
        if (parameters != null) {
            int i = 0;
            for (Object parameter : parameters) {
//                下面这一段，可以直接用 setObject方法，内部会去判断
//                调用setObject(index, object, sqlType, scaleLength)
                if (parameter instanceof Integer) {
                    preStatement.setInt(i++, (Integer) parameter);
                } else if (parameter instanceof String) {
                    preStatement.setString(i++, (String) parameter);
                } else if (parameter instanceof Boolean) {
                    preStatement.setBoolean(i++, (Boolean) parameter);
                } else if (parameter instanceof Date) {
                    Date date = (Date) parameter;
                    preStatement.setDate(i++, new java.sql.Date(date.getTime()));
                } else if (parameter instanceof  Double) {
                    preStatement.setDouble(i++, (Double) parameter);
                } else if (parameter instanceof Long) {
                    preStatement.setLong(i++, (Long) parameter);
                } else if (parameter instanceof Float) {
                    preStatement.setFloat(i++, (Float) parameter);
                } else {
                    preStatement.setObject(i++, parameter);
                }
            }
        }
        ResultSet resultSet = preStatement.executeQuery();

        return new ResultSetHandler<E>(clazz).handle(resultSet);
    }

    public <E> List<E> selectList(Class<E> clazz, String statement) throws SQLException, IllegalAccessException, InstantiationException {
        return this.selectList(clazz, statement, null);
    }

        public Connection getConnection() throws SQLException {
        return configuration.getEnvironment().getDataSource().getConnection();
    }
}
