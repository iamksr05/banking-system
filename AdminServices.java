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
        
        System.out.print("Enter Password: ");
        String password = input.nextLine();




        Accounts acc = new Accounts(name, accountNumber, mobileNumber, age, address, password);
        Bank.addAccount(acc);

        System.out.println("\n\n\033[32m=============================================\033[0m\n");
        System.out.println("\033[1;32mAccount created successfully!\033[0m");
        System.out.println("\033[32mAccount holder's name: " + name + "\033[0m");
        System.out.println("\033[32mAccount Number: " + accountNumber + "\033[0m");
        System.out.println("\033[32mMobile Number: " + mobileNumber + "\033[0m");
        System.out.println("\033[32mAge: " + age + "\033[0m");
        System.out.println("\033[32mAddress: " + address + "\033[0m");
        System.out.println("\033[32mBalance: " + Bank.accounts.get(Bank.accounts.size() - 1).getBalance() + "\033[0m");
        System.out.println("\033[32mPassword: ********\033[0m");
        System.out.println("\n\033[32m=============================================\033[0m\n\n");

    }

    static void deleteAccount(Scanner input) {
        while (true) {
            if (Bank.accounts.size() == 0) {
                System.err.println("\nNo bank account available.\n");
                break;
            } else {

                System.out.print("Enter Account Number to delete: ");
                long acNo = input.nextLong();

                boolean found = false;
                int i;
                for (i = 0; i < Bank.accounts.size(); i++) {
                    if (Bank.accounts.get(i).getAccountNum() == acNo) {
                        found = true;
                        Accounts removedAc = Bank.accounts.remove(i);

                        System.out.println("\n\033[31m=============================================\033[0m\n");
                        System.out.println("\033[31mName: " + removedAc.getName() + "\033[0m");
                        System.out.println("\033[31mAccount No.: : " + removedAc.getAccountNum() + "\033[0m");
                        System.out.println("\n\033[1;31mAccount removed Successfully!\033[0m");
                        System.out.println("\n\033[31m=============================================\033[0m\n\n");
                        break;
                    }
                }

                if (!found) {
                    System.err.println("\nAccount not found! Try Again.");
                }

                System.out.println("\n\nPress '1' to delete more accounts.");
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

    static void updateAccountInfo(Scanner input) {

        while (true) {
            boolean found = false;
            if (Bank.accounts.size() == 0) {
                System.err.println("\nNo bank account available.\n");
                break;
            } else {

                System.out.print("\nEnter Account Number to update account details: ");
                long acNo = input.nextLong();

                int i;
                for (i = 0; i < Bank.accounts.size(); i++) {
                    if (Bank.accounts.get(i).getAccountNum() == acNo) {
                        found = true;

                        String newName = null;
                        long newMobile = 0;
                        byte newAge = 0;
                        String newAddress = null;
                        String newPass = null;

                        int choice;
                        while (true) {

                            System.out.println("\n\nChoose any number to edit:");
                            System.out.println("1. Name");
                            System.out.println("2. Mobile Number");
                            System.out.println("3. Age");
                            System.out.println("4. Address");
                            System.out.println("5. Password");
                            System.out.println("6. Cancel");
                            System.out.print(">>> ");

                            choice = input.nextInt();
                            input.nextLine();

                            if (choice == 1) {
                                System.out.print("Enter new name: ");
                                newName = input.nextLine();

                            } else if (choice == 2) {
                                System.out.print("Enter new mobile no.: ");
                                newMobile = input.nextLong();
                                input.nextLine();

                            } else if (choice == 3) {
                                System.out.print("Enter new age: ");
                                newAge = input.nextByte();
                                input.nextLine();

                            } else if (choice == 4) {
                                System.out.print("Enter new address: ");
                                newAddress = input.nextLine();
                                
                            } else if (choice == 5) {
                                System.out.print("Enter new Password: ");
                                newPass = input.nextLine();

                            } else if (choice == 6) {
                                System.out.println("\nModification Cancelled!\n");
                                break;
                            } else {
                                System.out.println("\nIncorrect option!\n");
                                break;
                            }

                            System.out.print("Do you want to make any other changes? (y/n): ");
                            if (input.nextLine().trim().equalsIgnoreCase("y")) {
                                continue;
                            } else {
                                break;
                            }

                        }

                        Accounts userAc = Bank.accounts.get(i);
                        if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {

                            userAc.updateName(newName);
                            userAc.updateMobile(newMobile);
                            userAc.updateAge(newAge);
                            userAc.updateAddress(newAddress);
                            userAc.updatePassword(newPass);

                            System.out.println("\n\n\033[33m=============================================\033[0m\n");
                            System.out.println("\033[1;33mAccount detail(s) updated successfully!\033[0m");
                            System.out.println("\033[33mAccount holder's name: " + userAc.getName() + "\033[0m");
                            System.out.println("\033[33mAccount Number: " + userAc.getAccountNum() + "\033[0m");
                            System.out.println("\033[33mMobile Number: " + userAc.getMobileNum() + "\033[0m");
                            System.out.println("\033[33mAge: " + userAc.getAge() + "\033[0m");
                            System.out.println("\033[33mAddress: " + userAc.getAddress() + "\033[0m");
                            System.out.println("\033[33mPassword: ********\033[0m");
                            System.out.println("\n\033[33m=============================================\033[0m\n\n");
                            break;
                        }
                        break;
                    }
                }
                if (!found) {
                    System.err.println("\nAccount not found! Try Again.");
                }
            }

            if (found) {
                System.out.println("\n\nPress '1' to update account details of another accounts. ");
            }
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

    static void depositAmount(Scanner input) {
        while (true) {

            if (Bank.accounts.size() == 0) {
                System.err.println("\nNo bank account available.\n");
                break;

            } else {
                System.out.print("\nEnter account number to deposit money: ");
                long acNo = input.nextLong();

                boolean found = false;
                int i;

                for (i = 0; i < Bank.accounts.size(); i++) {
                    if (Bank.accounts.get(i).getAccountNum() == acNo) {
                        found = true;
                        System.out.print("\nEnter amount to deposit: ");
                        double amount = input.nextDouble();
                        if (amount <= 0) {
                            System.out.println("\033[31mInvalid amount!\033[0m");
                            break;
                        }

                        if (Bank.accounts.get(i).getBalance() + amount > Double.MAX_VALUE) {
                            System.out.println("Can't deposit " + amount + " to " + Bank.accounts.get(i).getName()
                                    + "'s account.");
                            System.out.println("Try less amount to deposit.");
                            break;

                        } else if (Bank.accounts.get(i).getBalance() == Double.MAX_VALUE) {
                            System.out.println("\n\033[1;31mMaximum limit reached!\033[0m");
                            System.out.println(
                                    "Can't deposit more amount to " + Bank.accounts.get(i).getName() + "'s account.");

                        } else {
                            Bank.accounts.get(i).deposit(amount);
                            System.out.println("\n\033[32m₹" + amount + " deposited successfully to "
                                    + Bank.accounts.get(i).getName() + "'s account\033[0m\n");
                            break;
                        }
                        break;
                    }
                }

                if (!found) {
                    System.err.println("\nAccount not found! Try Again.");
                }

                if (found) {
                    System.out.println("\n\nPress '1' to see account balance and return to menu.");
                }
                System.out.println("<< Press any key to return to menu <<");
                System.out.print(">>> ");
                input.nextLine();
                String back = input.nextLine();

                if (back.equals("1") && found) {
                    System.out.println("\n\033[34mAccount balance: " + Bank.accounts.get(i).getBalance() + "\033[0m\n");
                    break;
                } else {
                    break;
                }
            }

        }
    }

    static void withdrawAmount(Scanner input) {
        while (true) {

            if (Bank.accounts.size() == 0) {
                System.err.println("\nNo bank account available.\n");
                break;

            } else {
                System.out.print("\nEnter account number to withdraw money: ");
                long acNo = input.nextLong();

                boolean found = false;
                int i;

                for (i = 0; i < Bank.accounts.size(); i++) {
                    if (Bank.accounts.get(i).getAccountNum() == acNo) {
                        found = true;
                        System.out.print("\nEnter amount to withdraw: ");
                        double amount = input.nextDouble();
                        if (amount <= 0) {
                            System.out.println("\033[31mInvalid amount!\033[0m");
                            break;
                        }

                        if (Bank.accounts.get(i).getBalance() - amount <= 0) {
                            System.out.println("\n\033[1;31mInsufficient balance.\033[0m");
                            break;

                        } else {
                            Bank.accounts.get(i).withdraw(amount);
                            System.out.println("\n\033[31m₹" + amount + " withdrawn successfully from "
                                    + Bank.accounts.get(i).getName() + "'s account\033[0m\n");
                            break;
                        }
                    }
                }

                if (!found) {
                    System.err.println("\nAccount not found! Try Again.");
                }

                if (found) {
                    System.out.println("\n\nPress '1' to see account balance and return to menu.");
                }
                System.out.println("<< Press any key to return to menu <<");
                System.out.print(">>> ");
                input.nextLine();
                String back = input.nextLine();

                if (back.equals("1") && found) {
                    System.out.println("\n\033[34mAccount balance: " + Bank.accounts.get(i).getBalance() + "\033[0m\n");
                    break;
                } else {
                    break;
                }
            }

        }
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

            if (!back.equals("")) {
                break;
            }

        }
    }

}
