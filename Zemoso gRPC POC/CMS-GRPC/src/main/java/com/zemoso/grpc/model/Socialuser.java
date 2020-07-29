/**
 * 
 */
package com.zemoso.grpc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zadmin
 *
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = {"refblog, comments, password"})
@Table(name = "socialuser")
public class Socialuser implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1594367904550722035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	
	@Column
	private String email;
	
	@NotEmpty(message = "Please provide your first name")
	@Column(name = "first_name")
	private String FirstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Please provide your first name")
	private String LastName;
	
	@JsonBackReference
	@OneToMany(mappedBy = "refuser")
	private List<Post> refblog;
	
	@JsonBackReference
	@OneToMany(mappedBy = "refuser")
	private List<Comments> comments;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;
	
	@Column(name = "password")
	//@Transient
	private String password;
	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
	 * result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
	 * result = prime * result + ((confirmationToken == null) ? 0 :
	 * confirmationToken.hashCode()); result = prime * result + ((email == null) ? 0
	 * : email.hashCode()); result = prime * result + (enabled ? 1231 : 1237);
	 * result = prime * result + ((userid == null) ? 0 : userid.hashCode()); return
	 * result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Socialuser other = (Socialuser) obj; if (FirstName == null) { if
	 * (other.FirstName != null) return false; } else if
	 * (!FirstName.equals(other.FirstName)) return false; if (LastName == null) { if
	 * (other.LastName != null) return false; } else if
	 * (!LastName.equals(other.LastName)) return false; if (confirmationToken ==
	 * null) { if (other.confirmationToken != null) return false; } else if
	 * (!confirmationToken.equals(other.confirmationToken)) return false; if (email
	 * == null) { if (other.email != null) return false; } else if
	 * (!email.equals(other.email)) return false; if (enabled != other.enabled)
	 * return false; if (userid == null) { if (other.userid != null) return false; }
	 * else if (!userid.equals(other.userid)) return false; return true; }
	 */
	

	
	
}
