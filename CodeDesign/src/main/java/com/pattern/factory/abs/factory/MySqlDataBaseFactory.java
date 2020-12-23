package com.pattern.factory.abs.factory;

import com.pattern.factory.abs.IDatabaseUtils;
import com.pattern.factory.abs.command.ICommand;
import com.pattern.factory.abs.command.MySqlCommand;
import com.pattern.factory.abs.connection.IConnection;
import com.pattern.factory.abs.connection.MySqlConnection;

public class MySqlDataBaseFactory implements IDatabaseUtils {
    @Override
    public IConnection getConnection() {
        return new MySqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MySqlCommand();
    }
}
