package com.eletutour.printer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PrettyPrinter {

    public static final String ANSI_RED = "\u001B[1;31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[1;32m";
    public static final String ANSI_LIGHT_BLUE = "\u001B[1;34m";

    public PrettyPrinter(){}

    public void print(String message){
        System.out.println("[" + getTime() + "] " + message);
    }

    public void printInfo(String message){
        System.out.println(ANSI_LIGHT_BLUE + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    public void printSuccess(String message){
        System.out.println(ANSI_GREEN + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    public void printError(String message){
        System.out.println(ANSI_RED + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    private String getTime() {
        return Instant.now().truncatedTo(ChronoUnit.MILLIS).toString().replaceAll("[TZ]", " ");
    }
}
