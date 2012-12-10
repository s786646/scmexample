package com.mycompany.app;

/**
 * comparable primitve object
 * http://docs.oracle.com/javase/tutorial/collections/interfaces/order.html 
 * @author Danilo
 *
 */
public class Stock implements Comparable<Stock>{

	private String id;
	private String name;
	private double percentage;
	
	public Stock(String id, String name, double percentage){
		this.id = id;
		this.name = name;
		this.percentage = percentage;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	/**
	 * http://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
	 */
	public int compareTo(Stock s) {
        return Double.compare(this.percentage, s.percentage);
	} 
	
	/*
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
        return this.getId() + " " +
        		this.getName()+ " " +
        		this.getPercentage() + "%";
    }
	
}
