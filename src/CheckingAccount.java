public class CheckingAccount extends BankAccount{
    private double fee;

    public CheckingAccount (String name, int accountNumber, double balance, double fee) {
        super(name, accountNumber, balance);
        setFee(fee);
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("Fee can't be negative");
        } else {
            this.fee = fee;
        }
    }
    @Override
    public void deposit(double amount) {
        super.deposit(amount - fee);
    }
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + fee);
    }

    @Override
    public double getBalance() {
        return super.getBalance() - fee;
    }
}
