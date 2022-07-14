package basics;

import java.util.GregorianCalendar;

/**
 *	Release is the parent. His children are the Album class and the Compilation class
 */

public class Release 
{
	public String Title;
	public boolean Status; // Official or Unofficial (true = official, false = unofficial)
	public String Language; // realease's language
	public GregorianCalendar ReleaseDate;
	public String Format; // CD, DVD, LP
	public int TrackCount; //counts tracks
	
	public Release(String Title, boolean Status, String Language, GregorianCalendar ReleaseDate, String Format, int TrackCount)
	{
		this.Title = Title;
		this.Status = Status;
		this.Language = Language;
		this.ReleaseDate = ReleaseDate;
		this.Format = Format;
		this.TrackCount = TrackCount;
	}

	

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean Status) {
		this.Status = Status;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String Language) {
		this.Language = Language;
	}

	public GregorianCalendar getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(GregorianCalendar ReleaseDate) {
		this.ReleaseDate = ReleaseDate;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String Format) {
		this.Format = Format;
	}

	public int getTrackCount() {
		return TrackCount;
	}

	public void setTrackCount(int TrackCount) {
		this.TrackCount = TrackCount;
	}
}
