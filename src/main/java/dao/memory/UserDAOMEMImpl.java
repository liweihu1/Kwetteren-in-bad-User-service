package dao.memory;

import dao.database.MemoryDatabase;
import dao.interfaces.IUserDAO;
import domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Stateless
@Alternative
public class UserDAOMEMImpl implements IUserDAO {
    private MemoryDatabase database;

    public UserDAOMEMImpl(){
        this.database = MemoryDatabase.getInstance();
    }

    @Override
    public User add(User user) {
        try{
            database.getUsers().add(user);
            return user;
//            return database.getUserByUsername(user.getUsername());
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void delete(User user) {
        try{
            database.getUsers().remove(user);
        } catch (Exception e){
            // TODO LOGGER
        }
    }

    @Override
    public boolean checkUsernameAvailable(String username) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return database.getUsers();
    }

    @Override
    public User update(User user) {
        database.getUsers().remove(database.getUserById(user.getId()));
        database.getUsers().add(user);
        return user;
    }

    @Override
    public User findById(UUID id) {
        return database.getUserById(id);
    }

    @Override
    public User findByUsername(String username) {
        return database.getUserByUsername(username);
    }

    @Override
    public List<UUID> getUserMentions(User user) {
        return null;
    }

    @Override
    public List<User> getFollowersForUserWithId(UUID id) {
        return null;
    }

    @Override
    public List<User> getFollowingForUserWithId(UUID id) {
        return null;
    }

    @Override
    public void clearData() {
        database.clearData();
    }

    @Override
    public void setEm(EntityManager em){
        // TODO
    }
}
