import java.util.Scanner;

public class CustomerDashboard {

    void CustomerOption(Scanner input, Accounts user) {
        while (true) {
            System.out.println("\n\n1. Check Balance");
            System.out.println("2. View account details");
            System.out.println("3. Transfer money");
            System.out.println("4. View transaction history");
            System.out.println("5. Logout");
            System.out.print(">>> ");
            
            int adminChoice = input.nextInt();
            
            if (adminChoice == 1) {
                CustomerServices.checkBalance(user);

            } else if (adminChoice == 2) {
                CustomerServices.getUserInfo(user);

            } else if (adminChoice == 3) {
                CustomerServices.amountTransfer(input, user);

            } else if (adminChoice == 4) {
                
            } else if (adminChoice == 5) {
                System.out.println("Logged out successfully!");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }


        }
    }
}
