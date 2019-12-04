package application.config;

import application.user.Permission;
import application.user.UserLogin;
import application.user.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userLoginRepository.findByUsername(username);
        List<Permission> permissions = new ArrayList<>(); // TODO
        List<GrantedAuthority> grantedAuthorities =
                permissions.stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                        .collect(Collectors.toList());
        return new UserPrincipal(userLogin, grantedAuthorities);
    }
}
