package files;

import basics.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import org.json.JSONArray;
import org.json.JSONObject;

/*
* https://stackoverflow.com/questions/2331513/convert-a-string-to-a-gregoriancalendar
* NEED FROM JSON:
* artist -> 0
*	name, gender, type, cuntry
*	begin-area -> name
*	life-span -> begin, end
*	aliases -> 0, 1
*	tags -> 0, 1
*/

public class APIWrapper 
{
	
	public static Person getArtistsFromCountry(String artistname, String country)
	{
		Person p1 = new Person(null, null, null, null, null, null);
		try
		{	
			String YourURL = ("http://musicbrainz.org/ws/2/artist/?query=artist:"+artistname+"%20AND%20country:"+country);
			String Finalurl = (YourURL+"&fmt=json"); // create the desired url
			URL obj = new URL(Finalurl);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
			int responseCode = con.getResponseCode();
		
			BufferedReader in = new BufferedReader (new InputStreamReader(con.getInputStream()));
		
			String inputLine;
			StringBuffer response = new StringBuffer();
		
			while((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}
			in.close();
			
			
			ArrayList<Artist> list_artist= new ArrayList();
			
			
			JSONObject obj_JSONObj = new JSONObject(response.toString()); // Create JSON Object
			
			JSONArray obj_JSONArr = obj_JSONObj.getJSONArray("artists"); // Create JSON Array	
			
			JSONObject singer0 = obj_JSONArr.getJSONObject(0); // Object number 0 is the most accurate
				
			
			String OneName = singer0.getString("name");
			String OneGender = singer0.getString("gender");
			String OneType = singer0.getString("type");
			String OneCountry = singer0.getString("country");
			
			
			JSONObject city = new JSONObject (singer0.getJSONObject("begin-area").toString());
			String OneCity = city.getString("name");
			
			
			JSONObject life = new JSONObject (singer0.getJSONObject("life-span").toString());
			String OneBirth = life.getString("begin");
			String OneDeath = life.getString("end");
			
			JSONArray Alias = singer0.getJSONArray("aliases");
			JSONObject al0 = Alias.getJSONObject(0);
			String alia0 = al0.getString("sort-name");
			JSONObject al1 = Alias.getJSONObject(1);
			String alia1 = al1.getString("sort-name");
			
			JSONArray Tags = singer0.getJSONArray("tags");
			JSONObject ta0 = Alias.getJSONObject(0);
			String tag0 = ta0.getString("name");
			JSONObject ta1 = Alias.getJSONObject(1);
			String tag1 = ta1.getString("name"); 
			

			// Convert OneBirth to Gregorian Calendar Format
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // this is the given String's format
			
			Date Bdate = df.parse(OneBirth);
			GregorianCalendar Bcal = new GregorianCalendar();
			Bcal.setTime(Bdate); // set date to Bdate
			
			
			Date Ddate = df.parse(OneDeath);
			GregorianCalendar Dcal = new GregorianCalendar();
			Dcal.setTime(Ddate);
			//System.out.println(Bdate);
			//System.out.println(Ddate);
			
			
			p1.setName(OneName);
			p1.setGender(OneGender);
			p1.setCountry(OneCountry);
			p1.setCities(OneCity);
			p1.setBirthDate(Bcal);
			p1.setDeathDate(Dcal);
			p1.addAliases(alia0);
			p1.addAliases(alia1);

			
			p1.addTags(tag0);
			p1.addTags(tag1);

			list_artist.add(p1); // add Person(p1) into ArrayList(list_artist)
			//System.out.println(p1.Name);
			
			FileWrapper fl = new FileWrapper();
			fl.writeArtistsToFile(OneName, OneGender, OneType, OneCountry, OneCity, OneBirth, OneDeath, tag0, tag1, alia0, alia1); // write to json file

		}
		catch(Exception e)
		{
			System.out.println("ERROR on finding the needed elements!");
			System.out.println("Check the json.");
			return null;
		}
		
		return p1;
	}
}
