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
        System.out.println("Enter your account number: ");
        int userAcc = input.nextInt();
        
        System.out.println("Enter your user Password: ");
        int userPass = input.nextInt();

        boolean found = false;
        for (int i = 0; i < Bank.accounts.size(); i++) {
            if (userAcc == Bank.accounts.get(i).getAccountNum()) {
                found = true;

            }
        }

        if (userAcc != 2 && userPass != 2) {
            CustomerDashboard customerDash = new CustomerDashboard();
            customerDash.CustomerOption(input);

        } else {
            System.out.println("Incorrect credentials. Try again!");
        }
    }
}