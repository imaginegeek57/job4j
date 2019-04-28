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
    //получить список счетов для пользователя
    public List <Account> getUserAccounts1(String passport) {
       return data.keySet().stream().filter(data -> data.getPassport().equals(passport)).collect(Collectors.toList());

    }
    // удаление пользователя.
    public void deleteUser(User user) {
        data.remove(user);
    }
    //получить список счетов для пользователя
    public List <Account> getUserAccounts(String passport) {
        return data.keySet().stream().filter(data -> data.getPassport().equals(passport)).collect(Collectors.toList());
    }
    //получить список счетов для пользователя
//    public List <Account> getUserAccounts(String passport) {
//        List <Account> accounts = null;
//        for (User u : data.keySet()) {
//            if (u.getPassport().equals(passport)) {
//                accounts = data.get(u);
//                break;
//            }
//        }
//        return accounts;
//    }
    //добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        data.keySet().stream().filter(data -> data.getPassport().equals(passport)).filter(data -> data.equals(account))
                .collect(Collectors.toList());

    }

//    //добавить счёт пользователю.
//    public void addAccountToUser(String passport, Account account) {
//        for (User u : data.keySet()) {
//            if (u.getPassport().equals(passport)) {
//                final List <Account> accounts = data.get(u);
//                if (!accounts.contains(account)) {
//                    accounts.add(account);
//                    break;
//                }
//            }
//        }
//    }
         // удалить один счёт пользователя.
       public void deleteAccountFromUser(String passport, Account account) {
            (data.keySet().stream().filter(data -> data.getPassport().equals(passport)).collect(Collectors.toList());
            data.keySet().removeIf(accounts -> accounts.equals(account));
           }

//    // удалить один счёт пользователя.
//    public void deleteAccountFromUser(String passport, Account account) {
//        for (User u : data.keySet()) {
//            if (u.getPassport().equals(passport)) {
//                final List <Account> accounts = data.get(u);
//                if (accounts.contains(account)) {
//                    accounts.remove(account);
//                    break;
//                }
//            }
//        }
//    }
       //поиска аккаунта по реквизитам и паспорту
       public Account getActualAccount(String passport, String requisites) {
        return data.keySet().stream().filter(data -> data.getPassport().equals(passport))
                .filter(data -> data.equals(requisites)).collect(Collectors.toList());
       }





    //поиска аккаунта по реквизитам и паспорту
//    public Account getActualAccount(String passport, String requisites) {
////        Account acc = null;
//        for (User u : data.keySet()) {
//            if (u.getPassport().equals(passport)) {
//                List <Account> accounts = data.get(u);
//                for (Account account : accounts) {
//                    if (account.getRequisites().contains(requisites)) {
//                        acc = account;
//                        break;
//                    }
//                }
//            }
//        }
//        return acc;
//    }
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
