public class UsersArrayList implements UsersList {

    private User[] _array;
    private int _size;
    private int _capacity;

    public UsersArrayList() {
        _array = new User[10];
        _size = 0;
        _capacity = 10;
    }

    private void increaseCapacity() {
        User[] tmp = new User[_capacity + _capacity / 2];
        for (int i = 0; i < _size; ++i) {
            tmp[i] = _array[i];
        }
        _array = tmp;
        _capacity += _capacity / 2;
    }

    public void addUser(User user) {
        if (_size == _capacity) {
            increaseCapacity();
        }
        _array[_size] = user;
        ++_size;
    }

    public User retrieveUserById(int id) {
        for (int i = 0; i < _size; ++i) {
            if (_array[i].getId() == id) {
                return _array[i];
            }
        }
        throw new UserNotFoundException("User can't be fount with this id");
    }

    public User retrieveUserByIndex(int index) {
        if (index < 0 || index > _size - 1) {
            throw new UserNotFoundException("User can't be fount with this index");
        }
        return _array[index];
    }

    public int retrieveNumberOfUsers() {
        return _size;
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String massage) {
            super(massage);
        }
    }
}
