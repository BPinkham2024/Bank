public class BankAccount {

    private String accName;
    private double balance;
    private int pin = (int) (9999 * Math.random() + 1000);;

    public BankAccount(String n) {
        accName = n;
    }

    public BankAccount(String n, double bal) {
        accName = n;
        balance = bal;
    }

    public boolean pinMatch(int inPin) {
        return inPin == pin;
    }

    public double withdraw(double draw) {
        if(balance > draw) {
            balance -= draw;
        }
        return balance;
    }

    public double deposit(double dep) {
        balance += dep;
        return balance;
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
}
