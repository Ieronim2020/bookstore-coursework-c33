//package by.tms.bookstorecourseworkc33.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "authors")
//public class Author {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    @Column(name = "first_name", length = 50, nullable = false)
//    private String firstName;
//    @Column(name = "last_name", length = 100, nullable = false)
//    private String lastName;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "books_id")
//    private Book book;
//
//    public Author(long id, String firstName, String lastName, Book book) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.book = book;
//    }
//
//    public Author() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//}
