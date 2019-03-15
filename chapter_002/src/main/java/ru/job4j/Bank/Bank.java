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
    public Map<User,List<Account>> data = new HashMap <>();
    List <User> list = new ArrayList <>();

    // добавление пользователя.
    public void addUser(User user) {
        list.add(user);
    }
    // удаление пользователя.
    public void deleteUser(User user) {
        list.remove(user);
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
    public List<Account> getUserAccounts (String passport) {
        return getUserAccounts(passport);
    }
    // не совсем понятно откуда берутся эти переменные....?

    //если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
//   public boolean transferMoney (String srcPassport, String srcRequisite,
//                                 String destPassport, String dstRequisite, double amount)
//    - метод для перечисления денег с одного счёта на другой счёт:





    // Посмотрите на методы Map.putIfAbsent и List.indexOf, как их можно применить в этом задании.

}
