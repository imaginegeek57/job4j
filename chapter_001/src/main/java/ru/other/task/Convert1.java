package ru.other.task;

public class Convert1 {
    public static void main(String[] args) {
        System.out.println("First task result = " + inLiter(5.6));
        System.out.println("Second task result = " + weight(85));
        System.out.println("Third task result = " + inYear(1996));
        System.out.println("Fourth task result = " + countExt(1, 2, 6.7, 13, 8));
        System.out.println("Fifth task result = " + between(6, 40));
        System.out.println("Six task result = " + negation(-1));
        printHello("Вася");
        System.out.println("Eight task result = " + canBay(19));

    }

    // 1 галлон содержит 3.7854 литров воды, преобразовать галлоны в литры
    static double inLiter(double a) {
        double result = a * 3.7854;
        return result;
    }

    // Сила тяжести на Луне составляет около 17% земой, напиши программу для вычесления веса на Луне
    static double weight(double a) {
        double result = a * 0.17;
        return result;
    }

    // вычасляем высокосный год ( каждый 4-й) за исключением каждого сотого и четырех сотого
    static boolean inYear(int a) {
        return ((a % 4 == 0) && (a % 100 != 0) || (a % 400 == 0));
    }

    // a*b +(c/d*e)
    static double countExt(double a, double b, double c, double d, double e) {
        return a * b + (c / d * e);
    }

    // метод возрощает true, если сумма чисел между 10 и 50
    static boolean between(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 50;
    }

    //метод вычесляет отрицательное число или нет
    static boolean negation(double a) {
        return a < 0;
    }

    // метод пишет слово привет
    static void printHello(String name) {
        System.out.println("Привет, " + name);
    }

    static boolean canBay(int age) {
        return age >= 18 && age <= 100;
    }
}
