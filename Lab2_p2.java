import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Lab2_p2 {

    public static int[] getArray(int size){
        int[] data = new int[size];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i<data.length; i++){
            data[i] = input.nextInt();
        }
        return data;
    }

    public static boolean checkPrime(int number){
        if(number <= 1)
            return false;
        for(int i = 2; i< sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1;
        do {
            System.out.print("Enter the size of the first set: ");
             n1 = scan.nextInt();
        } while(n1 <= 0);
        int n2;
        do {
            System.out.print("Enter the size of the second set: ");
            n2 = scan.nextInt();
        } while(n2 <= 0);

        System.out.print("Enter the elements of the first set: ");
        int[] data1 = getArray(n1);
        System.out.print("Enter the elements of the second set: ");
        int[] data2 = getArray(n2);
        CustomSet firstSet = new CustomSet(data1);

        CustomSet secondSet = new CustomSet(data2);
        CustomSet thirdSet = firstSet.union(secondSet);

        System.out.println("The prime numbers in the union set are: ");
        for(int i = 0; i<thirdSet.getCustomData().length; i++){
            if(checkPrime(thirdSet.getCustomData()[i])){
                System.out.println(thirdSet.getCustomData()[i]);
            }
        }

    }
}
