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
        if (!data.containsKey(user)) {
            data.put(user, new ArrayList <>());
        }
    }
    // удаление пользователя.
    public void deleteUser(User user) {
        data.remove(user);
    }
    public List <Account> getUserAccounts(String passport) {
        List <Account> accounts = null;
        for (User u : data.keySet()) {
            if (u.getPassport().equals(passport)) {
                accounts = data.get(u);
                break;
            }
        }
        return accounts;
    }
    // добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        for (User u : data.keySet()) {
            if (!data.containsValue(passport)) {
                data.put(u, new ArrayList <>());
            }
        }

    }
    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        for (User u : data.keySet()) {
           if (data.containsValue(passport));
            data.remove(account);
        }
    }
    public boolean transferMoney(User user1, Account account1,
                                 User user2, Account account2) {
        return this.data.get(user1).contains(account1)
                && this.data.get(user2).contains(account2);
    }
}

