package com.tableausoftware.demos;
//import com.fasterxml.jackson.annotation.JsonFormat.Value;
//import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.tableausoftware.TableauException;
import com.tableausoftware.extract.Extract;
import com.tableausoftware.extract.Row;
import com.tableausoftware.extract.Table;
import com.tableausoftware.extract.TableDefinition;

public class Location {

	public int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String Name;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String City;

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String State;

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public double Latitude;

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public double Longitude;

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public double Sales;

    public double getSales() {
        return Sales;
    }

    public void setSales(double Sales) {
        this.Sales = Sales;
    }
 
    public void populateExtract(Extract extract, Location[] value){
    	
	   	try {  
		//  Get Schema
	   		
	   		/*for(Location location : value){
	   			System.out.println(location.Id + " ," + location.City);
	   		}*/
	   		
             Table table = extract.openTable( "Extract" );
             TableDefinition tableDef = table.getTableDefinition();
           
             //  Insert Data
             Row row = new Row( tableDef );
            
             for(int k=0;k<value.length; k++) {
            	 row.setInteger(0,value[k].Id);
                 row.setCharString(1,value[k].Name);
                 row.setCharString( 2,value[k].City);
                 row.setCharString( 3, value[k].State); 
                 row.setDouble( 4,value[k].Latitude);   
                 row.setDouble( 5, value[k].Longitude);                     
                 row.setDouble( 6, value[k].Sales); 
                 table.insert( row );
         
             }
           
    	 }
    	 catch ( TableauException e ) {
             System.err.println( "A fatal error occurred while populating the extract:" );
             System.err.println( e.getMessage() );
             System.err.println( "Printing stack trace now:" );
             e.printStackTrace( System.err );
             System.err.println( "Exiting now." );
             System.exit( -1 );
             }
         catch ( Throwable t ) {
             System.err.println( "An unknown error occured while populating the extract" );
             System.err.println( "Printing stack trace now:" );
             t.printStackTrace( System.err );
             System.err.println( "Exiting now." );
             System.exit( -1 );
         }
	
	   
    }
	
}