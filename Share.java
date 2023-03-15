import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    private String name;
    private int numShares;
    private double sharePrice;

    public Stock(String name, int numShares, double sharePrice) {
        this.name = name;
        this.numShares = numShares;
        this.sharePrice = sharePrice;
    }

    public double getValue() {
        return numShares * sharePrice;
    }

    public String getName() {
        return name;
    }

    public Object getNumShares() {
        return null;
    }
}

class StockPortfolio {
    private ArrayList<Stock> stocks;

    public StockPortfolio() {
        stocks = new ArrayList<Stock>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getTotalValue() {
        double totalValue = 0.0;

        for (Stock stock : stocks) {
            totalValue += stock.getValue();
        }

        return totalValue;
    }

    public void printStockReport() {
        System.out.println("Stock Report:");
        System.out.println("-------------------------");

        for (Stock stock : stocks) {
            System.out.printf("%-20s%-10d$%.2f\n", stock.getName(), stock.getNumShares(), stock.getValue());
        }

        System.out.println("-------------------------");
        System.out.printf("%-20s$%.2f\n", "Total Value:", getTotalValue());
    }
}

public class Share {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of stocks: ");
        int numStocks = input.nextInt();

        StockPortfolio portfolio = new StockPortfolio();

        for (int i = 1; i <= numStocks; i++) {
            System.out.printf("Enter the details of stock #%d:\n", i);

            System.out.print("Name: ");
            String name = input.next();

            System.out.print("Number of shares: ");
            int numShares = input.nextInt();

            System.out.print("Share price: ");
            double sharePrice = input.nextDouble();

            Stock stock = new Stock(name, numShares, sharePrice);
            portfolio.addStock(stock);
        }

        portfolio.printStockReport();
    }
}


