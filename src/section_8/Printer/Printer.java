package section_8.Printer;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.pagesPrinted = 0;
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public int addToner(int tonerAmount) {
        return tonerAmount <= 0 || tonerAmount > 100 || tonerAmount + tonerLevel > 100 ? -1 : (tonerLevel += tonerAmount);
    }

    public int printPages(int pages) {
        if (duplex) System.out.println("Printing in duplex mode");

        int pagesToPrint = (duplex) ? pages / 2 + pages % 2 : pages;
        pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }
}
