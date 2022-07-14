package basics;

import java.util.ArrayList;
import java.util.GregorianCalendar;


	
public class Group extends Artist
{
	
	public GregorianCalendar BeginDate;
	public GregorianCalendar EndDate;
	public ArrayList<String> Aliases = new ArrayList<String>();
	public ArrayList<String> Tags = new ArrayList<String>();
	public ArrayList<Person> Members = new ArrayList<Person>();
	
	
	public Group(String Name, String Country, String Cities, GregorianCalendar BeginDate, GregorianCalendar EndDate)
	{
		super(Name, Country, Cities);
		this.BeginDate = BeginDate;
		this.EndDate = EndDate;
	}


	public GregorianCalendar getBeginDate() {
		return BeginDate;
	}

	public void setBeginDate(GregorianCalendar BeginDate) {
		this.BeginDate = BeginDate;
	}

	public GregorianCalendar getEndDate() {
		return EndDate;
	}

	public void setEndDate(GregorianCalendar EndDate) {
		this.EndDate = EndDate;
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

	

	public ArrayList<Person> getMembers() {
		return Members;
	}

	public void setMembers(ArrayList<Person> Members) {
		this.Members = Members;
	}

	
	
	/* be able to add in main aliases, tags and members */	
	public void addAliases(String aliases) {
		this.Aliases.add(aliases);
	}
	
	public void addTags(String tags) {
		this.Tags.add(tags);
	}
	
	public void addMembers(Person members) { // person type
		this.Members.add(members);
	}
}