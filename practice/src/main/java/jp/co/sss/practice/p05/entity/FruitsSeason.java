package jp.co.sss.practice.p05.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruits_season")
public class FruitsSeason {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fruit_gen")
	@SequenceGenerator(name = "seq_fruit_gen", sequenceName = "seq_fruits_season", allocationSize = 1)
	private Integer fruit_id;
	@Column
	private String fruit_name;
	@Column
	private Integer season_month;
	
	
	public Integer getFruit_id() {
		return fruit_id;
	}
	public void setFruit_id(Integer fruit_id) {
		this.fruit_id = fruit_id;
	}
	public String getFruit_name() {
		return fruit_name;
	}
	public void setFruit_name(String fruit_name) {
		this.fruit_name = fruit_name;
	}
	public Integer getSeason_month() {
		return season_month;
	}
	public void setSeason_month(Integer season_month) {
		this.season_month = season_month;
	}

	

}
