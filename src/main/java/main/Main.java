package main;


import main.converter.Parser;

import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        String rub = Parser.convert(new BigDecimal("19789782.11"), "CZK");
        System.out.println(rub);
    }

}
