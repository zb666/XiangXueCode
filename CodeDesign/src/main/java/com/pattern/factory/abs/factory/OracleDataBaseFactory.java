package com.pattern.factory.abs.factory;

import com.pattern.factory.abs.IDatabaseUtils;
import com.pattern.factory.abs.command.ICommand;
import com.pattern.factory.abs.command.OracleCommand;
import com.pattern.factory.abs.connection.IConnection;
import com.pattern.factory.abs.connection.OracleConnection;

public class OracleDataBaseFactory implements IDatabaseUtils {
    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
