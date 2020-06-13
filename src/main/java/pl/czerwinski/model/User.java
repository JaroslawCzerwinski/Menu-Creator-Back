package pl.czerwinski.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="users")
public class User implements Serializable {
	 private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
    private Long id;
  
    @Column(name="email", nullable=false)
    private String email;
    
    @Column(name="password", nullable=false)
    private String password;

    @ColumnDefault("1")
	private Long enabled = 1L;
    
	@Column(name="role", columnDefinition = "varchar(255) default 'USER'")
    private String role = "USER";

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName = "id_user")
    private List<Day> days;
	
	 User(){}
	    
	 public User(String email, String password, Long enabled) {
	    	this.email = email;
	    	this.password = password;
	    	this.enabled = enabled;
	    	
	 }
    
    public Long getUserId() {
    	return id;
    }
    
    public void setUserId(Long userId) {
    	this.id = userId;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
   
    public Long getEnabled() {
    	return enabled;
    }
    
    public void setEnabled(Long enabled) {
    	this.enabled = enabled;
    }
    
    public String getRole() {
    	return role;
    }
    
    public void setRole(String role) {
    	this.role = role;
    }
    
    public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}
	
    
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", enabled=" + enabled + ", role="
				+ role + ", days=" + days + "]";
	}

}