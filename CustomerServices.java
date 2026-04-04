import java.util.Scanner;

public class CustomerServices {
    static void checkBalance(Accounts user) {
        System.out.println("\n\n\033[1;37mBalance: \033[0m" + "₹" + user.getBalance() + "\n");
    }

    static void withdrawMoney(Scanner input, Accounts user) {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("\033[31mInvalid amount!\033[0m");
        } else if (user.getBalance() - amount <= 0) {
            System.out.println("\n\033[1;31mInsufficient balance.\033[0m");

        } else {
            user.withdraw(amount);
            System.out.println("\n\033[31m₹" + amount + " withdrawn successfully\033[0m\n");
        }
    }

    static void getUserInfo(Accounts user) {
        System.out.println("\n\033[1;37mName: \033[0m" + user.getName());
        System.out.println("\033[1;37mAccount Number: \033[0m" + user.getAccountNum());
        System.out.println("\033[1;37mMobile Number: \033[0m" + user.getMobileNum());
        System.out.println("\033[1;37mAge: \033[0m" + user.getAge());
        System.out.println("\033[1;37mAddress: \033[0m" + user.getAddress());
    }

    static void amountTransfer(Scanner input, Accounts user) {
        while (true) {

            System.out.print("\nEnter account number: ");
            long targetAccNum = input.nextLong();

            boolean found = false;
            for (int i = 0; i < Bank.accounts.size(); i++) {
                if (targetAccNum == Bank.accounts.get(i).getAccountNum()) {
                    found = true;

                    System.out.print("Enter Amount to transfer: ");
                    int amount = input.nextInt();
                    input.nextLine();

                    Accounts selfAcc = user;
                    Accounts targetAcc = Bank.accounts.get(i);
                    if (selfAcc.getBalance() - amount < 0) {
                        System.out.println("\n\033[1;37mInsufficient Balance!\033[0m\n");
                        break;
                    }

                    if (targetAcc.getBalance() + amount > Long.MAX_VALUE) {
                        System.out.println("\nClose to maximum amount limit! Try less amount.\n");
                        break;
                    }

                    selfAcc.withdraw(amount);
                    targetAcc.deposit(amount);

                    System.out.print(
                            "\n\033[33m₹" + amount + " transferred sucessfully to " + targetAcc.getName()
                                    + ".\033[0m\n");
                }
            }

            if (!found) {
                System.out.println("Reciever account not found!");
            }

            System.out.println("\n\nPress '1' to transfer more amount to other account.");
            System.out.println("<< Press any key to return to menu <<");
            System.out.print(">>> ");
            String back = input.nextLine();

            if (back.trim().equals("1") && found) {
                continue;
            } else {
                break;
            }

        }
    }

}
