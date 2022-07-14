package tests;

import basics.Album;
import basics.Compilation;
import basics.Group;
import basics.Person;
import basics.Release;
import java.util.GregorianCalendar;

/**
 * Sources used: https://stackoverflow.com/questions/1921181/arraylist-of-string-arrays
 * GregorianCalendar uses (Year, Month, Day)
 */

public class DemoBasics
{
	
	public static void main(String[] args) 
	{
		Person p0 = new Person("Tyler Robert Joseph", "Male", "USA", "Ohio", new GregorianCalendar(1988, 12, 01), null); // Create person number 0
		// use null because person p0 has no DeathDate
		
		
		p0.addAliases("Blurryface");
		p0.addAliases("TyJo");
		
		p0.addTags("#IndiePop");
		p0.addTags("#TylerJoseph");
		p0.addTags("#Singer");
		p0.addTags("#Songwriter");
		p0.addTags("#Rapper");
		p0.addTags("#AlternativeHipHop");
		p0.addTags("#TwentyOnePilots");
		
		
		Group g0 = new Group("Twenty One Pilots", "USA", "Ohio", new GregorianCalendar(2009, 01, 01), null); // Create group number 0
		// use null because group g0 has no EndDate
		
		
		g0.addAliases("TØP");
		
		g0.addTags("#TwentyOnePilots");
		g0.addTags("#TylerJoseph");
		g0.addTags("#JoshDun");
		g0.addTags("#AlternativeRock");
		g0.addTags("#IndiePop");
		g0.addTags("#AmericanBandDuo");
		
		g0.addMembers(p0);

		
		Release r0 = new Release("Stressed Out", true, "English", new GregorianCalendar(2015, 10, 10), "CD", 1); // Create release number 0
		
		Album a0 = new Album("Stressed Out", true, "English", new GregorianCalendar(2015, 10, 10), "CD", 1, g0); // Create Album number 0
		
		
		Compilation c0 = new Compilation("Stressed Out", true, "English", new GregorianCalendar(2015, 10, 10), "CD", 1); // Create Compilation
		c0.addAlbumParticipants(p0);
		c0.addAlbumParticipants(g0);
	}
}