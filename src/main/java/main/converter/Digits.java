package main.converter;

import java.util.HashMap;
import java.util.Map;

enum Digits {

    ZERO(0, "ноль"),
    ONE(1, true, "один", "одна"),
    TWO(2, true, "два", "две"),
    THREE(3, "три"),
    FOUR(4, "четыре"),
    FIVE(5, "пять"),
    SIX(6, "шесть"),
    SEVEN(7, "семь"),
    EIGHT(8, "восемь"),
    NINE(9, "девять"),
    TEN(10, "десять"),
    ELEVEN(11, "одинадцать"),
    TWELVE(12, "двенадцать"),
    THIRTEEN(13, "тринадцать"),
    FOURTEEN(14, "четырнадцать"),
    FIFTEEN(15, "пятнадцать"),
    SIXTEEN(16, "шестнадцать"),
    SEVENTEEN(17, "семнадцать"),
    EIGHTEEN(18, "восемнадцать"),
    NINETEEN(19, "девятнадцать"),
    TWENTY(20, "двадцать"),
    THIRTY(30, "тридцать"),
    FORTY(40, "сорок"),
    FIFTY(50, "пятьдесят"),
    SIXTY(60, "шестьдесят"),
    SEVENTY(70, "семьдесят"),
    EIGHTY(80, "восемьдесят"),
    NINETY(90, "девяносто"),
    ONE_HUNDRED(100, "сто"),
    TWO_HUNDRED(200, "двести"),
    THREE_HUNDRED(300, "триста"),
    FOUR_HUNDRED(400, "четыреста"),
    FIVE_HUNDRED(500, "пятьсот"),
    SIX_HUNDRED(600, "шестьсот"),
    SEVEN_HUNDRED(700, "семьсот"),
    EIGHT_HUNDRED(800, "восемьсот"),
    NINE_HUNDRED(900, "девятьсот");


    private final int value;
    private boolean canBeFemale;
    private final String maleName;
    private String femaleName;


    private static final Map<Integer, Digits> names = new HashMap<>();


    static {
        for (Digits value : Digits.values()) {
            names.put(value.value, value);
        }
    }


    Digits(int value, boolean canBeFemale, String maleName, String femaleName) {
        this.value = value;
        this.canBeFemale = canBeFemale;
        this.maleName = maleName;
        this.femaleName = femaleName;
    }

    Digits(int value, String maleName) {
        this.value = value;
        this.maleName = maleName;
    }


    public static Digits geEnumByValue(int value) {
        return names.get(value);
    }

    public boolean isCanBeFemale() {
        return canBeFemale;
    }

    public String getMaleName() {
        return maleName;
    }

    public String getFemaleName() {
        return femaleName;
    }
}
