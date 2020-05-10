package pl.czerwinski.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "days")
public class Day implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_day")
	private Long dayId;

	@Column(name = "date", nullable = false)
	private Date date;

	@OneToMany
    @JoinColumn(name = "id_recipes", referencedColumnName="id_day")
	private List<Recipe> recipes;

	Day() {}

	public Day(Long dayId, Date date) {
		super();
		this.dayId = dayId;
		this.date = date;
	}

	public Long getDayId() {
		return dayId;
	}

	public void setDayId(Long dayId) {
		this.dayId = dayId;
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
		return "Day [dayId=" + dayId + ", date=" + date + ", recipes=" + recipes + "]";
	}

}