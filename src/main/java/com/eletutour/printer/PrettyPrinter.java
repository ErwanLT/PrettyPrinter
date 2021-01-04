package com.eletutour.printer;

import org.apache.commons.lang.StringUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import static com.eletutour.printer.PrinterConstants.*;

public class PrettyPrinter {

    public PrettyPrinter(){}

    public void printDecorator(String message, String decorator){
        if(StringUtils.isNotEmpty(decorator)){
            print(decorator + " " + message + " " + decorator);
        } else {
            print(DECORATOR + " " + message + " " + DECORATOR);
        }
    }

    public void print(String message){
        System.out.println("[" + getTime() + "] " + message);
    }

    public void printInfoDecorator(String message, String decorator){
        if(StringUtils.isNotEmpty(decorator)){
            printInfo(decorator + " " + message + " " + decorator);
        } else {
            printInfo(DECORATOR + " " + message + " " + DECORATOR);
        }
    }

    public void printInfo(String message){
        System.out.println(ANSI_LIGHT_BLUE + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    public void printSuccessDecorator(String message, String decorator){
        if(StringUtils.isNotEmpty(decorator)){
            printSuccess(decorator + " " + message + " " + decorator);
        } else {
            printSuccess(DECORATOR + " " + message + " " + DECORATOR);
        }
    }

    public void printSuccess(String message){
        System.out.println(ANSI_GREEN + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    public void printErrorDecorator(String message, String decorator){
        if(StringUtils.isNotEmpty(decorator)){
            printError(decorator + " " + message + " " + decorator);
        } else {
            printError(DECORATOR + " " + message + " " + DECORATOR);
        }
    }

    public void printError(String message){
        System.out.println(ANSI_RED + "[" + getTime() + "] " + ANSI_RESET + message);
    }

    private String getTime() {
        return Instant.now().truncatedTo(ChronoUnit.MILLIS).toString().replaceAll("[TZ]", " ");
    }
}
