package basics;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Compilation extends Release
{

	public ArrayList<Object>  AlbumParticipants = new ArrayList<Object>(); // one ArrayList that will include Persons and Groups
	
	public Compilation(String Title, boolean Status, String Language, GregorianCalendar ReleaseDate, String Format, int TrackCount) 
	{
		super(Title, Status, Language, ReleaseDate, Format, TrackCount);
	}

	public ArrayList<Object> getAlbumParticipants() {
		return AlbumParticipants;
	}

	public void setAlbumParticipants(ArrayList<Object> AlbumParticipants) {
		this.AlbumParticipants = AlbumParticipants;
	}
	
	
	/* be able to add in main artists */
	public void addAlbumParticipants(Object AlbumParticipants) { // object type
		this.AlbumParticipants.add(AlbumParticipants);
	}	
}