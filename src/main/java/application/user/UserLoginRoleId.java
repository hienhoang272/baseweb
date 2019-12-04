package application.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UserLoginRoleId implements Serializable {
    @Column(name = "user_login_id")
    private UUID userLoginId;

    @Column(name = "role_id")
    private UUID roleId;
}
