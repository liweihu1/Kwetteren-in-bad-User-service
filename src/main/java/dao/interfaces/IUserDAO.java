package dao.interfaces;

import domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public interface IUserDAO {
    /**
     * Add a new user to the database.
     * @param user The user to persist.
     * @return the user if it passed else return null.
     */
    User add(User user);

    /**
     * Gets the user based on the given username and password
     * @param username the username
     * @param password the password
     * @return the user if found, else null
     */
    User getUserByUsernameAndPassword(String username, String password);

    /**
     * Deletes the given user from the database.
     * @param user The user to delete.
     */
    void delete(User user);

    /**
     * Checks if the username is available.
     * @param username the username to check.
     * @return true or false.
     */
    boolean checkUsernameAvailable(String username);

    /**
     * Gets all the users from the database.
     * @return all the users.
     */
    List<User> getAllUsers();

    /**
     * Updates the information of a user.
     * @param user The updated user.
     * @return the user if it succeeded else return null.
     */
    User update(User user);

    /**
     * Finds an user with the given ID.
     * @param id The ID of the user.
     * @return the User if found, else return null.
     */
    User findById(UUID id);

    /**
     * Find user by username;
     * @param username the username of the user;
     * @return user if found.
     */
    User findByUsername(String username);

    /**
     * Get all the Kweets that the user has been mentioned in.
     * @param user The user to find.
     * @return A list of all the Kweets the user is mentioned in.
     */
    List<UUID> getUserMentions(User user);

    /**
     * Get all the users that the user with the given id is followed by.
     * @param id The user id.
     * @return List of all the users that are following the user.
     */
    List<User> getFollowersForUserWithId(UUID id);

    /**
     * Get all the users that the user with the given id is following.
     * @param id The user id.
     * @return List of all the users that are being followed.
     */
    List<User> getFollowingForUserWithId(UUID id);

    /**
     * Clears the data.
     */
    void clearData();

    void setEm(EntityManager em);
}
