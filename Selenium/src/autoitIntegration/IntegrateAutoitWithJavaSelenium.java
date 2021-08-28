package autoitIntegration;

public class IntegrateAutoitWithJavaSelenium {
	public static void main(String[] args) {
		runAutoITScript();
	}
	
	
	public static void runAutoITScript()
	{
		String exeFilePath = null;
		try {
			exeFilePath = "C:\\temp\\EveningBatch\\AutoITScripts\\Notepad_Automation.exe";
			
			Runtime.getRuntime().exec(exeFilePath);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			exeFilePath = null;
		}
	}
}
