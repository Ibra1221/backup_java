import java.util.Scanner;

public class Lab2_p3 {

    public static Invoice readInvoice() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Invoice Number: ");
        int invoiceNumber = input.nextInt();
        input.nextLine();
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter the number of elements: ");
        int n = input.nextInt();
        input.nextLine();
        Double[] pricesArray = new Double[n];
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the price of " + i + ": ");
            pricesArray[i-1] = input.nextDouble();
            input.nextLine();
        }
        Invoice account = new Invoice(invoiceNumber, name, pricesArray);
        return account;
    }

    public static void main(String[] args) {
        System.out.println("Enter the data of the first account: ");
        Invoice firstAccount = readInvoice();
        System.out.println("Enter the data of the second account: ");
        Invoice secondAccount = readInvoice();
        System.out.println("The data of the first account: ");
        firstAccount.report();
        System.out.println("The data of the second account: ");
        secondAccount.report();
    }
}
