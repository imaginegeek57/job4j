package ru.job4j.sqlLite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Config {


    protected static final Logger LOG = LogManager.getLogger(Config.class);

    protected Connection connection;

    private static final String PROPERTIES_FILE = "sqlLite.properties";

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            Properties values = new Properties();
            values.load(in);

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean isConnected() {
        return connection != null;
    }

    protected Connection getConnection() {
        if (!isConnected()) {
            init();
        }
        return connection;
    }
}

