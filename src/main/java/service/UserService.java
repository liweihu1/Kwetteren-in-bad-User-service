package service;

import dao.interfaces.IUserDAO;
import domain.Role;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;

@Stateless
public class UserService {
    @EJB(beanName = "UserDAOJPAImpl")
    private IUserDAO userDAO;

    public User getUserByUsernameAndPassword(String username, String password) {
        return userDAO.getUserByUsernameAndPassword(username, password);
    }

    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User getUserById(UUID id){
        return userDAO.findById(id);
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public User createUser(User user){
        return this.userDAO.add(user);
    }

    public User updateUser(User user) {
        return this.userDAO.update(user);
    }

    public User changeUsername(String username, String userId){
        if (userDAO.checkUsernameAvailable(username)){
            User user = userDAO.findById(UUID.fromString(userId));
            if (user != null){
                user.setUsername(username);
                return userDAO.update(user);
            }
        }
        return null;
    }

    public User deleteUserById(UUID id){
        User userToDelete = userDAO.findById(id);
        userDAO.delete(userToDelete);
        return userToDelete;
    }

    public User followUserWithId(UUID userId, UUID followId){
        User curUser = userDAO.findById(userId);
        User userToFollow = userDAO.findById(followId);
        return followUser(curUser, userToFollow);
    }

    public User followUserWithUsername(UUID userId, String username){
        User curUser = userDAO.findById(userId);
        User followUser = userDAO.findByUsername(username);
        return followUser(curUser, followUser);
    }

    public User addRolesToUser(UUID userId, List<Role> roles){
        User user = userDAO.findById(userId);
        for(Role r : roles) {
            if (!user.getRoles().contains(r)){
                user.getRoles().add(r);
            }
        }
        userDAO.update(user);
        return user;
    }

    public User unFollowUserWithUsername(UUID userId, String username){
        User curUser = userDAO.findById(userId);
        User followUser = userDAO.findByUsername(username);
        return stopFollowingUser(curUser, followUser);
    }

    public User unFollowUserWithId(UUID userId, UUID followId){
        User curUser = userDAO.findById(userId);
        User followUser = userDAO.findById(followId);
        return stopFollowingUser(curUser, followUser);
    }

    public List<User> getFollowersForUserWithId(UUID id){
        return userDAO.getFollowersForUserWithId(id);
    }

    public List<User> getFollowingForUserWithId(UUID id){
        return userDAO.getFollowingForUserWithId(id);
    }

    private User stopFollowingUser(User follower, User following){
        try {
            follower.getFollowing().remove(following);
            following.getFollowers().remove(follower);
            userDAO.update(follower);
            userDAO.update(following);
            return follower;
        } catch (Exception e){
            return null;
        }
    }

    private User followUser(User follower, User following){
        try {
            if (following != follower && !follower.getFollowing().contains(following)) {
                follower.getFollowing().add(following);
                following.getFollowers().add(follower);
                userDAO.update(follower);
                userDAO.update(following);
                return follower;
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }
}
