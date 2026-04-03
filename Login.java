import java.util.Scanner;

class Login {

    static void adminPass(Scanner input) {
        System.out.print("\nEnter your admin ID: ");
        int adminId = input.nextInt();
        
        System.out.print("Enter your Password: ");
        int adminPass = input.nextInt();

        if (adminId == 1 && adminPass == 1) {
            AdminDashboard adminDash = new AdminDashboard();
            adminDash.adminOption(input);
        } else {
            System.out.println("Incorrect credentials. Try again!");
        }
    }

    static void customerPass(Scanner input) {
        System.out.print("\nEnter your account number: ");
        long userAcc = input.nextLong();
        input.nextLine();
        
        System.out.print("Enter your user Password: ");
        String userPass = input.nextLine();

        boolean found = false;
        for (int i = 0; i < Bank.accounts.size(); i++) {
            if (userAcc == Bank.accounts.get(i).getAccountNum()) {
                found = true;

                if (userPass.equals(Bank.accounts.get(i).getPass())) {
                    CustomerDashboard cust = new CustomerDashboard();
                    cust.CustomerOption(input, Bank.accounts.get(i));
                    break;
                }
                
                System.out.println("Incorrect password!");
                break;

            }

            if(!found) {
                System.out.println("Account not found!");
            }
        }

    }
}