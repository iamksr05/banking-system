import java.util.ArrayList;
import java.util.List;

public class Bank {
    static List<Accounts> accounts = new ArrayList<>();

    static void addAccount(Accounts acc) {
        accounts.add(acc);
    }
}
