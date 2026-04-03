import java.util.Random;
import java.util.Scanner;

public class AdminServices {
    static void createAccount(Scanner input) {

        Random random = new Random();
        long accountNumber = 10000000000L + (long) (random.nextDouble() * 90000000000L);

        input.nextLine();
        System.out.print("\n\nEnter user name: ");
        String name = input.nextLine();

        System.out.print("Enter mobile number: ");
        long mobileNumber = input.nextLong();

        System.out.print("Enter Age: ");
        byte age = input.nextByte();

        input.nextLine();
        System.out.print("Enter Address: ");
        String address = input.nextLine();

        Accounts acc = new Accounts(name, accountNumber, mobileNumber, age, address);
        Bank.addAccount(acc);

        System.out.println("\n\n\033[32m=============================================\033[0m\n");
        System.out.println("\033[1;32mAccount created successfully!\033[0m");
        System.out.println("\033[32mAccount holder's name: " + name + "\033[0m");
        System.out.println("\033[32mAccount Number: " + accountNumber + "\033[0m");
        System.out.println("\033[32mMobile Number: " + mobileNumber + "\033[0m");
        System.out.println("\033[32mAge: " + age + "\033[0m");
        System.out.println("\033[32mAddress: " + address + "\033[0m");
        System.out.println("\033[32mBalance: " + Bank.accounts.get(Bank.accounts.size() - 1).getBalance() + "\033[0m");
        System.out.println("\n\033[32m=============================================\033[0m\n\n");
        
    }
    
    static void showAllAccounts(Scanner input) {
        while (true) {
            for (int i = 0; i < Bank.accounts.size(); i++) {
                System.out.println("\n\033[34m=============================================\033[0m\n");
                System.out.println("\033[34mName: " + Bank.accounts.get(i).getName() + "\033[0m");
                System.out.println("\033[34mAccount No.: " + Bank.accounts.get(i).getAccountNum() + "\033[0m");
            }
            if (Bank.accounts.size() != 0) {
                System.out.println("\n\033[34m=============================================\033[0m\n\n");
            }

            System.out.println("<< Press any key to return to menu <<");
            System.out.print(">>> ");
            input.nextLine();
            String back = input.nextLine();

            if (back != "") {
                break;
            }

        }
    }

    static void deleteAccount(Scanner input) {
        while (true) {
            if (Bank.accounts.size() == 0) {
                System.err.println("\nNo bank account available.\n");
                break;
            } else {

                System.out.print("Enter Account Number to delete: ");
                long acNo = input.nextLong();

                int i;
                for (i = 0; i < Bank.accounts.size(); i++) {
                    if (Bank.accounts.get(i).getAccountNum() == acNo) {
                        Accounts removedAc = Bank.accounts.remove(i);

                        System.out.println("\n\033[31m=============================================\033[0m\n");
                        System.out.println("\033[31mName: " + removedAc.getName() + "\033[0m");
                        System.out.println("\033[31mAccount No.: : " + removedAc.getAccountNum() + "\033[0m");
                        System.out.println("\n\033[1;31mAccount removed Successfully!\033[0m");
                        System.out.println("\n\033[31m=============================================\033[0m\n\n");
                        break;
                    }
                }

                if (i != 0 && i == Bank.accounts.size()) {
                    System.err.println("\nAccount not found! Try Again.");
                }

                System.out.println("\n\nPress '1' to delete more accounts: ");
                System.out.println("<< Press any key to return to menu <<");
                System.out.print(">>> ");
                input.nextLine();
                String back = input.nextLine();
    
                if (back.equals("1")) {
                    continue;
                } else {
                    break;
                }
            }

        }
    }

    static void depositAmount(Scanner input) {
        while (true) {

            if (Bank.accounts.size() == 0) {
                System.err.println("\nNo bank account available.\n");
                break;
                
            } else {
                System.out.print("\nEnter account number to deposit money: ");
                long acNo = input.nextLong();

                int i;

                for (i = 0; i < Bank.accounts.size(); i++) {
                    if (Bank.accounts.get(i).getAccountNum() == acNo) {
                        System.out.println("\nEnter amount to deposit: ");
                        double amount = input.nextDouble();

                        if (Bank.accounts.get(i).getBalance() + amount > Double.MAX_VALUE) {
                            System.out.println("Can't deposit " + amount + " to " + Bank.accounts.get(i).getName() + "'s account.");
                            System.out.println("Try less amount to deposit.");
                            break;

                        } else if (Bank.accounts.get(i).getBalance() == Double.MAX_VALUE) {
                            System.out.println("Maximum limit reached!");
                            System.out.println("Can't deposit more amount to " + Bank.accounts.get(i).getName() + "'s account.");

                        } else {
                            Bank.accounts.get(i).deposit(amount);
                            System.out.println("\n\033[32m₹"+ amount + " deposited successfully to " + Bank.accounts.get(i).getName() + "'s account\033[0m\n");
                        }
                        break;
                    }
                }

                if (i != 0 && i == Bank.accounts.size()) {
                    System.err.println("\nAccount not found! Try Again.");
                }

                System.out.println("\n\nPress '1' to see account balance and return to menu.");
                System.out.println("<< Press any key to return to menu <<");
                System.out.print(">>> ");
                input.nextLine();
                String back = input.nextLine();
    
                if (back.equals("1")) {
                    System.out.println("\n\033[34mAccount balance: " + Bank.accounts.get(i).getBalance() + "\033[0m\n");
                    break;
                } else {
                    break;
                }
            }

        }
    }


    static void withdrawAmount(Scanner input) {
        
    }
    
}
