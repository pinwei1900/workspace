package db;

import static config.constant.dbFilePath;

import bean.DownFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlHelper {

    final static Logger logger = LoggerFactory.getLogger(SqlHelper.class);

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public SqlHelper() {

    }

    public Connection getConnection(String dbFilePath) throws ClassNotFoundException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
        conn.setAutoCommit(false);
        return conn;
    }

    public <T> T executeQuery(String sql, ResultSetExtractor<T> rse)
            throws SQLException, ClassNotFoundException {
        try {
            resultSet = getStatement().executeQuery(sql);
            T rs = rse.extractData(resultSet);
            return rs;
        } finally {
            destroyed();
        }
    }

    public <T> List<T> executeQuery(String sql, RowMapper<T> rm)
            throws SQLException, ClassNotFoundException {
        List<T> rsList = new ArrayList<T>();
        try {
            resultSet = getStatement().executeQuery(sql);
            while (resultSet.next()) {
                rsList.add(rm.mapRow(resultSet, resultSet.getRow()));
            }
        } finally {
            destroyed();
        }
        return rsList;
    }

    public void executeUpdate(String sql) throws SQLException, ClassNotFoundException {
        try {
            getStatement().executeUpdate(sql);
        } finally {
            destroyed();
        }
    }


    public void executeUpdate(String... sqls) throws SQLException, ClassNotFoundException {
        try {
            for (String sql : sqls) {
                getStatement().executeUpdate(sql);
            }
        } finally {
            destroyed();
        }
    }

    public void executeUpdate(List<String> sqls) throws SQLException, ClassNotFoundException {
        try {
            for (int i = 0; i < sqls.size(); i++) {
                getStatement().executeUpdate(sqls.get(i));
            }
        } finally {
            destroyed();
        }
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (null == connection) {
            connection = getConnection(dbFilePath);
        }
        return connection;
    }

    private Statement getStatement() throws SQLException, ClassNotFoundException {
        if (null == statement) {
            statement = getConnection().createStatement();
        }
        return statement;
    }

    public void destroyed() {
        try {
            if (null != resultSet) {
                resultSet.close();
                resultSet = null;
            }

            if (null != statement) {
                statement.close();
                statement = null;
            }

            if (null != connection) {
                connection.commit();
                connection.close();
                connection = null;
            }

        } catch (SQLException e) {
            logger.error("Sqlite数据库关闭时异常", e);
        }
    }
}
