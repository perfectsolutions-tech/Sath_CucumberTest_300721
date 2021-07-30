package Utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class Property {
	
	public static Properties getProperty() {
		Properties p = null;
		try {
			FileInputStream reader = new FileInputStream(System.getProperty("user.dir") + "\\Config.Properties");
			p = new Properties();
			p.load(reader);
			System.out.println(p.getProperty("user"));
		} catch (Exception e) {
		}
		return p;
	}

	
}
