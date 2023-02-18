public class BankAccount {

    private final String accName;
    private double balance;
    private final int pin = (int) (9999 * Math.random() + 1000);

    public BankAccount(String n) {
        accName = n;
    }

    public boolean pinMatch(int inPin) {
        return inPin == pin;
    }

    public void withdraw(double draw) {
        if(balance > draw) {
            balance -= draw;
        }
    }

    public void deposit(double dep) {
        balance += dep;
    }

    public String getAccName() {
        return accName;
    }

    public void setBalance(double bal) {
        balance = bal;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public String toString() {
        return String.format("""
                \nName: %s
                Pin: %04d
                Balance: %.02f""", accName, pin, balance);
    }
}
