package LoginPage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="userlogin")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "StudentProject")
	@SequenceGenerator(name = "StudentProject", sequenceName = "StudentProject_S", allocationSize = 1)
	@Column(name="id")
	private int id;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="email")
	private String email;
	
	public User() {
		
	}

	public User(String pass, String email) {
		super();
		this.pass = pass;
		
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", passw=" + pass + ", email=" + email + "]";
	}

}
