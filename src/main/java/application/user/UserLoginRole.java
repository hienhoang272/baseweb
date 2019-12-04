package application.user;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_login_role")
public class UserLoginRole {
    @EmbeddedId
    private UserLoginRoleId id;

    @ManyToOne
    @MapsId("user_login_id")
    private UserLogin userLogin;

    @ManyToOne
    @MapsId("role_id")
    private Role role;
}
