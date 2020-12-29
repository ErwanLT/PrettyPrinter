package com.eletutour.printer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrettyPrinterTest {

    private static PrettyPrinter printer;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void init(){
        printer = new PrettyPrinter();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown(){
        System.setOut(standardOut);
    }

    @Test
    public void testPrintMessage(){
        printer.print("Hello World");
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Hello World"));
    }

    @Test
    public void testPrinterSuccess(){
        printer.printSuccess("Succes");
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;32m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Succes"));
    }

    @Test
    public void testPrinterError(){
        printer.printError("Error");
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;31m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Error"));
    }

    @Test
    public void testPrinterInfo(){
        printer.printInfo("Info");
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;34m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Info"));
    }

    @Test
    public void testPrinterInfoDecorator(){
        printer.printInfoDecorator("Info");
        Assert.assertTrue(outputStreamCaptor.toString().contains("------"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;34m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Info"));
    }

    @Test
    public void testPrinterErrorDecorator(){
        printer.printErrorDecorator("Error");
        Assert.assertTrue(outputStreamCaptor.toString().contains("------"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;31m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Error"));
    }

    @Test
    public void testPrinterSuccessDecorator(){
        printer.printSuccessDecorator("Succes");
        Assert.assertTrue(outputStreamCaptor.toString().contains("------"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;32m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Succes"));
    }

    @Test
    public void testPrintDecorator(){
        printer.printDecorator("Hello World");
        Assert.assertTrue(outputStreamCaptor.toString().contains("------"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Hello World"));
    }
}
