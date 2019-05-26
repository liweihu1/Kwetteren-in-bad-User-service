package dao.JPA;

import dao.interfaces.IUserDAO;
import domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Stateless
@Default
@Named("UserDAOJPAImpl")
public class UserDAOJPAImpl implements IUserDAO {
    @PersistenceContext(unitName = "kwetterPU")
    private EntityManager em;

    public UserDAOJPAImpl() {

    }

    @Override
    public User add(User user) {
        try {
            em.persist(user);
            return user;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public boolean checkUsernameAvailable(String username) {
        List<User> u = em.createNamedQuery("user.findByUsername", User.class).setParameter("username", username).getResultList();
        return u.size() == 0;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> u = em.createNamedQuery("user.getAll", User.class).getResultList();
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User findById(UUID id) {
        try {
            return em.find(User.class, id);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            return em.createNamedQuery("user.findByUsername", User.class).setParameter("username", username).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<UUID> getUserMentions(User user) {
        //TODO ADD NAMED QUERY FOR THIS
        return null;
    }

    @Override
    public List<User> getFollowersForUserWithId(UUID id) {
        try {
            return em.createNamedQuery("user.getFollowersForId", User.class).setParameter("userId", id).getResultList();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<User> getFollowingForUserWithId(UUID id) {
        try {
            return em.createNamedQuery("user.getFollowingForId", User.class).setParameter("userId", id).getResultList();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public User update(User user) {
        try {
            return em.merge(user);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void clearData() {
        if(em.getTransaction().isActive()){
            em.clear();
        }
    }

    @Override
    public void setEm(EntityManager em){
        this.em = em;
    }
}
