import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) throws InterruptedException {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter your bank name: ");
        Bank bank = new Bank(reader.nextLine());

        while(true) {
            clearScreen();
            System.out.printf("""
                    --------------------------%s--------------------------
                    1. Add account
                    2. Admin Login
                    3. Account Login
                    4. Exit
                    
                    Option:\s""", bank.getName());

            int choice;
            try {
                choice = reader.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter your name: ");
                        BankAccount account = new BankAccount(reader.next());
                        bank.addAccount(account);
                        System.out.println("Your pin to login is: " + account.getPin());
                        Thread.sleep(5000);
                        clearScreen();
                    }
                    case 2 -> {
                        clearScreen();
                        System.out.print("Enter the admin pin: ");
                        if (reader.nextInt() == 99999) {
                            boolean shouldRun = true;
                            while(shouldRun) {
                                clearScreen();
                                System.out.printf("""
                                    --------------------------%s Admin Console--------------------------
                                    1. View all accounts
                                    2. Change an account balance
                                    3. Leave
                                    
                                    Option:\s""", bank.getName());

                                switch(reader.nextInt()) {
                                    case 1 -> {
                                        System.out.println("\n\n" + bank.getAccounts());
                                        System.out.println("Press enter to continue...");
                                        reader.next();
                                    }
                                    case 2 -> {
                                        System.out.print("\n\nEnter the account pin: ");
                                        int accPin = reader.nextInt();

                                        if(bank.findAccount(accPin) != null) {
                                            clearScreen();
                                            BankAccount ba = bank.findAccount(accPin);

                                            System.out.printf("""
                                            The current balance of the account is %.02f.
                                            Would you like to:
                                            
                                            1. Deposit
                                            2. Withdraw
                                            3. Change the balance manually
                                            4. Leave
                                            
                                            Option:\s""", ba.getBalance());

                                            switch(reader.nextInt()) {
                                                case 1 -> {
                                                    Bank.deposit(ba);
                                                    System.out.printf("The balance is now %.02f", ba.getBalance());
                                                    Thread.sleep(5000);
                                                }
                                                case 2 -> {
                                                    Bank.withdraw(ba);
                                                    System.out.printf("Your balance is now %.02f", ba.getBalance());
                                                    Thread.sleep(5000);
                                                }
                                                case 3 -> {
                                                    System.out.print("\n\nWhat would you like to change the balance to: ");
                                                    try {
                                                        ba.setBalance(reader.nextDouble());
                                                        System.out.printf("The balance is now %.02f", ba.getBalance());
                                                    } catch(Exception e) {
                                                        System.out.println("That is not a valid number");
                                                    }
                                                    Thread.sleep(5000);
                                                }
                                            }
                                        } else {
                                            System.out.println("That is not a valid pin");
                                            Thread.sleep(1000);
                                        }
                                    }
                                    case 3 -> shouldRun = false;
                                }
                            }
                        }
                    }
                    case 3 -> {
                        System.out.print("\n\nEnter your pin: ");
                        try {
                            int accPin = reader.nextInt();
                            if(bank.findAccount(accPin) != null) {
                                clearScreen();
                                BankAccount ba = bank.findAccount(accPin);

                                System.out.printf("""
                                        Hello, %s, what would you like to do...
                                        
                                        1. Deposit
                                        2. Withdraw
                                        3. Leave
                                        
                                        Option:\s""", ba.getAccName());

                                try {
                                    switch(reader.nextInt()) {
                                        case 1 -> {
                                            Bank.deposit(ba);
                                            System.out.printf("Your balance is now %.02f", ba.getBalance());
                                            Thread.sleep(5000);
                                        }
                                        case 2 -> {
                                            Bank.withdraw(ba);
                                            System.out.printf("Your balance is now %.02f", ba.getBalance());
                                            Thread.sleep(5000);
                                        }
                                    }
                                } catch(Exception e) {
                                    System.out.println("That is not a valid number");
                                    Thread.sleep(1000);
                                }

                            } else {
                                System.out.println("That is not a valid pin");
                                Thread.sleep(1000);
                            }

                        } catch(Exception e) {
                            System.out.println("That is not a valid number");
                            Thread.sleep(1000);
                        }
                    }
                    case 4 -> {
                        System.out.println("Have a good day!");
                        System.exit(0);
                    }
                }

            } catch(Exception e) {
                System.out.println("Not a valid choice");
                Thread.sleep(1000);
            }
        }
    }

    public static void clearScreen() {
        for(int i = 0; i < 10; i++) {
            System.out.println();
        }
    }


}