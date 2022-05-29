public class Program {

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

        System.out.printf("Adding 13 users:\n");
        UsersArrayList usersList = new UsersArrayList();
        for (int i = 0; i < 13; ++i) {
            usersList.addUser(new User("John" + i, i * 1000));
        }
        printUsersList(usersList);
        usersList.retrieveUserById(7).makeTransaction(3200, usersList.retrieveUserById(0)).printTransactionInfo();
        usersList.retrieveUserById(2).makeTransaction(-350, usersList.retrieveUserById(5)).printTransactionInfo();
        System.out.printf("\n");
        printUserInfo(usersList.retrieveUserById(7));
        printUserInfo(usersList.retrieveUserById(0));
        printUserInfo(usersList.retrieveUserById(2));
        printUserInfo(usersList.retrieveUserById(5));
    }
}
