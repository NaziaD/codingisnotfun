import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Banking_System {
    public static void main(String[] args) throws IOException {
        int bal = 1000;//initial balance
        PrintWriter info = new PrintWriter("info.txt");
        info.println(bal);
        System.out.println("Welcome to CIS-2348 Banking System!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Option in a number: 1. Display balance 2. Deposit amount 3. Withdraw amount");
        String option =  sc.nextLine();
        if (option.equals("1")) {
            System.out.println("Your balance is :" + bal);
        }//if end

        if (option.equals("2")) {
            System.out.println("How much money would you like to deposit?");
            int x = sc.nextInt();// x assigned to deposit amount
        info.println(x);
        }//if end

        if (option.equals("3")) {
            System.out.println("How much money would you like to withdraw?");
            int y = sc.nextInt();// y assigned to withdraw amount
        info.println(y);
        info.close();
        }//if end
    }//main end
}//class end
