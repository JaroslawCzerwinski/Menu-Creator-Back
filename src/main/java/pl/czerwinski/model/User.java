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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName = "id_user")
    private List<Day> days;
	
	 User(){}
	    
	 public User(String email, String password) {
	    	this.email = email;
	    	this.password = password;
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
    
    public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}
	
    
	@Override
	public String toString() {
		return "User [userId=" + id + ", email=" + email + ", password=" + password + ", days=" + days + "]";
	}

}