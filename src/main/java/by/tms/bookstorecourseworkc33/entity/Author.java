package by.tms.bookstorecourseworkc33.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHORS_SEQ")
//    @SequenceGenerator(name = "AUTHORS_SEQ", sequenceName = "SEQUENCES_AUTHORS", allocationSize = 1, initialValue = 1)
//    @GenericGenerator(name = "cmrSeq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotBlank(message = "First_name cannot be empty")
    @NotEmpty(message = "First_name cannot be empty")
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotBlank(message = "Last_name cannot be empty")
    @NotEmpty(message = "Last_name cannot be empty")
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
