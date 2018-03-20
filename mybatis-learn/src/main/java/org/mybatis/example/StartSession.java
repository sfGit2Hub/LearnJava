package org.mybatis.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.json.JSONUtils;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.util.Properties;


/**
 * Created by SF on 2017/12/25.
 */
public class StartSession {
    public static void main(String[] args) throws IOException {
        DruidDataSource dataSource = new DruidDataSource();
        Properties properties = new Properties();
        properties.load(StartSession.class.getClassLoader().getResourceAsStream("druid.properties"));
        dataSource.configFromPropety(properties);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(UserMapper.class);
        configuration.addMappers("org.mybatis.example");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1L);
        System.out.println(user);
        sqlSession.close();
    }
}
