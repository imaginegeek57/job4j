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

    //получить список счетов для пользователя
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

    //добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        for (User u : data.keySet()) {
            if (u.getPassport().equals(passport)) {
                final List <Account> accounts = data.get(u);
                if (!accounts.contains(account)) {
                    accounts.add(account);
                    break;
                }
            }
        }
    }

    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        for (User u : data.keySet()) {
            if (u.getPassport().equals(passport)) {
                final List <Account> accounts = data.get(u);
                if (!accounts.contains(account)) {
                    accounts.remove(account);
                    break;
                }
            }
        }
    }

    //поиска аккаунта по реквизитам и паспорту
    public Account getActualAccount(String passport, String requisites) {
        for (User u : data.keySet()) {
            if (u.getPassport().equals(passport)) {
                List <Account> accounts = data.get(u);
                for (Account account : accounts) {
                    if (account.getRequisites().contains(requisites)) {
                        break;
                    }
                }
            }
        }
        return getActualAccount(passport, requisites);
    }
}



//    public boolean transferMoney (String srcPassport, String srcRequisite,
//                                  String destPassport, String dstRequisite, double amount) {
//        for (User u : data.keySet()) {
//            List <Account> accounts = null;
//           if (u.getPassport().equals(srcPassport) && u.getPassport().equals(destPassport)) {
//               if (u.equals(dstRequisite) && u.equals(srcRequisite)) {
//                   accounts = data.get(u);
//                   getActualAccount(srcPassport,).transfer( //
//               }
//           }
//        }
//        return ;


//        return this.data.get(srcPassport).contains(destPassport)
//                && this.data.get(srcRequisite).contains(dstRequisite)
//                && getActualAccount(srcPassport, srcRequisite).transfer(
//                getActualAccount(destPassport, dstRequisite);, amount);
