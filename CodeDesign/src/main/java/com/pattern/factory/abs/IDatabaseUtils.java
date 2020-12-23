package com.pattern.factory.abs;

import com.pattern.factory.abs.command.ICommand;
import com.pattern.factory.abs.connection.IConnection;

public interface IDatabaseUtils {

    IConnection getConnection();

    ICommand getCommand();
}
