package pl.czerwinski.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recipes")
	private Long recipeId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "image_path", nullable = false)
	private String imagePath;

	@Column(name = "ingredients", nullable = false)
	private String ingredients;

	Recipe() {
	}

	public Recipe(Long recipeId, String name, String description, String imagePath, String ingredients) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		this.ingredients = ingredients;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", name=" + name + ", description=" + description + ", imagePath="
				+ imagePath + ", ingredients=" + ingredients + "]";
	}

}