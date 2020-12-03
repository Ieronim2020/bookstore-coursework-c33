package by.tms.bookstorecourseworkc33.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
//@DynamicUpdate
//@DynamicInsert
//@SelectBeforeUpdate
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotBlank(message = "NameBook cannot be empty")
    @NotEmpty(message = "NameBook cannot be empty")
    @Column(name = "nameBook", length = 255, nullable = false)
    private String nameBook;

    @Column(name = "year", length = 4, nullable = false)
    private int year;

    @Column(name = "quantityPage", length = 4, nullable = false)
    private int quantityPage;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Author> authors;
}
