package utilities;

public class Constants {
	public static final String CHROME_DRIVER_PATH_MAC = "src/test/resources/Drivers/chromedriver";
	public static final String CHROME_DRIVER_PATH_WINDOWS = "src/test/resources/Drivers/chromedriver.exe";
	
	static String proPath = System.getProperty("user.dir").replaceAll("\\\\", "/");
	public static final String BORA_FORM_URL = "file:///" + proPath + "/src/main/resources/MuradilE/index.html";
}

