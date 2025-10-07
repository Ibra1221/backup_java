
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class q1 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Enter three numbers separated by '-': " );
        Scanner scanner = new Scanner(System.in);
        String numbers;
        String[] numbersArr;
        do {
            numbers = scanner.next();
            numbersArr = numbers.split("-");
        } while (numbersArr.length != 3);
        int num1 = Integer.parseInt(numbersArr[0]);
        int num2 = Integer.parseInt(numbersArr[1]);
        int num3 = Integer.parseInt(numbersArr[2]);
        if(num1 == num2 && num2 == num3){
            System.out.println("All equal");
        }
        else {
            if(num1 != num2 && num2 != num3 && num1 != num3){
                System.out.println("All different");
            }
            else{
                System.out.println("Neither");
            }
        }


    }
}