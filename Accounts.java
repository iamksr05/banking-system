class Accounts {

    private String name;
    private long accountNumber;
    private long mobileNumber;
    private byte age;
    private String address;
    private double balance;
    private String password;

    Accounts(String name, long accountNumber, long mobileNumber, byte age, String address, String password) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.address = address;
        this.balance = 0;
        this.password = password;
    }
    
    String getName() {
        return name;
    }

    long getAccountNum() {
        return accountNumber;
    }

    long getMobileNum() {
        return mobileNumber;
    }

    byte getAge() {
        return age;
    }

    String getAddress() {
        return address;
    }

    double getBalance() {
        return balance;
    }

    String getPass() {
        return password;
    }



    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
        
    void updateName(String newName) {
        if (newName != null) {
            name = newName;
        }
    }
    
    void updateMobile(long newMobile) {
        if (newMobile != 0) {
            mobileNumber = newMobile;
        }
    }
        
    void updateAge(byte newAge) {
        if (newAge != 0) {
            age = newAge;
        }
    }
    
	void updateAddress(String newAddress) {
        if (newAddress != null) {
            address = newAddress;
        }
    }

    void updatePassword(String newPass) {
        if (newPass != null) {
            password = newPass;
        }
    }

    // void transfer(long targetAccount, int amount) {

    // }


}