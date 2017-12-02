package newobject;




import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseFactory {
	private static  ApplicationContext context;
	public UseFactory(){
		System.out.println("use factory constructor");
	}
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static ApplicationContext getContext() {
		return context;
	}
	public static void setContext(ApplicationContext context) {
		UseFactory.context = context;
	}
	
	
}
