package comonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReadUtils {

	public static Properties configFileReader(String filename) throws Exception {

		filename = filename.trim();

		Properties property = new Properties();

		InputStream inStream = new FileInputStream(filename);

		property.load(inStream);

		return property;

	}

}
