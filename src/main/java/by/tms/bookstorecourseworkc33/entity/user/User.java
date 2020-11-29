package by.tms.bookstorecourseworkc33.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    @NotBlank(message = "Username cannot be empty")
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @NotBlank(message = "Username cannot be empty")
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "varchar(20) default 'USER'")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", columnDefinition = "varchar(20) default 'ACTIVE'")
    private Status status;
}
