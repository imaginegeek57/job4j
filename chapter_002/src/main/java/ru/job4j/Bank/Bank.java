package ru.job4j.Bank;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
public class Bank {
    public static void main(String[] args) {
    }

    public Map <User, List <Account>> data = new HashMap <>();

    // добавление пользователя.
    public void addUser(User user) {
        data.put(user, new ArrayList <>());
    }

    // удаление пользователя.
    public void deleteUser(User user) {
        data.remove(user);
    }

    // добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        getUserAccounts(passport).add(account);
    }

    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        getUserAccounts(passport).remove(account);

    }

    // получить список счетов для пользователя.
    public List <Account> getUserAccounts(String passport) {
        return getUserAccounts(passport);
    }

    public boolean transferMoney(User user1, Account account1,
                            User user2, Account account2) {
        return this.data.get(user1).contains(account1)
                && this.data.get(user2).contains(account2);

    }
}