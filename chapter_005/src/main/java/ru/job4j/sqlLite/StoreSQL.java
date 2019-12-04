package ru.job4j.sqlLite;

import java.security.KeyStore;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class StoreSQL extends Config implements AutoCloseable {

    public void create() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("create table if not exists tab(id serial primary key, " +
                    "entry varchar(2000))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generate(int size) {

    }

    public List <KeyStore.Entry> load() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void close() throws Exception {
        if (isConnected()) {
            LOG.debug("Close connection to database");
            this.connection.close();
            this.connection = null;
        }
    }

    public void add() {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "insert into tab(entry) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "enum1");
            statement.setString(1, "enum2");
            statement.setString(1, "enum3");
            statement.setString(1, "enum4");
            statement.setString(1, "enum5");
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

