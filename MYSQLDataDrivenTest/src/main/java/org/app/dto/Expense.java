package org.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountsystem")
public class Expense {
	
	@Id
	private int id;
	
	private String Description;
	
	@Column(name="amount")
	private Double amoun;
	
	private String month;
	
	private String year;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the amoun
	 */
	public Double getAmoun() {
		return amoun;
	}
	/**
	 * @param amoun the amoun to set
	 */
	public void setAmoun(Double amoun) {
		this.amoun = amoun;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Expense [id=" + id + ", Description=" + Description + ", amoun=" + amoun + ", month=" + month
				+ ", year=" + year + "]";
	}

	
	
}
