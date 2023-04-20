package genral;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFile {
	
	@Test
	public void demo() throws IOException {
		
		FileInputStream fis = new FileInputStream("./commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		
		p.put("os", "windows");
		
		FileOutputStream fos = new FileOutputStream("./commondata.properties");
		p.store(fos, "update successfully");
	}

}
