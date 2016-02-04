package com.xiaoyi.springmvc.model;
 
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="linedefence")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "TeamA1", nullable = false)
    private String TeamA1;
    
    @Column(name = "TeamA2", nullable = false)
    private String TeamA2;
    
    @Column(name = "TeamB1", nullable = false)
    private String TeamB1;
    
    @Column(name = "TeamB2", nullable = false)
    private String TeamB2;
    
    @NotNull
    @DateTimeFormat(pattern="mm/dd/yyyy") 
    @Column(name = "PlayDate", nullable = false)
    private Date PlayDate;
    
    @Column(name = "ScoreAvsB", nullable = false)
    private String Score;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    
 
    public String getTeamA1() {
		return TeamA1;
	}

	public void setTeamA1(String teamA1) {
		this.TeamA1 = teamA1;
	}

	public String getTeamA2() {
		return TeamA2;
	}

	public void setTeamA2(String teamA2) {
		this.TeamA2 = teamA2;
	}

	public String getTeamB1() {
		return TeamB1;
	}

	public void setTeamB1(String teamB1) {
		this.TeamB1 = teamB1;
	}

	public String getTeamB2() {
		return TeamB2;
	}

	public void setTeamB2(String teamB2) {
		this.TeamB2 = teamB2;
	}

	public Date getPlayDate() {
		return PlayDate;
	}

	public void setPlayDate(Date playDate) {
		this.PlayDate = playDate;
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		this.Score = score;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", TeamA1=" + TeamA1 + ", TeamA2=" + TeamA2 + ", TeamB1=" + TeamB1 + ", TeamB2="
				+ TeamB2 + ", PlayDate=" + PlayDate + ", Score=" + Score + "]";
	}
     
}