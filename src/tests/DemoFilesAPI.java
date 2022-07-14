package tests;

import files.APIWrapper;

/**
 * http://musicbrainz.org/ws/2/artist/?query=artist:fred%20AND%20type:group&fmt=json
 * https://jsoneditoronline.org/
 * https://processing.org/reference/JSONObject_getJSONArray_.html
 * JSON Object -> {}
 * JSON Array -> []
 */
public class DemoFilesAPI 
{
	
	public static void main(String[] args)
	{
		APIWrapper A0 = new APIWrapper(); // artist's name and country
		A0.getArtistsFromCountry("joseph", "AT"); // user input artistname, country
	}
}
