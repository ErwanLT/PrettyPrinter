package com.eletutour.printer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PrettyPrinter {

    private static final String ANSI_RED = "\u001B[1;31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[1;32m";
    private static final String ANSI_LIGHT_BLUE = "\u001B[1;34m";

    private static final String DECORATOR = "------";

    public PrettyPrinter(){}

    public void printDecorator(String message){
        print(DECORATOR + " " + message + " " + DECORATOR);
    }

    public void print(String message){
        System.out.println("[" + getTime() + "] " + message);
    }

    public void printInfoDecorator(String message){
        printInfo(DECORATOR + " " + message + " " + DECORATOR);
    }

    public void printInfo(String message){
        System.out.println(ANSI_LIGHT_BLUE + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    public void printSuccessDecorator(String message){
        printSuccess(DECORATOR + " " + message + " " + DECORATOR);
    }

    public void printSuccess(String message){
        System.out.println(ANSI_GREEN + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    public void printErrorDecorator(String message){
        printError(DECORATOR + " " + message + " " + DECORATOR);
    }

    public void printError(String message){
        System.out.println(ANSI_RED + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    private String getTime() {
        return Instant.now().truncatedTo(ChronoUnit.MILLIS).toString().replaceAll("[TZ]", " ");
    }
}
