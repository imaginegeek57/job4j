package ru.job4j.bankStream;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    Bank bank = new Bank();


    @Test
    public void testBank() {
        User user = new User("Vasya", "12345");
        User user1 = new User("Petr", "2334");
        User user2 = new User("Sveta", "666");
        Account account = new Account(1234, "ww2133");
        Account account1 = new Account(7894, "ty134");
        Account account2 = new Account(9935, "kol21");
        bank.addUser(user);
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("12345", account);
        bank.addAccountToUser("2334", account1);
        bank.addAccountToUser("666", account2);
        bank.data.entrySet().forEach(System.out::println);
    }

    @Test
    public void testBank2() {
        User user = new User("Vasya", "12345");
        User user1 = new User("Petr", "2334");
        User user2 = new User("Sveta", "666");
        Account account = new Account(1234, "ww2133");
        Account account1 = new Account(7894, "ty134");
        Account account2 = new Account(9935, "kol21");
        bank.addUser(user);
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("12345", account);
        bank.addAccountToUser("2334", account1);
        bank.addAccountToUser("666", account2);
        bank.deleteAccountFromUser("12345", account);
        bank.data.entrySet().forEach(System.out::println);
    }
}
