import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab2_p4 {

    public static Invoice readInvoiceFromUser(int invoiceNumber, Scanner input) {
        System.out.println("Enter Name: ");
        String customerName = input.nextLine();
        System.out.println("Enter number of products: ");
        int numberOfProducts = input.nextInt();
        input.nextLine();
        Double[] prices =  new Double[numberOfProducts];
        for (int i = 1; i <= numberOfProducts; i++) {
            System.out.println("Enter product #" + i + " price: ");
            prices[i-1] = input.nextDouble();
            input.nextLine();
        }
        Invoice invoice = new Invoice(invoiceNumber, customerName, prices);
        return invoice;
    }

    public static Invoice[] readInvoiceDetailsFromFile(String fileName){
        File invoicesFile = new File(fileName);
        int size;
        Scanner myReader = null;
        try {
            myReader = new Scanner(invoicesFile);
            size = myReader.nextInt();
            myReader.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Invoice[] invoiceDetails = new Invoice[size];
        for(int i = 0; i<size; i++){
            String line =  myReader.nextLine();
            String[] data = line.split(",");
            int pricesCount = 0;
            int flag = 0;
            int invoiceNumber = 0;
            String customerName = "";
            Double[] pricesArr = null;
           for(int j = 0; j<8; j++){
                switch (j){
                    case 0:

                         invoiceNumber = Integer.parseInt(data[0].split(" ")[data[0].split(" ").length-1]);
                        break;
                    case 1:
                         customerName= data[1];
                        break;
                    case 2:
                        pricesCount = Integer.parseInt(data[2]);
                        break;
                    default:
                         pricesArr = new Double[pricesCount];
                        for(int k = 0; k<pricesCount-1; k++){
                            pricesArr[k] = Double.parseDouble(data[k+3]);
                        }
                        String[] priceLine = data[pricesCount-1+3].split(" ");
                        pricesArr[pricesCount-1] = Double.parseDouble(priceLine[0]);
                        flag = 1;
                        break;
                }
                if(flag == 1){
                    invoiceDetails[i] = new Invoice(invoiceNumber,customerName,pricesArr);
                    break;
                }
           }
        }
        return invoiceDetails;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        Invoice[] invoiceDetails = readInvoiceDetailsFromFile(fileName);

        boolean swapped = false;
        for (int i = 0; i < invoiceDetails.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < invoiceDetails.length - i - 1; j++) {
                if (invoiceDetails[j].calculateInvoice() < invoiceDetails[j + 1].calculateInvoice()) {
                    Invoice temp = invoiceDetails[j];
                    invoiceDetails[j] = invoiceDetails[j + 1];
                    invoiceDetails[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println("Person with the largest cost: " + invoiceDetails[0].getCustomerName());
        File invoicesFile = new File(fileName);
        int size;
        Scanner myReader = null;
        try {
            myReader = new Scanner(invoicesFile);
            size = myReader.nextInt();
            myReader.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Invoice newInvoice = readInvoiceFromUser(size + 1, input);
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        if (!lines.isEmpty()) {
            // Modify the first line
            lines.set(0, String.valueOf(size + 1)); // for example, change first line to "10"
        }

        // Write all lines back to the same file
        Files.write(Paths.get(fileName), lines);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n")
                    .append("the line ")
                    .append(newInvoice.getInvoiceNumber()).append(",")
                    .append(newInvoice.getCustomerName()).append(",")
                    .append(newInvoice.getPrices().length);
            for (double p : newInvoice.getPrices()) {
                sb.append(",").append(p);
            }

            sb.append(" represent data of a banking account whose number is ")
                    .append(newInvoice.getInvoiceNumber()).append(", owner name is ")
                    .append(newInvoice.getCustomerName()).append(" and the (")
                    .append(newInvoice.getPrices().length).append(" products) prices ")
                    .append(Arrays.toString(newInvoice.getPrices()))
                    .append(" which means total cost before discount is ")
                    .append(newInvoice.calculateTotal());

            writer.append(sb.toString());
        }
    }
}
