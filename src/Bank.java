import java.util.Arrays;

public class Bank {
    private final String name;
    private BankAccount[] accounts = new BankAccount[100];
    private int numAccounts;

    public Bank(String n) {
        name = n;
    }

    public void addAccount(BankAccount bankAccount) {
        accounts[numAccounts] = bankAccount;
        numAccounts++;
    }

    public String getName() {
        return name;
    }

    public int getNumAccounts() {
        return numAccounts;
    }

    public String getAccounts() {
        StringBuilder accountList = new StringBuilder();
        for(BankAccount ba : accounts) {
            if(ba != null) {
                accountList.append(ba.getAccName());
            }
        }

        return accountList.toString();
    }

    public String toString() {
        return String.format("Name: %s\nNumber of accounts: %03d", getName(), getNumAccounts());
    }
}
