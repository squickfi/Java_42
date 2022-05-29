import java.util.UUID;

public class Transaction {

    private UUID _id;
    private User _recipient;
    private User _sender;
    private String _transferCategory;
    private String _transferStatus;
    private long _transferAmount;

    private final String CREDIT = "CREDIT";
    private final String DEBIT = "DEBIT";
    private final String FAIL = "FAIL";
    private final String SUCCESS = "SUCCESS";

    public Transaction(User actor, User acted, long amount) {
        _id = UUID.randomUUID();
        if (amount < 0) {
            _transferCategory = CREDIT;
            _transferAmount = -amount;
        }
        else {
            _transferCategory = DEBIT;
            _transferAmount = amount;
        }
        _sender = actor;
        _recipient = acted;
        if ((_transferCategory == CREDIT && acted.getBalance() + amount >= 0) ||
                (_transferCategory == DEBIT && actor.getBalance() - amount >= 0)) {
            acted.changeAmount(amount);
            actor.changeAmount(-amount);
            _transferStatus = SUCCESS;
        }
        else {
            _transferStatus = FAIL;
        }
    }

    public void printTransactionInfo() {

        char sign1;
        char sign2;
        String come1;
        String come2;
        if (_transferCategory == DEBIT) {
            sign1 = '-';
            sign2 = '+';
            come1 = "OUTCOME";
            come2 = "INCOME";
        }
        else {
            sign2 = '-';
            sign1 = '+';
            come2 = "OUTCOME";
            come1 = "INCOME";
        }

        System.out.printf("%s -> %s, %c%d, %s, status: %s, id: %s\n",
                _sender.getName(), _recipient.getName(), sign1, _transferAmount, come1, _transferStatus, _id.toString());
        System.out.printf("%s -> %s, %c%d, %s, status: %s, id: %s\n",
                _recipient.getName(), _sender.getName(), sign2, _transferAmount, come2, _transferStatus, _id.toString());
    }

    public String getId() {
        return _id.toString();
    }
}
