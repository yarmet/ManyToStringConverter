package main;


import main.converter.Currency;
import main.converter.Processor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {


    @Test
    public void test1() {
        List<String> s = Processor.parseString(1, Currency.RUB);
        assertEquals(String.join(" ", s), "один российский рубль");
    }


    @Test
    public void test2() {
        List<String> s = Processor.parseString(2, Currency.RUB);
        assertEquals(String.join(" ", s), "два российских рубля");
    }

    @Test
    public void test3() {
        List<String> s = Processor.parseString(3, Currency.RUB);
        assertEquals(String.join(" ", s), "три российских рубля");
    }

    @Test
    public void test4() {
        List<String> s = Processor.parseString(5, Currency.RUB);
        assertEquals(String.join(" ", s), "пять российских рублей");
    }

    @Test
    public void test5() {
        List<String> s = Processor.parseString(1000, Currency.RUB);
        assertEquals(String.join(" ", s), "одна тысяча российских рублей");
    }

    @Test
    public void test6() {
        List<String> s = Processor.parseString(1001, Currency.RUB);
        assertEquals(String.join(" ", s), "одна тысяча один российский рубль");
    }

    @Test
    public void test7() {
        List<String> s = Processor.parseString(121121, Currency.RUB);
        assertEquals(String.join(" ", s), "сто двадцать одна тысяча сто двадцать один российский рубль");
    }

    @Test
    public void test8() {
        List<String> s = Processor.parseString(12122, Currency.RUB);
        assertEquals(String.join(" ", s), "двенадцать тысяч сто двадцать два российских рубля");
    }

    @Test
    public void test9() {
        List<String> s = Processor.parseString(12123423421421L, Currency.RUB);
        assertEquals(String.join(" ", s), "двенадцать триллионов сто двадцать три миллиарда четыреста двадцать три миллиона четыреста двадцать одна тысяча четыреста двадцать один российский рубль");
    }

    @Test
    public void test11() {
        List<String> s = Processor.parseString(1, Currency.CZK);
        assertEquals(String.join(" ", s), "одна чешская крона");
    }

    @Test
    public void test12() {
        List<String> s = Processor.parseString(2, Currency.CZK);
        assertEquals(String.join(" ", s), "две чешских кроны");
    }

    @Test
    public void test13() {
        List<String> s = Processor.parseString(3, Currency.CZK);
        assertEquals(String.join(" ", s), "три чешских кроны");
    }


    @Test
    public void test14() {
        List<String> s = Processor.parseString(5, Currency.CZK);
        assertEquals(String.join(" ", s), "пять чешских крон");
    }

    @Test
    public void test15() {
        List<String> s = Processor.parseString(1000, Currency.CZK);
        assertEquals(String.join(" ", s), "одна тысяча чешских крон");
    }

    @Test
    public void test16() {
        List<String> s = Processor.parseString(1001, Currency.CZK);
        assertEquals(String.join(" ", s), "одна тысяча одна чешская крона");
    }

    @Test
    public void test17() {
        List<String> s = Processor.parseString(121121, Currency.CZK);
        assertEquals(String.join(" ", s), "сто двадцать одна тысяча сто двадцать одна чешская крона");
    }

    @Test
    public void test18() {
        List<String> s = Processor.parseString(12121, Currency.CZK);
        assertEquals(String.join(" ", s), "двенадцать тысяч сто двадцать одна чешская крона");
    }


    @Test
    public void test19() {
        List<String> s = Processor.parseString(120112, Currency.CZK);
        assertEquals(String.join(" ", s), "сто двадцать тысяч сто двенадцать чешских крон");
    }


}