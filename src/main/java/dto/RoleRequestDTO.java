package dto;

import java.util.List;
import java.util.UUID;

public class RoleRequestDTO {
    private UUID id;
    private List<String> roles;

    public RoleRequestDTO(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
