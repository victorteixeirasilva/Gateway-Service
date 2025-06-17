package tech.inovasoft.inevolving.api.domain.model;

public enum UserRole {
    USER("user"), ADMIN("admin");
    
    private String role;


    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
