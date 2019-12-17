package ru.job4j.sqlLite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Config {

    private static final Logger LOG = LogManager.getLogger(Config.class);

    protected Connection connection;

    private static final String PROPERTIES_FILE = "sqlLite.properties";

    private String url;

    public Config() {
        this.init(PROPERTIES_FILE);
    }


    private void init(String file) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(file)) {
            Properties values = new Properties();
            values.load(in);

            this.url = values.getProperty("url");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void connect() {
        LOG.debug("connect to database");
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(this.url);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }


    protected boolean isConnected() {
        return connection != null;
    }

    public Connection getConnection() {
        LOG.debug("Connection to SQLite has been established");
        if (!isConnected()) {
            connect();
        }
        return connection;
    }
}

