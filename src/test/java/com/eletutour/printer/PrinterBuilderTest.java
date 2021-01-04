package com.eletutour.printer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrinterBuilderTest {

    public static final String HELLO_WORLD = "Hello World";
    private static PrinterBuilder builder;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void init(){
        builder = new PrinterBuilder();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown(){
        System.setOut(standardOut);
    }

    @Test
    public void testBuilderInfo(){
        builder.builder(PrinterType.INFO, "Hello World", "*****");
        Assert.assertTrue(outputStreamCaptor.toString().contains("*****"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;34m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains(HELLO_WORLD));
    }

    @Test
    public void testBuilderSuccess(){
        builder.builder(PrinterType.SUCCESS, HELLO_WORLD, "^^^^^");
        Assert.assertTrue(outputStreamCaptor.toString().contains("^^^^^"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;32m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains(HELLO_WORLD));
    }

    @Test
    public void testBuilderError(){
        builder.builder(PrinterType.ERROR, HELLO_WORLD, "====");
        Assert.assertTrue(outputStreamCaptor.toString().contains("===="));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("[1;31m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("] \u001B[0m"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains(HELLO_WORLD));
    }

    @Test
    public void testBuilderStandard(){
        builder.builder(PrinterType.STANDARD, HELLO_WORLD, "++++++++++");
        Assert.assertTrue(outputStreamCaptor.toString().contains("++++++++++"));
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains(HELLO_WORLD));
    }
}
