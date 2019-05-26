package dto;

import domain.Role;
import domain.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String biography;
    private String website;
    private String location;
    private Set<String> following;
    private Set<String> followers;
    private List<String> roles;
    private int kweets;

    public UserDTO(){
        //EMPTY CONSTRUCTOR FOR JSON CALLS
    }

    public UserDTO(User user) {
        this.id = user.getId().toString();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.biography = user.getBiography();
        this.website = user.getWebsite();
        this.location = user.getLocation();
        this.following = new HashSet<>();
        this.followers = new HashSet<>();
        this.roles = new ArrayList<>();
        this.kweets = user.getKweets().size();

        for(Role r : user.getRoles()){
            this.roles.add(r.toString());
        }

        for(User u : user.getFollowing()) {
            this.following.add(u.getUsername());
        }

        for(User u: user.getFollowers()) {
            this.followers.add(u.getUsername());
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public int getKweets() {
        return kweets;
    }

    public void setKweets(int kweets) {
        this.kweets = kweets;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void setFollowing(Set<String> following) {
        this.following = following;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<String> followers) {
        this.followers = followers;
    }
}
