/**
 * 
 */
package com.onlinestore.zemoso.dto;

import java.util.HashSet;
import java.util.Set;

import com.onlinestore.zemoso.model.Authority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sudhirk
 *
 */
@NoArgsConstructor
@Getter
@Setter
public class UsersDTO {
	private Long id;
	private String username;
	private Boolean enabled;
	private Set<Authority> authority = new HashSet<>();
}
