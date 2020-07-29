/**
 * 
 */
package com.zemoso.grpc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@EqualsAndHashCode
public class Comments implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 3648729626079376055L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentsid;
	
	@Column
	private String content; 
	
	@Column
	private String commentsdate;
	
	@JsonManagedReference
	@ManyToOne
	private Post refblog;
	
	@JsonManagedReference
	@ManyToOne
	private Socialuser refuser;

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((commentsdate == null) ? 0 :
	 * commentsdate.hashCode()); result = prime * result + ((commentsid == null) ? 0
	 * : commentsid.hashCode()); result = prime * result + ((refblog == null) ? 0 :
	 * refblog.hashCode()); result = prime * result + ((refuser == null) ? 0 :
	 * refuser.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Comments other = (Comments) obj; if (commentsdate == null) { if
	 * (other.commentsdate != null) return false; } else if
	 * (!commentsdate.equals(other.commentsdate)) return false; if (commentsid ==
	 * null) { if (other.commentsid != null) return false; } else if
	 * (!commentsid.equals(other.commentsid)) return false; if (refblog == null) {
	 * if (other.refblog != null) return false; } else if
	 * (!refblog.equals(other.refblog)) return false; if (refuser == null) { if
	 * (other.refuser != null) return false; } else if
	 * (!refuser.equals(other.refuser)) return false; return true; }
	 */
	
}
