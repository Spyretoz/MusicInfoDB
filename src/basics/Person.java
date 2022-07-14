package basics;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;



public class Person extends Artist
{
	public String Gender; 
	public GregorianCalendar BirthDate;
	public GregorianCalendar DeathDate;
	public ArrayList<String> Aliases = new ArrayList<String>();
	public ArrayList<String> Tags = new ArrayList<String>();
	
	
	public Person(String Name, String Gender, String Country, String Cities, GregorianCalendar BirthDate, GregorianCalendar DeathDate)
	{
		super(Name, Country, Cities);
		this.Gender = Gender;
		this.BirthDate = BirthDate;
		this.DeathDate = DeathDate;
	}


	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public GregorianCalendar getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(GregorianCalendar BirthDate) {
		this.BirthDate = BirthDate;
	}

	public GregorianCalendar getDeathDate() {
		return DeathDate;
	}

	public void setDeathDate(GregorianCalendar DeathDate) {
		this.DeathDate = DeathDate;
	}

	public ArrayList<String> getAliases() {
		return Aliases;
	}

	public void setAliases(ArrayList<String> Aliases) {
		this.Aliases = Aliases;
	}

	public ArrayList<String> getTags() {
		return Tags;
	}

	public void setTags(ArrayList<String> Tags) {
		this.Tags = Tags;
	}

	
	/* to be able to add in main aliases and tags */
	
	
	public void addAliases(String aliases) {
		this.Aliases.add(aliases);
	}
	
	public void addTags(String tags) {
		this.Tags.add(tags);
	}
	
	
	public String toString()
	{
		return Name;
	}
	
	public String getObjecttoString()
	{
		return "Name: "+Name+"\n"+"Gender: "+Gender+"\n"+"Country: "+Country+"\n"+"City: "+Cities+"\n\n";
	}
}