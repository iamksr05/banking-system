public class CustomerServices {
    static void checkBalance(Accounts user) {
        System.out.println("\n\n\033[1;37mBalance: \033[0m" + "₹" + user.getBalance() + "\n");
    }

    static void getUserInfo(Accounts user) {
        System.out.println("\n\033[1;37mName: \033[0m" + user.getName());
        System.out.println("\033[1;37mAccount Number: \033[0m" + user.getAccountNum());
        System.out.println("\033[1;37mMobile Number: \033[0m" + user.getMobileNum());
        System.out.println("\033[1;37mAge: \033[0m" + user.getAge());
        System.out.println("\033[1;37mAddress: \033[0m" + user.getAddress());
    }

    static void amountTransfer() {
        System.out.println("Enter account number: ");
        

    }

}
