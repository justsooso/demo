package com.example.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class MyUserDetails extends User implements UserDetails{
	
	private List<Role> roles;

    public MyUserDetails(User user, List<Role> roles){
        super(user);
        this.roles = roles;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 if(roles == null || roles.size() <1){
	            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
	        }
	        StringBuilder commaBuilder = new StringBuilder();
	        for(Role role : roles){
	            commaBuilder.append(role.getRole()).append(",");
	        }
	        String authorities = commaBuilder.substring(0,commaBuilder.length()-1);
	        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
	}

	
	
	
	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
