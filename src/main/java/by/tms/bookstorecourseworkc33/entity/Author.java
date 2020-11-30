package by.tms.bookstorecourseworkc33.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Author() {
    }

    public Author(long id, String firstName, String lastName, Book book) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.book = book;
    }
}
