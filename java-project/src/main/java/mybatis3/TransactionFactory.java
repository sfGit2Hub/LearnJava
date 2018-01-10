package mybatis3;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by SF on 2018/1/10.
 */
public interface TransactionFactory {
    Transaction newTransaction(Connection conn);

    Transaction newTransaction(DataSource dataSource);
}
