package abhibus_BaseClass;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.UnexpectedAlertBehaviour;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxProfile;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.ie.InternetExplorerOptions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Abhibus_BaseClass {
			public static Properties prop;
			public static WebDriver driver;
			public static WebDriverWait wait;
			
			// Reading the properties from config file.
			public Abhibus_BaseClass() {
				try {
				prop=new Properties();
				FileInputStream ip=new FileInputStream("C:\\Users\\HOME\\eclipse-workspace\\Abhibus_Ticket_Booking\\src\\main\\java\\abhibus_Config\\Abhibus_Config");		
				prop.load(ip);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}	
			
			
				// Initializing the web browser and Maximizing 
				@SuppressWarnings("deprecation")
				public static void initialise() {
					String browser="Chrome";
					if(browser.equalsIgnoreCase("chrome")) {
						ChromeOptions options = new ChromeOptions();
						//options.addArguments("--incognito");
						options.addArguments("---disable-notifications" );
						WebDriverManager.chromedriver().setup();
						driver=new ChromeDriver(options);
						}
					
					else if(browser.equalsIgnoreCase("firefox")) {
						FirefoxProfile profile = new FirefoxProfile();
				        profile.setPreference("permissions.default.desktop-notification", 1);
				        DesiredCapabilities capabilities=DesiredCapabilities.firefox();
				        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				        WebDriverManager.firefoxdriver().setup();
						driver=new FirefoxDriver(capabilities);
					}	
					
					else if(browser.equalsIgnoreCase("IE")) {
						DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
						caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
						InternetExplorerOptions options = new InternetExplorerOptions();
						options.enablePersistentHovering();
						options.ignoreZoomSettings();
						options.introduceFlakinessByIgnoringSecurityDomains();
						options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
						options.enableNativeEvents();
						options.destructivelyEnsureCleanSession();
						WebDriverManager.iedriver().setup();
						driver=new InternetExplorerDriver(options);
						
					}
					
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						wait = new WebDriverWait(driver, 30);
						driver.get(prop.getProperty("URL"));
						
						
						
				}
				

	}


