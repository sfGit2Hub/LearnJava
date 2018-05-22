package mybatis3;

import common.use.Person;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 */
public class ResultSetHandler<T> {
    private Class<T> clazz;

    public ResultSetHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> handle(ResultSet resultSet) throws IllegalAccessException, InstantiationException, SQLException {
        List<T> list = new ArrayList<>();
        Field[] userFields = clazz.getDeclaredFields();
        while (resultSet.next()) {
            T obj = clazz.newInstance();
            for (Field field : userFields) {
                Class fieldType = field.getType();
                field.setAccessible(true);
                String fileName = field.getAnnotation(Column.class) == null
                        ? field.getName()
                        : field.getAnnotation(Column.class).name();
                if (fieldType == Long.class || fieldType == long.class) {
                    field.set(obj, resultSet.getLong(fileName));
                    System.out.println(resultSet.getInt(fileName));
                } else if (fieldType == String.class) {
                    field.set(obj, resultSet.getString(fileName));
                    System.out.println(resultSet.getString(fileName));
                } else if (fieldType == Double.class || fieldType == double.class) {
                    field.set(obj, resultSet.getDouble(fileName));
                } else if (fieldType == Integer.class || fieldType == int.class) {
                    field.set(obj, resultSet.getInt(fileName));
                } else if (fieldType == Date.class) {
                    Date date = new Date(resultSet.getDate(fileName).getTime());
                    field.set(obj, date);
                }
            }
            list.add(obj);
        }

        return list;
    }

    public static void main(String[] args) {
        Field[] fields = Person.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
//            fields[i].setAccessible(true);
            System.out.println(fields[i].getType());
        }
    }
}
