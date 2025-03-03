package com.app.sports.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="myusers")

public class SpoLogin {
	@Id
    public String email;
    public String password;
    
    public SpoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public SpoLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "SpoLogin [email=" + email + ", password=" + password + "]";
	}
}
