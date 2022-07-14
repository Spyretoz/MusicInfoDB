package basics;

import java.util.ArrayList;


public class Artist 
{
	public String Name; 
	public String Country;
	public String Cities;
	
	public Artist(String Name, String Country, String Cities)
	{
		this.Name = Name;
		this.Country = Country;
		this.Cities = Cities;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public String getCities() {
		return Cities;
	}

	public void setCities(String Cities) {
		this.Cities = Cities;
	}
}