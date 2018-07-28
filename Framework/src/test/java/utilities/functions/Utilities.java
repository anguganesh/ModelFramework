package utilities.functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	public static String readPropertiesFile(String filename, String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./properties/" + filename + ".properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;		
	}
	
}
