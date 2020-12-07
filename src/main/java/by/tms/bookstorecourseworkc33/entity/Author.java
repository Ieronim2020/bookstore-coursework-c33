package by.tms.bookstorecourseworkc33.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
//@DynamicUpdate
//@DynamicInsert
//@SelectBeforeUpdate
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private Book book;
}
