import java.util.Scanner;

public class AdminDashboard {

    void adminOption(Scanner input) {
        while (true) {
            System.out.println("\n\n");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Update account details");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. View All Accounts");
            System.out.println("7. Logout");
            System.out.print(">>> ");
            
            int adminChoice = input.nextInt();
            
            if (adminChoice == 1) {
                AdminServices.createAccount(input);

            } else if (adminChoice == 2) {
                AdminServices.deleteAccount(input);
                
            } else if (adminChoice == 3) {
                AdminServices.updateAccountInfo(input);
                
            } else if (adminChoice == 4) {
                AdminServices.depositAmount(input);
                
            } else if (adminChoice == 5) {
                AdminServices.withdrawAmount(input);
                
            } else if (adminChoice == 6) {
                AdminServices.showAllAccounts(input);

            } else if (adminChoice == 7) {
                System.out.println("Logged out successfully!\n\n");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
