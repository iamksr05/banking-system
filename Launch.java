import java.util.Scanner;

class Launch {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        while (true) {
            System.out.print("\n\nWelcome to PW Bank. Login as\n1. Admin\n2. Customer\n3. Exit\n>>> ");
            int choice = input.nextInt();

            if (choice == 1) {
                Login.adminPass(input);
                
            } else if (choice == 2) {
                Login.customerPass(input);

            } else if (choice == 3) {
                break;

            } else {
                System.out.println("Invalid Choice. Enter correct choice: ");
            }

        }
    }
}
