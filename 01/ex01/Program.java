public class Program {

    private static void printUserInfo(User user) {
        System.out.printf("User: id == %d, name == %s, balance == %d\n",
                user.getId(), user.getName(), user.getBalance());
    }

    private static void printTransactionInfo(User sender, User receiver, long amount) {
        System.out.printf("%s sends %d to %s\n",
                sender.getName(), amount, receiver.getName());
    }

    public static void main(String[] args) {
        User user1 = new User("John1", 5000);
        User user2 = new User("John2", 5000);
        User user3 = new User("John3", 5000);
        printUserInfo(user1);
        printUserInfo(user2);
        printUserInfo(user3);
        printTransactionInfo(user2, user1, 1000);
        printTransactionInfo(user2, user3, -1300);
        user2.makeTransaction(1000, user1);
        user2.makeTransaction(-1300, user3);
        printUserInfo(user1);
        printUserInfo(user2);
        printUserInfo(user3);
    }
}
