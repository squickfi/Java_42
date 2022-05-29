public class User {

    private static int _id_cast = 0;
    private int _id;
    private String _name;
    private long _balance;

    public User(String name) {
        _id = _id_cast;
        ++_id_cast;
        _name = name;
        _balance = 0;
    }

    public User(String name, long balance) {
        _id = _id_cast;
        ++_id_cast;
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

    public Transaction makeTransaction(long amount, User recipient) {
        return new Transaction(this, recipient, amount);
    }

    public void changeAmount(long amount) {
        _balance += amount;
    }
}
