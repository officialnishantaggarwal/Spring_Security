package com.example.demo4.SecurityApp.utils;

import com.example.demo4.SecurityApp.entities.enums.Permission;
import com.example.demo4.SecurityApp.entities.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo4.SecurityApp.entities.enums.Permission.*;
import static com.example.demo4.SecurityApp.entities.enums.Role.*;

public class PermissionMapping {

    private static final Map<Role, Set<Permission>> map = Map.of(
            USER, Set.of(POST_VIEW,USER_VIEW),
            CREATOR,Set.of(USER_UPDATE,POST_UPDATE,POST_CREATE),
            ADMIN, Set.of(USER_UPDATE,POST_UPDATE,POST_CREATE,USER_DELETE,POST_DELETE,USER_CREATE)
    );

    public static Set<SimpleGrantedAuthority> getAuthoritiesForRole(Role role) {
        return map.get(role).stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
    }
}
