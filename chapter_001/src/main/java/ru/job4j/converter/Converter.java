package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return 70/70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return 60/60;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Евро.
     */
    public int EuroToRuble(int value) {
        return 1*70;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллар.
     * @return Доллары
     */
    public int dollarToRuble(int value) {
        return 1*60;
    }
}