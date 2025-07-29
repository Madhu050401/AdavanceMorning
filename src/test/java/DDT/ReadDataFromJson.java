package DDT;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {

	public static void main(String[] args) throws ParseException, IOException, FileNotFoundException {
		//Parse the json Physical file into java object using json
		//Parser class
		
		JSONParser parser = new JSONParser();
		
	    Object obj =parser.parse(new FileReader(".\\TestData\\commondata.json"));
	    
	  //convert the java obj into json obj(typecasting)
	    
	    JSONObject obj1 = (JSONObject)obj;
		
		//read data by using key
		System.out.println(obj1.get("BROWSER"));
		System.out.println(obj1.get("URL"));
		System.out.println(obj1.get("USENAME"));
		System.out.println(obj1.get("PASSWORD"));
	}

}
