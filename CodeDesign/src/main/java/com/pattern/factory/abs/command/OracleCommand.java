package com.pattern.factory.abs.command;

public class OracleCommand implements ICommand {
    @Override
    public void command() {
        System.out.println("Oracle Command");
    }
}
