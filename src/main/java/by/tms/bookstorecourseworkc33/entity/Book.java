package by.tms.bookstorecourseworkc33.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
}
