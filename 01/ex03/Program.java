public class Program {

    private static final int TRANSACTION_TRIES = 3;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static void printUserInfo(User user) {
        System.out.printf("User: id == %d, name == %s, balance == %d\n",
                user.getId(), user.getName(), user.getBalance());
    }

    private static void printUsersList(UsersArrayList list) {
        int size = list.retrieveNumberOfUsers();
        for (int i = 0; i < size; ++i) {
            printUserInfo(list.retrieveUserByIndex(i));
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {

        System.out.printf(ANSI_GREEN + "Adding 13 users:" + ANSI_RESET + "\n");
        UsersArrayList usersList = new UsersArrayList();
        for (int i = 0; i < 13; ++i) {
            usersList.addUser(new User("John" + i, i * 1000));
        }
        printUsersList(usersList);

        for (int i = 0; i < TRANSACTION_TRIES; ++i) {
            usersList.retrieveUserById(7).makeTransaction(3200, usersList.retrieveUserById(0));
            usersList.retrieveUserById(2).makeTransaction(-350, usersList.retrieveUserById(5));
        }
        System.out.printf(ANSI_GREEN + "John7, John2 made transactions" + ANSI_RESET + "\n");
        usersList.retrieveUserById(7).printTransactionList();
        usersList.retrieveUserById(0).printTransactionList();
        usersList.retrieveUserById(2).printTransactionList();
        usersList.retrieveUserById(5).printTransactionList();

        System.out.printf(ANSI_GREEN + "John7, John0, John2 and John5 now:" + ANSI_RESET + "\n");
        printUserInfo(usersList.retrieveUserById(7));
        printUserInfo(usersList.retrieveUserById(0));
        printUserInfo(usersList.retrieveUserById(2));
        printUserInfo(usersList.retrieveUserById(5));

        System.out.printf(ANSI_GREEN + "\nOne of John7 transactions from .toArray():" + ANSI_RESET + "\n");
        usersList.retrieveUserById(7).getTransactionsList().toArray()[0].printTransactionInfo();
    }
}
