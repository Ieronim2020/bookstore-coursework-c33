package by.tms.bookstorecourseworkc33.entity.user.dto;

import by.tms.bookstorecourseworkc33.entity.user.Role;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String emailDto;

    private String passwordDto;

    private String usernameDto;

    private Set<Role> rolesDto;

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }

    public String getUsernameDto() {
        return usernameDto;
    }

    public void setUsernameDto(String usernameDto) {
        this.usernameDto = usernameDto;
    }

    public Set<Role> getRolesDto() {
        return rolesDto;
    }

    public void setRolesDto(Set<Role> rolesDto) {
        this.rolesDto = rolesDto;
    }
}
