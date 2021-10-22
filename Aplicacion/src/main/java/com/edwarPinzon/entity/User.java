package com.edwarPinzon.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8569167499366278505L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native") //generador nativo de mysql
	@GenericGenerator(name="native",strategy = "native")
	private Long id;
	
	@Column
	private String firstName;
	@Column
	private String LastName;
	@Column(unique = true) 
	private String email;
	@Column(unique = true) 
	private String Username;
	@Column
	private String password;
	
	@Transient                     //se omite este  valor
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name= "user_roles",
	          joinColumns=@JoinColumn(name="user_id"),    //PRIMER VALOR DE ESTA CLASE 
	           inverseJoinColumns=@JoinColumn(name="role_id")) //tabla a la que se le hace la transaccion , busca el id de tabla y lo pone como la llave foranea
	private Set<Role> roles;
	
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(Long id) {
		super();
		this.id = id;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFistName() {
		return firstName;
	}

	public void setFistName(String fistName) {
		this.firstName = fistName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	



	@Override
	public int hashCode() {
		return Objects.hash(LastName, Username, confirmPassword, firstName, id, password, roles);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(LastName, other.LastName) && Objects.equals(Username, other.Username)
				&& Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(roles, other.roles);
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", fistName=" + firstName + ", LastName=" + LastName + ", Username=" + Username
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", roles=" + roles + "]";
	}
	
	
	
	
	
	

}
