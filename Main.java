import java.util.Scanner;

class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Login signin = new Login();

        
        while (true) {
            System.out.println("Welcome to PW Bank. Login as\n1. Admin\n2. Customer\n3. Exit");
            int choice = input.nextInt();

            if (choice == 1) {
                signin.adminPass(input);
                
            } else if (choice == 2) {
                signin.customerPass(input);

            } else if (choice == 3) {
                break;

            } else {
                System.out.println("Invalid Choice. Enter correct choice: ");
            }

        }
    }
}


class Login {

    void adminPass(Scanner input) {
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

    void customerPass(Scanner input) {
        System.out.println("Enter your user ID: ");
        int userId = input.nextInt();
        
        System.out.println("Enter your user Password: ");
        int userPass = input.nextInt();

        if (userId != 2 && userPass != 2) {
            CustomerDashboard customerDash = new CustomerDashboard();
            customerDash.CustomerOption(input);

        } else {
            System.out.println("Incorrect credentials. Try again!");
        }
    }
}