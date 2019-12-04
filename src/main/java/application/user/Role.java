package application.user;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<RolePermission> rolePermissions;
}
