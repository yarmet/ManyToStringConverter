package main.converter;


import java.math.BigDecimal;

public class Parser {

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    public static String convert(BigDecimal sum, String alphabeticCode) {
        if (sum == null) {
            throw new RuntimeException("Не указана сумма");
        }
        if (sum.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("сумма не может быть отрицательной");
        }

        Currency wholeCurrency;
        FractionalCurrency fractionalCurrency;
        try {
            // достанем наазвания для целой части суммы, например, рубль
            wholeCurrency = Currency.valueOf(alphabeticCode);
            // достанем наазвания для дробной части суммы, например, копейка
            fractionalCurrency = FractionalCurrency.valueOf(alphabeticCode);
        } catch (Exception e) {
            throw new RuntimeException("Неизвестный тип валюты : " + alphabeticCode);
        }


        long wholeSum = getWhole(sum);
        String fractional = getFractional(sum);

        String wholePart = Processor.parseString(wholeSum, wholeCurrency);
        String fractionalCurrencyName = Processor.getFormType(Integer.parseInt(fractional), fractionalCurrency);

        return new StringBuilder()
                .append(wholePart)
                .append(" ")
                .append(fractional)
                .append(" ")
                .append(fractionalCurrencyName)
                .toString();
    }

    /**
     * Достает целую часть из BigDecimal
     */
    private static Long getWhole(BigDecimal sum) {
        return sum.longValue();
    }


    /**
     * Достает дробную часть из BigDecimal, значение берется только до ДВУХ цифр после запятой. <br/>
     */
    private static String getFractional(BigDecimal sum) {
        String remainder = sum
                .remainder(BigDecimal.ONE)
                .multiply(HUNDRED)
                .toBigInteger()
                .toString();
        // если число меньше 10, то нарисуем спереди ноль.
        return remainder.length() < 2 ? "0".concat(remainder) : remainder;
    }
}
