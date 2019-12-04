package application.user;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "permission")
public class Permission {
    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "permission")
    private List<RolePermission> rolePermissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

