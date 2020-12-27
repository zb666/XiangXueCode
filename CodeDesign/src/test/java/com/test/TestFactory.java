package com.test;

import com.pattern.facade.FacadeFather;
import com.pattern.factory.abs.IDatabaseUtils;
import com.pattern.factory.abs.command.ICommand;
import com.pattern.factory.abs.factory.MySqlDataBaseFactory;

public class TestFactory {

    public static void main(String[] args) {
        IDatabaseUtils databaseUtils = new MySqlDataBaseFactory();
        ICommand command = databaseUtils.getCommand();
        command.command();
        facadeTest();
    }

    private static void facadeTest() {
        FacadeFather facadeFather = new FacadeFather();
        facadeFather.doSomethingFacade();
    }

}
