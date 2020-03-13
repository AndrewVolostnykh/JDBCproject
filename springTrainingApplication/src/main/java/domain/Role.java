package domain;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    USER,
    MENTOR;


    @Override
    public String getAuthority() {
        return name();
    }
}
