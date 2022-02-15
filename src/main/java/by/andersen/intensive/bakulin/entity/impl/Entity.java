package by.andersen.intensive.bakulin.entity.impl;

import java.io.Serializable;
import java.util.Objects;

public class Entity implements Serializable{
	
	private static final long serialVersionUID = -7540915769272152082L;
	
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entity [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
}
