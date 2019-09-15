package ru.job4j.bankStream;

import java.util.*;
import java.util.stream.Collectors;

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


    //получить список счетов для пользователя
    public List <Account> getUserAccounts(String passport) {
        return data.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(user -> data.get(user)).findFirst()
                .orElse(new ArrayList <>());
    }

    //  добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        data.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(user -> data.get(user).add(account))
                .collect(Collectors.toList());
    }


    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        data.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(user -> data.get(user).remove(account))
                .collect(Collectors.toList());
    }


    //поиска аккаунта по реквизитам и паспорту
    public Account getActualAccount(String passport, String requisites) {
        return (Account) data.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(user -> data.get(user))
                .map(accounts -> accounts.contains(requisites))
                .collect(Collectors.toList());
    }

    //перевод денег
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {


        boolean res = false;
        final Account account =  getActualAccount(srcPassport, srcRequisite);
        final Account account1 = getActualAccount(srcPassport, srcRequisite);
        if (account != null && account1 != null) {
            res = account.transfer(account1, amount);
        }
        return res;
    }


}
