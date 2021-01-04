[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5f36b815c5c74cf4969d70730778da51)](https://app.codacy.com/gh/ErwanLT/PrettyPrinter?utm_source=github.com&utm_medium=referral&utm_content=ErwanLT/PrettyPrinter&utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/ErwanLT/PrettyPrinter.svg?branch=main)](https://travis-ci.org/ErwanLT/PrettyPrinter)
[![codecov](https://codecov.io/gh/ErwanLT/PrettyPrinter/branch/main/graph/badge.svg?token=TL01JSTFYO)](https://codecov.io/gh/ErwanLT/PrettyPrinter)

# PrettyPrinter
## Simple printer
* `print(String message)`
* `printInfo(String message)`
* `printSuccess(String message)`
* `printError(String message)`

[![](img/prettyPrint.png)]()

## With decorator
* `printDecorator(String message)`
* `printInfoDecorator(String message)`
* `printSuccessDecorator(String message)`
* `printErrorDecorator(String message)`

[![](img/prettyPrinter_decorator.png)]()

## Using the builder
* `builder(PrinterType type, String message, String decorator)`

* PrinterType (Enum):
  * STANDARD
  * INFO
  * SUCCESS
  * ERROR
* decorator
  * the string that will surcharge the standard decorator, if empty or null will be `------`
  
[![](img/prettyPrinter_builder.png)]()