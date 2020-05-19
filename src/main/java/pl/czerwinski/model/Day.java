package pl.czerwinski.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_days")
@IdClass(DayId.class)
public class Day implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToMany
    @JoinTable(name = "days_recipes",
       joinColumns = {@JoinColumn(name="day_date", referencedColumnName="date"),
    		   	      @JoinColumn(name="id_user", referencedColumnName="user_id")},
       inverseJoinColumns = {@JoinColumn(name="recipe_id", referencedColumnName="id_recipes")}
    )
	private List<Recipe> recipes;
	
	

	Day() {}

	public Day( Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	@Override
	public String toString() {
		return "Day [date=" + date + ", recipes=" + recipes + "]";
	}

}