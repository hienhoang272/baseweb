package application.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private UUID id;

    @Column(nullable = false, length = 200)
    private String name;

    public Person() {

    }
}
