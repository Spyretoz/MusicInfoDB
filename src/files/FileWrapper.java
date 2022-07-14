package files;

import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class FileWrapper 
{
	public void writeArtistsToFile(String Name, String Gender, String Type, String Country, String City,String BirthDate, String DeathDate, String tag0, String tag1, String alia0, String alia1) throws FileNotFoundException
	{
		
		String MyData = "{\"name\":\""+Name+"\",\"gender\":\""+Gender+"\",\"type\":\""+Type+"\",\"country\":\""+Country+"\","+"\"city\":\""+City+"\",\"BirthDate\":\""
				+BirthDate+"\",\"DeathDate\":\""+DeathDate+"\","
				+ "\"tags\":[{"
				+ "\"name\":\""+tag0+"\"},"
				+ "{\"name\":\""+tag1+"\"}"
				+ "],"
				+"\"aliases\":[{"
				+ "\"sort-name\":\""+alia0+"\"},"
				+ "{\"sort-name\":\""+alia1+"\"}"
				+ "]"
				+"}";
		PrintWriter out = new PrintWriter(Name+".json"); // create file with artists's name in json format
		//System.out.println(MyData);
		out.println(MyData);
		out.close();
	}
}