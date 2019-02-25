package config;

/*How to create Singleton design pattern?

 To create the singleton class, we need to have static member of class, private constructor and static factory method.

 1. Static member: It gets memory only once because of static, it contains the instance of the Singleton class.
 2. Private constructor: It will prevent to instantiate the Singleton class from outside the class.
 3.  Static factory method: This provides the global point of access to the Singleton object and returns the instance to the caller.
 */

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

public class GetPropertiesObj implements config {
	// 1. Static member:
	private static Properties config = new Properties();
	private static GetPropertiesObj obj;

	// 2. Private constructor:
	private GetPropertiesObj() throws Exception {
		FileInputStream fis = new FileInputStream(
				"src/main/java/config/config.property");
		// Properties config = new Properties();
		config.load(fis);

	}

	// 3. Static factory method:
	public static synchronized GetPropertiesObj getObj() throws Exception {
		if (obj == null) {
//			System.out.println("before Initialization:" + config + "\n" + obj);
//			System.out.println("Initializating object");
			obj = new GetPropertiesObj();
//			System.out.println("after Initialization:" + config + "\n" + obj);

		} else {
//			System.out.println("object already exist - re-using it ");
			System.out.println("Reusing:" + config + "\n" + obj);
		}
		return obj;
	}

	@Override
	public String getAnyProp(String mykey) {
		return (config.getProperty(mykey));
	}

	@Override
	public String getBrowser() {
		return (config.getProperty("browser"));
	}

	@Override
	public String getUser() {
		return (config.getProperty("username"));
	}

	@Override
	public String getPassword() {
		return (config.getProperty("password"));
	}

}
