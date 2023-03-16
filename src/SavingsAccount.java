public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount (String name, int accountNumber, double balance, double interestRate) {
        super(name, accountNumber, balance);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            System.out.println("Can't be negative");
        } else {
            this.interestRate = interestRate;
        }
    }
    @Override
    public void deposit(double amount) {
        super.deposit(amount + interestRate);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount - interestRate);
    }
    @Override
    public double getBalance() {
        return super.getBalance() + getInterestRate();
    }
}
