public class TransactionsLinkedList implements TransactionsList {

    private class TransactionListNode {

        private TransactionListNode _next;
        private TransactionListNode _previous;
        private Transaction _transaction;

        public TransactionListNode(TransactionListNode next, TransactionListNode previous, Transaction transaction) {
            _next = next;
            _previous = previous;
            _transaction = transaction;
        }

        public TransactionListNode getNext() { return _next; }
        public TransactionListNode getPrevious() { return _previous; }
        public Transaction getTransaction() { return _transaction; }
        public void setNext(TransactionListNode newNext) { _next = newNext; }
        public void setPrevious(TransactionListNode newPrevious) { _previous = newPrevious; }
        public void setTransaction(Transaction newTransaction) { _transaction = newTransaction; }
    }

    TransactionListNode first = new TransactionListNode(null, null, null);;
    TransactionListNode last = new TransactionListNode(null, null, null);;

    public TransactionsLinkedList() {
        first.setNext(last);
        last.setPrevious(first);
    }

    public void addTransaction(Transaction transaction) {

        TransactionListNode newNode = new TransactionListNode(first.getNext(), first, transaction);
        first.getNext().setPrevious(newNode);
        first.setNext(newNode);
    }

    public void removeTransactionById(String id) {
        TransactionListNode tmp = first.getNext();
        for (; tmp != last; tmp = tmp.getNext()) {
            if (tmp.getTransaction().getId() == id) {
                tmp.getPrevious().setNext(tmp.getNext());
                tmp.getNext().setPrevious(tmp.getPrevious());
                return;
            }
        }
        throw new TransactionNotFoundException("Transaction can't be found!");
    }

    public Transaction[] toArray() {
        TransactionListNode tmp = first.getNext();
        int i = 0;
        for (; tmp != last; tmp = tmp.getNext(), ++i);
        Transaction[] array = new Transaction[i];
        tmp = first.getNext();
        i = 0;
        for (; tmp != last; tmp = tmp.getNext(), ++i) {
            array[i] = tmp.getTransaction();
        }
        return array;
    }

    public void printList() {
        TransactionListNode tmp = first.getNext();
        for (; tmp != last; tmp = tmp.getNext()) {
            tmp.getTransaction().printTransactionInfo();
        }
    }

    public static class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String massage) {
            super(massage);
        }
    }
}
