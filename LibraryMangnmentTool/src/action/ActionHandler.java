package action;
public class ActionHandler {
	public ActionHandler() {
		
	}
	public  void performedAction(String command,Object object){
		System.out.println("Command for Action----"+command);
	
		switch (command) {
			case "AddNew/Create":
				break;
			case "Edit":
				
	
			default: System.err.println("UnExpected Command So Action Not Performed");
				break;
		}
		
	}
}
