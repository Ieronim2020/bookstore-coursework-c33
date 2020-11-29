package by.tms.bookstorecourseworkc33.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
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

    public Book(long id, String nameBook, int year, int quantityPage, BigDecimal price, List<Author> authors) {
        this.id = id;
        this.nameBook = nameBook;
        this.year = year;
        this.quantityPage = quantityPage;
        this.price = price;
        this.authors = authors;
    }

    public Book() {
    }
}
