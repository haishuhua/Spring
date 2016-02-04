package com.xiaoyi.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
  
@Entity
@Table(name="LineDefencePlayers")
public class Player {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "firstname", nullable = false)
    private String firstname;
    
    @Column(name = "lastname", nullable = false)
    private String lastname;
    
    @Column(name = "offence", nullable = false)
    private String offence;
    
    @Column(name = "defence", nullable = false)
    private String defence;
    
 
    public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public int getId() {
        return id;
    }


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getOffence() {
		return offence;
	}


	public void setOffence(String offence) {
		this.offence = offence;
	}


	public String getDefence() {
		return defence;
	}


	public void setDefence(String defence) {
		this.defence = defence;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", offence=" + offence
				+ ", defence=" + defence + "]";
	}
  
	
   
}