package ru.job4j.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SQLManager {

    protected static final Logger LOG = LogManager.getLogger(SQLManager.class);

    private static final String PROPERTIES_FILE = "app.properties";

    /* Параметры для подключения */

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    protected Connection connection;

    public SQLManager() {
        this.readFileProperties(PROPERTIES_FILE);
    }

    private void readFileProperties(String fileName) {
        try (InputStream in = SQLManager.class.getClassLoader().getResourceAsStream(fileName)) {
            Properties config = new Properties();
            config.load(in);

            this.driverClassName = config.getProperty("driver-class-name");
            this.url = config.getProperty("url");
            this.username = config.getProperty("username");
            this.password = config.getProperty("password");

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void connect() {
        LOG.debug("Connect to database");
        try {
            Class.forName(this.driverClassName);
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean isConnected() {
        return connection != null;
    }

    protected Connection getConnection() {
        if (!isConnected()) {
            connect();
        }
        return connection;
    }
}
