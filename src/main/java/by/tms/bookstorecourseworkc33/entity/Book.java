package by.tms.bookstorecourseworkc33.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @NotBlank(message = "Year cannot be empty")
    @NotEmpty(message = "Year cannot be empty")
    @Column(name = "year", length = 4, nullable = false)
    private int year;

    @NotBlank(message = "QuantityPage cannot be empty")
    @NotEmpty(message = "QuantityPage cannot be empty")
    @Column(name = "quantityPage", length = 4, nullable = false)
    private int quantityPage;

    @NotBlank(message = "Price cannot be empty")
    @NotEmpty(message = "Price cannot be empty")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn
    private Author author;
}
