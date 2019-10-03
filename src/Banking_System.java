import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
public class Banking_System {
    public static void main(String[] args) throws IOException {
        File balance = new File("balance.txt");
        File transactions = new File("transactions.txt");
        Scanner info = new Scanner(balance);
        String userResponse = null;
        int acctbal;
        if(info.hasNextInt()){
            acctbal = info.nextInt();
        }
        else{
            acctbal = 1000;
        }
        info = new Scanner(transactions);
        String transString = "";
        int transNumber = 0;
        while (info.hasNextLine()) {
            transString += info.nextLine() + "\n";
            transNumber++;
        }
        do {
            System.out.println("Welcome to CIS-2348 Banking System!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Option as a number: 1. Display balance summary 2. Deposit amount 3. Withdraw amount");
            String option = sc.nextLine();

            if (option.equals("1")) {
                System.out.println("Your balance is: $" + acctbal);
                System.out.print(transString);
            }//if end

            if (option.equals("2")) {
                System.out.println("How much money would you like to deposit?");
                int dep = sc.nextInt();// dep assigned to deposit amount
                acctbal += dep;
                transNumber++;
                transString += transNumber + ". Deposit $" + dep + "  $" + acctbal;
                System.out.println("New account balance: $" + acctbal);
            }//if end
            if (option.equals("3")) {
                System.out.println("How much money would you like to withdraw?");
                int wid = sc.nextInt();// wid assigned to withdraw amount
                if (wid >= acctbal) {
                    System.out.println("Insufficient balance");
                } else {
                    acctbal -= wid;
                    transNumber++;
                    transString += transNumber + ". Withdrawal $" + wid + "  $" + acctbal;
                    System.out.println("New account balance: $" + acctbal);
                }
            }//if end
            System.out.println("Do you want to make another transaction? Y or N");
            if (sc.hasNext()) userResponse = sc.next();
        } while (userResponse.equals("Y"));
        FileWriter fw = new FileWriter(balance);
        fw.write(Integer.toString(acctbal));
        fw.close();
        fw = new FileWriter(transactions);
        fw.write(transString);
        fw.close();
    }
}//class end
