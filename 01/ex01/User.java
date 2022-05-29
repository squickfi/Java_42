public class User {

    private int _id;
    private String _name;
    private long _balance;

    public User(String name) {
        _id = UserIdsGenerator.getInstance().generateID();
        _name = name;
        _balance = 0;
    }

    public User(String name, long balance) {
        _id = UserIdsGenerator.getInstance().generateID();
        _name = name;
        if (balance >= 0) {
            _balance = balance;
        }
        else {
            _balance = 0;
        }
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public long getBalance() {
        return _balance;
    }

    public void makeTransaction(long amount, User recipient) {
        if (amount < 0) {
            if (recipient.checkBalance(amount)) {
                _balance -= amount;
                recipient.changeAmount(amount);
            }
        }
        else {
            if (_balance - amount >= 0) {
                _balance -= amount;
                recipient.changeAmount(amount);
            }
        }
    }

    public boolean checkBalance(long amount) {
        if (_balance + amount >= 0) {
            return true;
        }
        return false;
    }

    public void changeAmount(long amount) {
        _balance += amount;
    }
}
