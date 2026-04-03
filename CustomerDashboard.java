import java.util.Scanner;

public class CustomerDashboard {

    void CustomerOption(Scanner input) {
        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. View account details");
            System.out.println("3. Transfer money");
            System.out.println("4. View transaction history");
            System.out.println("5. Update mobile number");
            System.out.println("6. Update address");
            System.out.println("7. Logout");
            
            int adminChoice = input.nextInt();
            
            if (adminChoice == 1) {

            } else if (adminChoice == 2) {

            } else if (adminChoice == 3) {

            } else if (adminChoice == 4) {

            } else if (adminChoice == 5) {

            } else if (adminChoice == 6) {
                
            } else if (adminChoice == 7) {
                System.out.println("Logged out successfully!");
                break;
            }


        }
    }
}
