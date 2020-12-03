package by.tms.bookstorecourseworkc33.entity.dto;

import by.tms.bookstorecourseworkc33.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    @NotBlank(message = "FirstnameDto cannot be empty")
    @NotEmpty(message = "FirstnameDto cannot be empty")
    @Length(min = 3, max = 50, message = "Length 3 - 50")
    private String firstNameDto;

    @NotBlank(message = "LastnameDto cannot be empty")
    @NotEmpty(message = "LastnameDto cannot be empty")
    @Length(min = 3, max = 100, message = "Length 3 - 100")
    private String lastNameDto;

    private Book book;
}
