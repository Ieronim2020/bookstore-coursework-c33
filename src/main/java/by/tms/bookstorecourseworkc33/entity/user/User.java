package by.tms.bookstorecourseworkc33.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "varchar(20) default 'USER'")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", columnDefinition = "varchar(20) default 'ACTIVE'")
    private Status status;
}
