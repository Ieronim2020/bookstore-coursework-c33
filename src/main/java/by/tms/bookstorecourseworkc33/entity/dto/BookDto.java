package by.tms.bookstorecourseworkc33.entity.dto;

import by.tms.bookstorecourseworkc33.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @NotBlank(message = "NameBook cannot be empty")
    @NotEmpty(message = "NameBook cannot be empty")
    @Length(min = 3, max = 255, message = "Length 3 - 255")
    private String nameBookDto;

    @NotBlank(message = "Year cannot be empty")
    @NotEmpty(message = "Year cannot be empty")
    @Length(min = 3, max = 4, message = "Length 3 - 4")
    private int yearDto;

    @NotBlank(message = "QuantityPage cannot be empty")
    @NotEmpty(message = "QuantityPage cannot be empty")
    @Length(min = 4, max = 2000, message = "Length 4 - 2000")
    private int quantityPageDto;

    @NotBlank(message = "Price cannot be empty")
    @NotEmpty(message = "Price cannot be empty")
    private BigDecimal priceDto;

    private Author authorDto;
}
