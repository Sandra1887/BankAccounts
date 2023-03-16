public class BankAccount {
    private String name;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int accountNumber, double balance) {
        setName(name);
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Wrong input");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        if (accountNumber < 0) {
            throw new IllegalArgumentException("Wrong input");
        } else {
            this.accountNumber = accountNumber;
        }
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("The balance can't be negative");
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Not enough money in the account");
        } else {
            this.balance -= amount;
        }
    }
}
