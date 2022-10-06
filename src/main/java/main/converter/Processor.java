package main.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static main.converter.Degree.EMPTY;


public class Processor {


    public static List<String> parseString(long value, Currency currency) {
        List<String> result = new ArrayList<>();
        if (value == 0) {
            return makeZero(result, value, currency);
        }
        int lastDigit = 0;
        Degree degree = EMPTY;
        for (Map.Entry<Integer, Degree> entry : divideByDegree(value)) {
            Integer fullNumber = entry.getKey();
            degree = entry.getValue();
            List<Integer> splitedNumber = splitNumber(fullNumber);
            for (int j = 0; j < splitedNumber.size(); j++) {
                lastDigit = splitedNumber.get(j);
                Digits digitEnum = Digits.geEnumByValue(lastDigit); // Преобразовываем число в строку
                boolean lastValue = j == splitedNumber.size() - 1;
                if (lastValue) {
                    if (degree.hasName()) {
                        result.add(getDigitGenderByDegree(digitEnum, degree));
                        result.add(getFormType(lastDigit, degree));
                    } else {
                        result.add(getDigitGenderByMany(digitEnum, currency));
                    }
                } else {
                    result.add(digitEnum.getMaleName());
                }
            }
        }
        result.add(getManyForm(lastDigit, degree, currency));
        return result;
    }


    private static List<String> makeZero(List<String> result, long value, Currency currency) {
        result.add(Digits.geEnumByValue(Math.toIntExact(value)).getMaleName());
        result.add(currency.getThirdForm());
        return result;
    }


    private static String getDigitGenderByDegree(Digits digit, Degree degree) {
        return digit.isCanBeFemale() && degree.isFemale() ? digit.getFemaleName() : digit.getMaleName();
    }


    private static String getDigitGenderByMany(Digits digit, Currency currency) {
        return digit.isCanBeFemale() && currency.isFemale() ? digit.getFemaleName() : digit.getMaleName();
    }


    private static String getManyForm(int lastDigit, Degree degree, Currency currency) {
        if (degree != EMPTY) {
            return currency.getThirdForm();
        }
        return getFormType(lastDigit, currency);
    }

    /**
     * Разбирает число на составляющие, по 3 знака. <br/>
     * <p>
     * Пример работы:  <br/>
     * На входе: 2020203, на выходе: 20 MILLION, 20 THOUSAND, 203
     * На входе: 20501, на выходе: 20 THOUSAND, 501
     */
    private static List<Map.Entry<Integer, Degree>> divideByDegree(long value) {
        List<Map.Entry<Integer, Degree>> result = new ArrayList<>();
        int valuePiece;
        for (Degree degree : Degree.values()) {
            long length = degree.getLength();
            valuePiece = Math.toIntExact(value / length);
            if (valuePiece != 0) {
                result.add(Map.entry(valuePiece, degree));
            }
            value %= length;
        }
        return result;
    }


    /**
     * Получает число в диапазоне от 0 до 999 и раскладывает его на состовляющие. Так же присылает признак, является ли составляющее последним <br/>
     * Пример работы: <br/>
     * На вход 999, на выходе: 900, 90,9 <br/>
     * На вход 512, на выходе: 500, 12 <br/>
     * На вход 115, на выходе: 100, 15 <br/>
     * На вход 18, на выходе:  18 <br/>
     * На вход 244, на выходе: 200, 40, 4 <br/>
     * На вход 140, на выходе: 100, 40 <br/>
     */
    private static List<Integer> splitNumber(int number) {
        if (number > 999 || number < 0) {
            throw new RuntimeException("Неправильное число");
        }
        List<Integer> result = new ArrayList<>();
        int divider = number >= 100 ? 100 : 10;
        int remain;
        while (number >= 20) { // перебираем все цифры в числе слева направо, пока не останется остаток меньше 20.
            remain = number / divider;
            number = number % divider;
            result.add(remain * divider);
            divider /= 10;
        }
        if (number != 0) {
            result.add(number);
        }
        return result;
    }


    /**
     * Возвращает последную цифру (для определения "пола" числа)
     */
    private static int getLastDigit(int v) {
        while (v >= 10) {
            v %= 10;
        }
        return Math.toIntExact(v);
    }


    /**
     * получает нужное склонение в зависимости от числа. Например: <br/>
     * 1. "тысяча", "тысячи", "тысяч"  <br/>
     * 2. "миллион", "миллиона", "миллионов" <br/>
     */
    public static String getFormType(int v, MutliformType mutliformType) {
        if (v > 10 && v <= 20) {
            return mutliformType.getThirdForm();
        } else {
            switch (getLastDigit(v)) {
                case 1:
                    return mutliformType.getFirstForm();
                case 2:
                case 3:
                case 4:
                    return mutliformType.getSecondForm();
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return mutliformType.getThirdForm();
                default:
                    throw new RuntimeException("Неправильное число");
            }
        }
    }


}
