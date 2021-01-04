package com.eletutour.printer;

public class PrinterBuilder {

    private PrettyPrinter printer;

    public PrinterBuilder() {
        this.printer = new PrettyPrinter();
    }

    public void builder(PrinterType type, String message, String decorator){
        switch (type) {
            case STANDARD:
                printer.printDecorator(message, decorator);
                break;
            case SUCCESS:
                printer.printSuccessDecorator(message, decorator);
                break;
            case ERROR:
                printer.printErrorDecorator(message, decorator);
                break;
            case INFO:
                printer.printInfoDecorator(message, decorator);
                break;
        }
    }
}
