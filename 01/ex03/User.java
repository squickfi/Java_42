public class User {

    private int _id;
    private String _name;
    private long _balance;
    private TransactionsLinkedList _transactionsList;

    public User(String name) {
        _id = UserIdsGenerator.getInstance().generateID();
        _name = name;
        _balance = 0;
        _transactionsList = new TransactionsLinkedList();
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
        _transactionsList = new TransactionsLinkedList();
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
        _transactionsList.addTransaction(new Transaction(this, recipient, amount));
        recipient.getTransactionsList().addTransaction(new Transaction(recipient, this, -amount));
    }

    public TransactionsLinkedList getTransactionsList() {
        return _transactionsList;
    }

    public void printTransactionList() {
        System.out.printf("%s transaction list:\n", _name);
        _transactionsList.printList();
        System.out.printf("\n");
    }

    public void changeAmount(long amount) {
        _balance += amount;
    }
}
