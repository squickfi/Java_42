public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransactionById(String id);
    Transaction[] toArray();
}
