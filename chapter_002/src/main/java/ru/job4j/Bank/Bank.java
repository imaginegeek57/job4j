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
        List <Account> accounts = null;
        for (User u : data.keySet()) {
            if (data.get(user) == null) {
                data.put(user, new ArrayList <>());
            }
        }
    }

    // удаление пользователя.
    public void deleteUser(User user) {
        List <Account> accounts = null;
        for (User u : data.keySet()) {
            if (u.equals(user)) {
                data.remove(user);
            }
        }
    }
    // добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        List <Account> accounts = null;
        for (User u : data.keySet()) {
            if (u.getPassport().equals(passport))
                data.put(u, new ArrayList <>());     // тут пробовал сделать по аналогу метода addUser
        }                                             // но idea ругается..
    }

    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        List <Account> accounts = null;
        for (User u : data.keySet()) {
            if (u.getPassport().equals(passport)) {
                data.remove(passport, account);     // здесь я удалил account по ключу (passport)
            }

        }
    }
    public boolean transferMoney(User user1, Account account1,
                                 User user2, Account account2) {
        return this.data.get(user1).contains(account1)
                && this.data.get(user2).contains(account2);
    }
}


