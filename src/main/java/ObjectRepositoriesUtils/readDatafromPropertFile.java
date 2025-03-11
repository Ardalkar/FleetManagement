package ObjectRepositoriesUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readDatafromPropertFile {

	public static String readDataFromORFile(String path, String key) throws IOException {
		File file = new File(path);
		FileInputStream stream  = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(stream);
		String data = prop.getProperty(key);
		stream.close(); 
		return data;
		

	}

}


