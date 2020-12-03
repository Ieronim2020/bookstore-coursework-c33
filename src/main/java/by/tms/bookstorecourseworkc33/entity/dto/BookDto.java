package by.tms.bookstorecourseworkc33.entity.dto;

import by.tms.bookstorecourseworkc33.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@DynamicUpdate
//@DynamicInsert
//@SelectBeforeUpdate
public class BookDto {
    @NotBlank(message = "NameBookDto cannot be empty")
    @NotEmpty(message = "NameBookDto cannot be empty")
    @Length(min = 3, max = 255, message = "Length 3 - 255")
    private String nameBookDto;

    @Length(min = 3, max = 4, message = "Length 3 - 4")
    private int yearDto;

    @Length(min = 4, max = 4, message = "Length 4 - 2000")
    private int quantityPageDto;

    @Size(min = 1, message = "min 1")
    private BigDecimal priceDto;

    private List<Author> authors;
}
