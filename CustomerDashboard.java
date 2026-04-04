import java.util.Scanner;

public class CustomerDashboard {

    void CustomerOption(Scanner input, Accounts user) {
        System.out.println("\n\n\033[1;37mWelcome to PW Bank " + user.getName() + "!\033[0m");
        while (true) {

            System.out.println("\n1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View account details");
            System.out.println("4. Transfer money");
            System.out.println("5. View transaction history");
            System.out.println("6. Logout");
            System.out.print(">>> ");
            
            int adminChoice = input.nextInt();
            
            if (adminChoice == 1) {
                CustomerServices.checkBalance(user);

            } else if (adminChoice == 2) {
                CustomerServices.withdrawMoney(input, user);
                
            } else if (adminChoice == 3) {
                CustomerServices.getUserInfo(user);
                
            } else if (adminChoice == 4) {
                CustomerServices.amountTransfer(input, user);
                
            } else if (adminChoice == 5) {
                
            } else if (adminChoice == 6) {
                System.out.println("\nLogged out successfully!");
                break;
            } else {
                System.out.println("\nInvalid choice! Try again.");
            }


        }
    }
}
