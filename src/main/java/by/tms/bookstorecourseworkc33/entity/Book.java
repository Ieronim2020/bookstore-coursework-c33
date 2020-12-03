package by.tms.bookstorecourseworkc33.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

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
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Book {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKS_SEQ")
//    @SequenceGenerator(name = "BOOKS_SEQ", sequenceName = "SEQUENCES_BOOK", allocationSize = 1, initialValue = 1)
//    @GenericGenerator(name = "cmrSeq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
