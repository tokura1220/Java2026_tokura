package jp.co.sss.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inquiry") 
public class Inquiry {
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private String detail;
	
	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", name=" + name + ", detail=" + detail + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}
