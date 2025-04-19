/*
Background: A multi-functional printer can print, scan, copy, and fax. However, some models are simpler
and only support printing and scanning, while others support all four functions.
The printer's interface should not force simpler models to implement unnecessary methods.

Question: How would you design interfaces for the printer functions?*/

interface Printable {
    public void print();
}

interface Scannable {
    public void scan();
}

interface Copyable {
    public void copy();
}

interface Faxable {
    public void fax();
}

class MultiFunctionalPrinter implements Printable, Scannable, Copyable, Faxable {
    public void print() {
    }

    public void scan() {
    }

    public void copy() {
    }

    public void fax() {
    }
}

class SimplePrinter implements Printable, Scannable {
    public void print() {
    }

    public void scan() {
    }
}