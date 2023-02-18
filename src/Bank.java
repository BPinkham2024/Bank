import java.util.Scanner;

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
                accountList.append(ba).append("\n");
            }
        }

        return accountList.substring(0, accountList.length() - 2);
    }

    public BankAccount findAccount(int pin) {
        for (BankAccount account : accounts) {
            if (account != null && account.pinMatch(pin)) {
                return account;
            }
        }
        return null;
    }

    public static void deposit(BankAccount ba) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        System.out.print("\n\nHow much would you like to deposit: $");
        try {
            ba.deposit(reader.nextDouble());
        } catch(Exception e) {
            System.out.println("That is not a valid number");
            Thread.sleep(1000);
        }
    }

    public static void withdraw(BankAccount ba) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        System.out.print("\n\nHow much would you list to withdraw: $");
        try {
            ba.withdraw(reader.nextDouble());
        } catch(Exception e) {
            System.out.println("That is not a valid number");
            Thread.sleep(1000);
        }
    }

    public String toString() {
        return String.format("Name: %s\nNumber of accounts: %03d", getName(), getNumAccounts());
    }
}
