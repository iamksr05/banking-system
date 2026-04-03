class Accounts {

    private String name;
    private long accountNumber;
    private long mobileNumber;
    private byte age;
    private String address;
    private double balance;

    Accounts(String name, long accountNumber, long mobileNumber, byte age, String address) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.address = address;
        this.balance = 0;
    }
    
    String getName() {
        return name;
    }

    long getAccountNum() {
        return accountNumber;
    }

    // void deposit(int amount) {

    // }

    // void withdraw(int amount) {

    // }

    // void transfer(long targetAccount, int amount) {

    // }

    // void getBalance() {

    // }

    // void updateMobile(long newMobile) {

    // }

	// void updateAddress(String newAddress) {

    // }


}