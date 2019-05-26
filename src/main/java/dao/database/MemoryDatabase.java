package dao.database;


import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryDatabase {
    private static MemoryDatabase instance;
    protected List<User> users;

    public MemoryDatabase(){
        clearData();
    }

    public void clearData(){
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUserById(UUID id){
        return this.users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public User getUserByUsername(String username){
        return this.users.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public static MemoryDatabase getInstance(){
        if (instance == null){
            instance = new MemoryDatabase();
        }
        return instance;
    }
}
