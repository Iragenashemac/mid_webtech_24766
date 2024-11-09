package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "User")   
public class User extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", columnDefinition = "CHAR(36)", nullable = false)
    private UUID userId;  // Hibernate will handle UUID generation

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;  // Store the hashed password

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;  // Enum for user roles

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id", referencedColumnName = "locationId")
    private Location village;

    // Default constructor
    public User() {}

    // Convenience constructor
    public User(String username, String password, Role role, Location village) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.village = village;
    }

    // Getters and Setters
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Location getVillage() {
        return village;
    }

    public void setVillage(Location village) {
        this.village = village;
    }
}
