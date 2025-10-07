import java.util.Arrays;

public class Invoice {
    private int invoiceNumber;
    private String customerName;
    private Double[] prices;

    public Invoice(int invoiceNumber, String customerName, Double[] prices) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.prices = prices;
    }
    public int getInvoiceNumber() {
        return invoiceNumber;
    }
    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Double[] getPrices() {
        return prices;
    }
    public void setPrices(Double[] prices) {
        this.prices = prices;
    }

    public void report(){
        System.out.println("Account Number: " + invoiceNumber);
        System.out.println("Name: " + customerName);
        System.out.printf("Total Cost: %.2f\n", calculateTotal());
        System.out.printf("The total cost after discount = %.2f\n", calculateInvoice());
    }

    public double calculateTotal(){
        double totalPrice = 0;
        for (double price : prices) {
            totalPrice += price;
        }
        return totalPrice;
    }

    public double calculateInvoice(){
        double totalPrice = 0;
        for (double price : prices) {
            totalPrice += price;
        }
        if(totalPrice >= 10000){
            totalPrice = totalPrice - totalPrice*0.08;
        }

        else if(totalPrice >= 8000){
            totalPrice = totalPrice - totalPrice*0.06;
        }
        else if(totalPrice >= 5000){
            totalPrice = totalPrice - totalPrice*0.04;
        }
        else if(totalPrice >= 1000){
            totalPrice = totalPrice - totalPrice*0.01;
        }
        return totalPrice;
    }
}
