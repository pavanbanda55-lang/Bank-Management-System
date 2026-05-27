
import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementSystem {

    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount(sc);
                    break;

                case 2:
                    depositMoney(sc);
                    break;

                case 3:
                    withdrawMoney(sc);
                    break;

                case 4:
                    viewAccount(sc);
                    break;

                case 5:
                    viewAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void createAccount(Scanner sc) {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, name, balance);

        accounts.add(account);

        System.out.println("Account Created Successfully!");
    }

    static BankAccount findAccount(int accNo) {

        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }

        return null;
    }

    static void depositMoney(Scanner sc) {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc != null) {

            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();

            acc.deposit(amount);

        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void withdrawMoney(Scanner sc) {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc != null) {

            System.out.print("Enter Withdrawal Amount: ");
            double amount = sc.nextDouble();

            acc.withdraw(amount);

        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void viewAccount(Scanner sc) {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void viewAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available!");
            return;
        }

        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();
        }
    }
}
