import java.util.*;

class Account {
    String holderName;
    int accountNumber;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();

    Account(String holderName, int accountNumber) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        transactions.add("Account created.");
    }

    void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
        System.out.println("Amount deposited.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: " + amount);
            System.out.println("Amount withdrawn.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void showTransactions() {
        System.out.println("--- Transaction History ---");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        Account acc = new Account(name, accNo);

        int choice;
        do {
            System.out.println("\n(Day 5) Bank Menu ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();
                    acc.withdraw(wit);
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 4:
                    acc.showTransactions();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);

        sc.close();
    }
}
