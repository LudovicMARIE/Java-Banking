import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.awt.event.*;

public class MainGUI extends JFrame{

    private JButton btn_Choice;
    String[] boxOptions = {"View balance","Deposit money","Withdraw money","View previous transaction"};
    JComboBox<String> Combo_Choice;
    private JPanel Pnl_MainPanel;



    static class BankAccount{
        static int balance;
        static int previousTransaction;
        static String customerName;
        static String customerId;

        BankAccount(String cname, String cid){
            customerName = cname;
            customerId = cid;
        }

        static void deposit(int amount){
            if(amount!=0){
                balance = balance + amount;
                previousTransaction = amount;
            }
        }
        static void withdraw(int amount){
            if(amount!=0){
                balance = balance - amount;
                previousTransaction = -amount;
            }
        }

        static String getPreviousTransaction(){
            if(previousTransaction > 0){
                System.out.println("Deposited : " + previousTransaction);
                return "Deposited : " + previousTransaction;
            }
            else if(previousTransaction < 0){
                System.out.println("Withdrawn : " + Math.abs(previousTransaction));
                return "Withdrawn : " + Math.abs(previousTransaction);
            }
            else{
                System.out.println("No transaction occured");
                return "No transaction occured";
            }
        }

    }




    public MainGUI (){
        setContentPane(Pnl_MainPanel);
        setTitle("Banking");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);
        setVisible(true);

        btn_Choice.setVisible(true);
        Combo_Choice.setVisible(true);
        for (String option:boxOptions){
            Combo_Choice.addItem(option);
        }
        Scanner scanner = new Scanner(System.in);

        JFrame newFrame = new JFrame("New Window");
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(300, 100);
        newFrame.setLayout(new FlowLayout());
        newFrame.setLocationRelativeTo(Pnl_MainPanel);

        JButton depositButton = new JButton("Deposit");
        JButton WithdrawButton = new JButton("Withdraw");
        JTextField textField = new JTextField(10);
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });




        btn_Choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(Objects.requireNonNull(Combo_Choice.getSelectedItem()).toString()){
                    case "View balance":
                        JOptionPane.showMessageDialog(newFrame,
                                "Your balance : "+BankAccount.balance);
                        //System.out.println("-------");
                        //int balance = BankAccount.balance;
                        //System.out.println("Balance : "+balance);
                        //System.out.println("-------");
                        //System.out.println("\n");
                        break;

                    case "Deposit money":
                        newFrame.setTitle("Deposit money");
                        depositButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int value = Integer.parseInt(textField.getText());
                                //System.out.println("The entered value is: " + value);
                                BankAccount.deposit(value);
                                JOptionPane.showMessageDialog(newFrame,
                                        "Succesfully deposited "+value);
                                newFrame.dispatchEvent(new WindowEvent(newFrame, WindowEvent.WINDOW_CLOSING));
                                textField.setText("");
                                newFrame.remove(textField);
                                newFrame.remove(depositButton);
                            }
                        });

                        newFrame.add(textField);
                        newFrame.add(depositButton);
                        newFrame.setVisible(true);


                        //System.out.println("-------");
                        //System.out.println("How much do you want to deposit ?");
                        //System.out.println("-------");
                        //int amountD = scanner.nextInt();
                        //BankAccount.deposit(amountD);
                        //System.out.println("\n");
                        break;

                    case "Withdraw money":
                        newFrame.setTitle("Withdraw money");


                        WithdrawButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int value = Integer.parseInt(textField.getText());
                                //System.out.println("The entered value is: " + value);
                                BankAccount.withdraw(value);
                                JOptionPane.showMessageDialog(newFrame,
                                        "Succesfully withdrawn "+value);
                                newFrame.dispatchEvent(new WindowEvent(newFrame, WindowEvent.WINDOW_CLOSING));
                                textField.setText("");
                                newFrame.remove(textField);
                                newFrame.remove(WithdrawButton);
                            }
                        });

                        newFrame.add(textField);
                        newFrame.add(WithdrawButton);
                        newFrame.setVisible(true);

                        //System.out.println("-------");
                        //System.out.println("How much do you want to withdraw ?");
                        //System.out.println("-------");
                        //int amountW = scanner.nextInt();
                        //BankAccount.withdraw(amountW);
                        //System.out.println("\n");
                        break;

                    case "View previous transaction":
                        JOptionPane.showMessageDialog(newFrame,
                                BankAccount.getPreviousTransaction());

                        //System.out.println("-------");
                        //BankAccount.getPreviousTransaction();
                        //System.out.println("-------");
                        //System.out.println("\n");
                        break;

                    case null:
                        System.out.println("Invalid action !");
                        break;
                    default:
                        System.out.println("Invalid action !");
                        break;
                }

                //JFrame newFrame = new JFrame("Action");
                //newFrame.setSize(300, 200);
                //newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //newFrame.setVisible(true);
            }
        });
    }



    public static void main(String[] args){
        new MainGUI();
    }

}

