package application.user;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {
    @EmbeddedId
    private RolePermissionId id;

    @ManyToOne
    @MapsId("role_id")
    private Role role;

    @ManyToOne
    @MapsId("permission_id")
    private Permission permission;
}
