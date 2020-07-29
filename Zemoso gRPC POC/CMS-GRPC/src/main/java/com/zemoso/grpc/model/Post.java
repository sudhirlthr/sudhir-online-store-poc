/**
 * 
 */
package com.zemoso.grpc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@EqualsAndHashCode(of = {"comments"})
public class Post implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 245226918184856065L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blogid;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private String creationdate;
	
	@JsonBackReference
	@OneToMany(mappedBy = "refblog", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comments> comments;
	
	@JsonManagedReference
	@ManyToOne
	private Socialuser refuser;

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((blogid == null) ? 0 : blogid.hashCode()); result
	 * = prime * result + ((content == null) ? 0 : content.hashCode()); result =
	 * prime * result + ((creationdate == null) ? 0 : creationdate.hashCode());
	 * result = prime * result + ((refuser == null) ? 0 : refuser.hashCode());
	 * result = prime * result + ((title == null) ? 0 : title.hashCode()); return
	 * result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Post other = (Post) obj; if (blogid == null) { if (other.blogid !=
	 * null) return false; } else if (!blogid.equals(other.blogid)) return false; if
	 * (content == null) { if (other.content != null) return false; } else if
	 * (!content.equals(other.content)) return false; if (creationdate == null) { if
	 * (other.creationdate != null) return false; } else if
	 * (!creationdate.equals(other.creationdate)) return false; if (refuser == null)
	 * { if (other.refuser != null) return false; } else if
	 * (!refuser.equals(other.refuser)) return false; if (title == null) { if
	 * (other.title != null) return false; } else if (!title.equals(other.title))
	 * return false; return true; }
	 */
	
}
