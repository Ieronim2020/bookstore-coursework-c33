package by.tms.bookstorecourseworkc33.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "SEQUENCE_USERS", allocationSize = 1, initialValue = 1)
    @GenericGenerator(name = "cmrSeq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @NotEmpty(message = "Password cannot be empty")
    @Length(min = 3, max = 255, message = "Length 3 - 255")
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @NotBlank(message = "Username cannot be empty")
    @NotEmpty(message = "Username cannot be empty")
    @Length(min = 3, max = 50, message = "Length 3 - 50")
    @Column(name = "name", length = 50, nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}