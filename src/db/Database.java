package db;

import basics.*;
import files.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Database
{
	public String Search, BD, DD;
	public int Counter;
	
	
	
		
	public ArrayList<Person> artist_list = new ArrayList(); // Create list of Persons
	
	public void Act(String art, String cou)
	{
		Person pnew = APIWrapper.getArtistsFromCountry(art, cou);
		
		
		// Convert GregorianCalendar to String format
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		fmt.setCalendar(pnew.BirthDate);
		BD = fmt.format(pnew.BirthDate.getTime()); // BD is the BirthDate as a String
		
		fmt.setCalendar(pnew.DeathDate);
		DD = fmt.format(pnew.DeathDate.getTime()); // DD is the DeathDate as a String
		

		try
		{
			// Connection to database
			Class.forName("oracle.jdbc.driver.OracleDriver"); // connect to oracle database with jdbc
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//host_name:port_number/service_name", "name", "password");
			
			// Create a statement
			Statement stmt = con.createStatement();
			stmt.executeUpdate("ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD'");
			
			try
			{
			stmt.executeUpdate("insert into NewPerson values ('" + pnew.Name+"', '" + pnew.Gender + "', '" + pnew.Country + "', '" + pnew.Cities + "', '" + BD + "', '" + DD + "', '" + pnew.Aliases + "', '" + pnew.Tags + "')" ); // (Name, Gender, Country, Cities, BirthDate, DeathDate, Aliases, Tags)
			stmt.executeUpdate("COMMIT");
			}
			catch(Exception ex)
			{
				System.out.println("ERROR ON Insert");
				ex.printStackTrace();
			}
			
			// Execute SQL query
			ResultSet rs = stmt.executeQuery("select * from NewPerson");
			
			// Process the result
			Counter = 0;
			while(rs.next())
			{
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)  + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8));
				artist_list.add(new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), pnew.BirthDate, pnew.DeathDate));
				++Counter;
			}
			System.out.println(Counter + " artist(s) found");
		}
		catch(Exception ex)
		{
			System.out.println("ERROR ON DB");
			ex.printStackTrace();
		}
	}
	
	public void Searching()
	{
		try
		{
			Search = "Joseph Haydn"; // user's input
			
			for(Person al : artist_list)
			{
				if(al.getName() != null && al.getName().contains(Search))
				{
					System.out.println("Search artist by his name");
					System.out.println("You typed: " + Search);
					System.out.println("The results that you may are looking for are: ");
					System.out.println(al.getName() + ", " + al.getGender() + ", " + al.getCountry() + ", " + al.getCities()); // Print info about the artist
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Search didn't act right");
		}
	}
	
}