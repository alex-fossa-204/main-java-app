package by.andersen.intensive.bakulin.entity;

import java.io.Serializable;
import java.util.Objects;

import by.andersen.intensive.bakulin.entity.impl.Entity;

public class Role extends Entity implements Serializable{

	private static final long serialVersionUID = -6002041172341513141L;
	
	private String roleName;
	
	private String roleDescription;

	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public Role() {
		super();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(roleDescription, roleName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(roleDescription, other.roleDescription) && Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [roleName=");
		builder.append(roleName);
		builder.append(", roleDescription=");
		builder.append(roleDescription);
		builder.append("]");
		return builder.toString();
	}

}
