package by.tms.bookstorecourseworkc33.entity.user.dto;

import by.tms.bookstorecourseworkc33.entity.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String emailDto;

    @NotBlank(message = "Password cannot be empty")
    @NotEmpty(message = "Password cannot be empty")
    @Length(min = 3, max = 255, message = "Length 3 - 255")
    @Column(name = "password", length = 255, nullable = false)
    private String passwordDto;

    @NotBlank(message = "Username cannot be empty")
    @NotEmpty(message = "Username cannot be empty")
    @Length(min = 3, max = 50, message = "Length 3 - 50")
    @Column(name = "name", length = 50, nullable = false)
    private String usernameDto;

    private Set<Role> rolesDto;
}
