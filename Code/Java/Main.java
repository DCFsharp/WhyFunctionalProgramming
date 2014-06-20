package com.company;

public class Main {

    public static void main(String[] args) {

        int numberTest = 6;

        ImpNumberClassifier inc = new ImpNumberClassifier(numberTest);

        boolean result = NumberClassifier.isAbundant(numberTest);

        System.out.println(result);

        result = inc.isAbundant();

        System.out.println(result);

    }
}
