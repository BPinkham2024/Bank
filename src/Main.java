import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int adminPin = 99999;

        System.out.print("Enter your bank name: ");
        Bank bank = new Bank(reader.nextLine());

        while(true) {
            System.out.printf("""
                    --------------------------%s--------------------------
                    1. Add account
                    2. Admin Login
                    3. Account Login""", bank.getName());

            int choice = 0;
            try {
                choice = reader.nextInt();

                switch(choice) {
                    case 1:
                        System.out.print("Enter your name: ");
                        BankAccount account = new BankAccount(reader.nextLine());
                        bank.addAccount(account);
                        System.out.println("Your pin to login is: " + account.getPin());
                        break;

                    case 2:
                        System.out.print("Enter the admin pin: ");
                        if(reader.nextInt() == adminPin) {
                            System.out.println("""
                                    Hello admin, what would you like to do...
                                    1. View all accounts
                                    2. Change an account balance
                                    3. """);
                        }

                }







            } catch(Exception e) {
                System.out.println("Not a valid choice");
            }
        }
    }
}