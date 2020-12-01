package by.tms.bookstorecourseworkc33.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nameBook", length = 255, nullable = false)
    private String nameBook;

    @Column(name = "year", length = 4, nullable = false)
    private int year;

    @Column(name = "quantityPage", length = 4, nullable = false)
    private int quantityPage;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private List<Author> authors;
}
