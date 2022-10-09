package main;


import main.converter.Parser;

import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        String rub = Parser.convert(new BigDecimal("135001.11"), "PLN");
        System.out.println(rub);
    }

}
