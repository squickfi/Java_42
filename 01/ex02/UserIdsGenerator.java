public class UserIdsGenerator {

    private static UserIdsGenerator instance = new UserIdsGenerator();
    private UserIdsGenerator() {}

    private static int idToGenerate = 0;

    public static UserIdsGenerator getInstance() {
        return instance;
    }

    int generateID() {
        return idToGenerate++;
    }
}
