package basics;

import java.util.GregorianCalendar;


public class Album extends Release 
{
	public Artist AlbumArtist;
	

	public Album(String Title, boolean Status, String Language, GregorianCalendar ReleaseDate, String Format, int TrackCount, Artist AlbumArtist)
	{
		super(Title, Status, Language, ReleaseDate, Format, TrackCount);
		this.AlbumArtist = AlbumArtist;
	}

	
	public Artist getAlbumArtist() {
		return AlbumArtist;
	}

	public void setAlbumArtist(Artist AlbumArtist) {
		this.AlbumArtist = AlbumArtist;
	}
}