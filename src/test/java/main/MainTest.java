package main;


import main.converter.Currency;
import main.converter.Processor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {


    @Test
    public void test1() {
        String s = Processor.parseString(1, Currency.RUB);
        assertEquals(s, "один российский рубль");
    }


    @Test
    public void test2() {
        String s = Processor.parseString(2, Currency.RUB);
        assertEquals(s, "два российских рубля");
    }

    @Test
    public void test3() {
        String s = Processor.parseString(3, Currency.RUB);
        assertEquals(s, "три российских рубля");
    }

    @Test
    public void test4() {
        String s = Processor.parseString(5, Currency.RUB);
        assertEquals(s, "пять российских рублей");
    }

    @Test
    public void test5() {
        String s = Processor.parseString(1000, Currency.RUB);
        assertEquals(s, "одна тысяча российских рублей");
    }

    @Test
    public void test6() {
        String s = Processor.parseString(1001, Currency.RUB);
        assertEquals(s, "одна тысяча один российский рубль");
    }

    @Test
    public void test7() {
        String s = Processor.parseString(121121, Currency.RUB);
        assertEquals(s, "сто двадцать одна тысяча сто двадцать один российский рубль");
    }

    @Test
    public void test8() {
        String s = Processor.parseString(12122, Currency.RUB);
        assertEquals(s, "двенадцать тысяч сто двадцать два российских рубля");
    }

    @Test
    public void test9() {
        String s = Processor.parseString(12123423421421L, Currency.RUB);
        assertEquals(s, "двенадцать триллионов сто двадцать три миллиарда четыреста двадцать три миллиона четыреста двадцать одна тысяча четыреста двадцать один российский рубль");
    }

    @Test
    public void test11() {
        String s = Processor.parseString(1, Currency.CZK);
        assertEquals(s, "одна чешская крона");
    }

    @Test
    public void test12() {
        String s = Processor.parseString(2, Currency.CZK);
        assertEquals(s, "две чешских кроны");
    }

    @Test
    public void test13() {
        String s = Processor.parseString(3, Currency.CZK);
        assertEquals(s, "три чешских кроны");
    }


    @Test
    public void test14() {
        String s = Processor.parseString(5, Currency.CZK);
        assertEquals(s, "пять чешских крон");
    }

    @Test
    public void test15() {
        String s = Processor.parseString(1000, Currency.CZK);
        assertEquals(s, "одна тысяча чешских крон");
    }

    @Test
    public void test16() {
        String s = Processor.parseString(1001, Currency.CZK);
        assertEquals(s, "одна тысяча одна чешская крона");
    }

    @Test
    public void test17() {
        String s = Processor.parseString(121121, Currency.CZK);
        assertEquals(s, "сто двадцать одна тысяча сто двадцать одна чешская крона");
    }

    @Test
    public void test18() {
        String s = Processor.parseString(12121, Currency.CZK);
        assertEquals(s, "двенадцать тысяч сто двадцать одна чешская крона");
    }


    @Test
    public void test19() {
        String s = Processor.parseString(120112, Currency.CZK);
        assertEquals(s, "сто двадцать тысяч сто двенадцать чешских крон");
    }


}