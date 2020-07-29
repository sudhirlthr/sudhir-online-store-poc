/**
 * 
 */
package com.zemoso.grpc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sudhirk
 *
 */
@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleid")
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "authority")
	private String authority;
}
