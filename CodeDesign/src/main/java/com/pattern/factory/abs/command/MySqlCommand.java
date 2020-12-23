package com.pattern.factory.abs.command;

public class MySqlCommand implements ICommand {
    @Override
    public void command() {
        System.out.println("MySql Command");
    }
}
