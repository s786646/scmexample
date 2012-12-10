package com.mycompany.app;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Manager class for handling the output and other useful stuff.
 * 
 * @author      Danilo Schmidt
 * @version     1.0
 */
public class StockManager {

	private static List<Stock> stocklist;
	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//from http://opencsv.sourceforge.net/:
		CSVReader reader = new CSVReader(new FileReader("Dax30-Table.csv"), ';');
	    String [] nextLine;
	    stocklist = new LinkedList<Stock>(); //use Linked lists to speed up sorting ;-)
	    while ((nextLine = reader.readNext()) != null) // nextLine[] is an array of values from the line:
	    	stocklist.add(new Stock(
	        	nextLine[0],					//stock index (id)
	        	nextLine[1],					//name
	        	Double.valueOf(					//percentage
	        		(nextLine[3].replace(',', '.')).replace("%", "0") //force a true double, cut "%"
	        	)
	        )); 
	    //trigger business logic of the "5 top/loosers"
	    getTheFive();
	}
	
	/**
	 * Calculate the top / loosers 5 from the stock market values
	 */
	private static void getTheFive() {
		//sort at first
		sort();
		System.out.println("The loosers: --------");
		for (int i = 0; i<5;i++)
			System.out.println("  "+stocklist.get(i).toString());
		System.out.println("The winners: --------");
		for (int i = stocklist.size()-5; i<stocklist.size();i++)
			System.out.println("  "+stocklist.get(i).toString());
	}

	/**
	 * sort the stack of stocks
	 */
	public static void sort(){
		Collections.sort(stocklist);
	}
	
	/**
	 * @return the stocklist
	 */
	public static List<Stock> getStocklist() {
		return stocklist;
	}
	/**
	 * @param stocklist the stocklist to set
	 */
	public static void setStocklist(List<Stock> stocklist) {
		StockManager.stocklist = stocklist;
	}

}
