package by.tms.bookstorecourseworkc33.entity;

import by.tms.bookstorecourseworkc33.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
//@DynamicUpdate
//@DynamicInsert
//@SelectBeforeUpdate
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "count", length = 2, nullable = false)
    private int count;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> book;

    @OneToOne
    private User user;

    public Order(List<Book> book, int count) {
        this.count = count;
        this.book = book;
    }
}
