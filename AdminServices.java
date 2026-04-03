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

        System.out.println("\n\nAccount created successfully!");
        System.out.println("\nAccount holder's name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address + "\n\n");

    }
    

    static void showAllAccounts(Scanner input) {
        while (true) {
            for (int i = 0; i < Bank.accounts.size(); i++) {
                System.out.println("\n=============================================\n");
                System.out.println("Name: " + Bank.accounts.get(i).getName());
                System.out.println("Account No.: " + Bank.accounts.get(i).getAccountNum());
            }
            if (Bank.accounts.size() != 0) {
                System.out.println("\n=============================================\n\n");
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
                System.err.println("\nNo bank account remaining.");
            }

            System.out.print("Enter Account Number to delete: ");
            long acNo = input.nextLong();

            int i;
            for (i = 0; i < Bank.accounts.size(); i++) {
                if (Bank.accounts.get(i).getAccountNum() == acNo) {
                    Accounts removedAc = Bank.accounts.remove(i);

                    System.out.println("\n\033[31m=============================================\n\033[0m");
                    System.out.println("\033[31mName: " + removedAc.getName() + "\033[0m");
                    System.out.println("\033[31mAccount No.: : " + removedAc.getAccountNum() + "\033[0m");
                    System.out.println("\n\033[1;31mAccount removed Successfully!\033[0m");
                    break;
                }
            }
            if (Bank.accounts.size() >= 0 && i != Bank.accounts.size()) {
                System.out.println("\n\033[31m=============================================\033[0m");
            }

            if (i == Bank.accounts.size()) {
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
