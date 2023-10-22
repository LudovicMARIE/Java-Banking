import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //BankAccount acc1 = new BankAccount("Billy","1");
        //acc1.showMenu();


    }
}

class old_BankAccount {


    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    old_BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount){
        if(amount!=0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount){
        if(amount!=0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited : " + previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("Withdrawn : " + Math.abs(previousTransaction));
        }
        else{
            System.out.println("No transaction occured");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println("\n");
        System.out.println("A- View balance");
        System.out.println("B- Deposit money");
        System.out.println("C- Withdraw money");
        System.out.println("D- View previous transaction");
        System.out.println("E- Exit");

        do {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Choose an action");
            System.out.println("---------------------------------------------------------------");
            option = scanner.next().charAt(0);

            switch(option){
                case 'A':
                    System.out.println("-------");
                    System.out.println("Balance : "+balance);
                    System.out.println("-------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("-------");
                    System.out.println("How much do you want to deposit ?");
                    System.out.println("-------");
                    int amountD = scanner.nextInt();
                    deposit(amountD);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("-------");
                    System.out.println("How much do you want to withdraw ?");
                    System.out.println("-------");
                    int amountW = scanner.nextInt();
                    withdraw(amountW);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("-------");
                    getPreviousTransaction();
                    System.out.println("-------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.print("");
                    break;
                default:
                    System.out.println("Invalid action !");
                    break;

            }
        }while(option != 'E');
        try
        {
            System.out.print("Exiting.");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
