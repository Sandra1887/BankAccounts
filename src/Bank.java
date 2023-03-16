import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Bank {
    ArrayList<BankAccount> accounts = new ArrayList<>();

    public int createAccount(double balance) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Custumer name?");
        String name = sc.nextLine();
        System.out.println("The new account number?");
        int numb = sc.nextInt();
        BankAccount account = new BankAccount(name, numb, balance);
        accounts.add(account);
        return numb;
    }

    public void getAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNumber()) {
                System.out.println(accounts.get(i).getName() + "\nBalance: " + accounts.get(i).getBalance());
            }
        }
    }

    public void deposit(int accountNumber, double amount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNumber()) {
                accounts.get(i).deposit((amount));

            } else {
                System.out.println("Can't find the account");
            }
        }
    }

    public void withdraw(int accountNumber, double amount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNumber()) {
                if (accounts.get(i).getBalance() > amount) {
                    accounts.get(i).withdraw(amount);
                } else {
                    System.out.println("Not enough money in the account");
                }
            } else {
                System.out.println("Can't find the account");
            }
        }
    }

    public double getBalance(int accountNumber) {
        double balance = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accountNumber == accounts.get(i).getAccountNumber()) {
                balance = accounts.get(i).getBalance();
            } else {
                System.out.println("Can't find the account");
            }
        }
        return balance;
    }
    boolean exit = false;
    public void run() {
        while (!exit) {
            Locale.setDefault(Locale.US);
            System.out.println("Welcome to the bank. What would you like to do today?");
            Menu.showMainMenu();
            int choice = Menu.askForNumber(1, 5);
            switch (choice) {
                case 1 -> {
                    Menu.showAccountMenu();
                    Scanner sc = new Scanner(System.in);
                    int newChoice = Menu.askForNumber(1, 3);
                    if (newChoice == 1) {
                        System.out.println("Balance for the new account?");
                        createAccount(sc.nextDouble());
                    } else if (newChoice == 2) {
                        System.out.println("Name?");
                        String name = sc.nextLine();
                        System.out.println("Account number?");
                        int accNumb = sc.nextInt();
                        System.out.println("Balance?");
                        double balance = sc.nextDouble();
                        System.out.println("Fee?");
                        double fee = sc.nextDouble();
                        BankAccount chAccount = new CheckingAccount(name, accNumb, balance, fee);
                        accounts.add(chAccount);
                    } else if (newChoice == 3) {
                        System.out.println("Name?");
                        String nam = sc.nextLine();
                        System.out.println("Account number?");
                        int accNum = sc.nextInt();
                        System.out.println("Balance?");
                        double balanc = sc.nextDouble();
                        System.out.println("Interest rate?");
                        double intRate = sc.nextDouble();
                        BankAccount savAccount = new SavingsAccount(nam, accNum, balanc, intRate);
                        accounts.add(savAccount);
                    }
                }
                    /*} else {
                        exit = true;
                    }*/
                case 2 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Account number?");
                    int accNumb = sc.nextInt();
                    getAccount(accNumb);
                }
                case 3 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Account number?");
                    int accNumb = sc.nextInt();
                    System.out.println("Amount to deposit?");
                    double amount = sc.nextDouble();
                    deposit(accNumb, amount);
                }
                case 4 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Account number?");
                    int accNumb = sc.nextInt();
                    System.out.println("Amount to withdraw?");
                    double amount = sc.nextDouble();
                    withdraw(accNumb, amount);
                }
                case 5 -> exit = true;
            }
        }
    }
}

