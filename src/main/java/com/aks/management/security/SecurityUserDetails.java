/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/12
 * Time: 22:53
 **/
package com.aks.management.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class SecurityUserDetails implements UserDetails {
    
    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    
    public SecurityUserDetails(String username, String password,
                               Collection<? extends GrantedAuthority> authorities,
                               boolean accountNonExpired, boolean accountNonLocked,
                               boolean credentialsNonExpired, boolean enabled) {
        this.username = username;
        this.password = password;
        this.authorities = Collections.unmodifiableSet(
                authorities.stream().map(authority ->
                        new SimpleGrantedAuthority(authority.getAuthority()))
                        .collect(Collectors.toSet())
        );
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
