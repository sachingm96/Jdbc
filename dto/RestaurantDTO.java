package com.sachin.restaurant.dto;

import java.io.Serializable;

import com.sachin.restaurant.constant.RestaurantType;

public class RestaurantDTO implements Serializable {

	private int id;
	private String name;
	private String location;
	private String specialFood;
	private boolean best;
	private RestaurantType type;

	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}

	public RestaurantDTO(String name, String location, String specialFood, boolean best, RestaurantType type) {
		super();
		this.name = name;
		this.location = location;
		this.specialFood = specialFood;
		this.best = best;
		this.type = type;
	}

	public RestaurantDTO(int id, String name, String location, String specialFood, boolean best, RestaurantType type) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.specialFood = specialFood;
		this.best = best;
		this.type = type;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [id=" + id + ", name=" + name + ", location=" + location + ", specialFood=" + specialFood
				+ ", best=" + best + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (best ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specialFood == null) ? 0 : specialFood.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantDTO other = (RestaurantDTO) obj;
		if (best != other.best)
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specialFood == null) {
			if (other.specialFood != null)
				return false;
		} else if (!specialFood.equals(other.specialFood))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int aiId) {
		this.id = aiId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpecialFood() {
		return specialFood;
	}

	public void setSpecialFood(String specialFood) {
		this.specialFood = specialFood;
	}

	public boolean isBest() {
		return best;
	}

	public void setBest(boolean best) {
		this.best = best;
	}

	public RestaurantType getType() {
		return type;
	}

	public void setType(RestaurantType type) {
		this.type = type;
	}

}
