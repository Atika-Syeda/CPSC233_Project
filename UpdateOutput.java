
/**
 * 
 * This program updates the information to the view every few seconds as determined by the user.
 * It extends Thread.
 * 
 * @author Karis Heimann, Syeda Atika
 * April 13, 2016
 *
 */
public class UpdateOutput extends Thread
{
	/**
	 * controller is of type Controller, it allows this class to access all methods associated with the controller.
	 */
	private Controller controller;
	
	/**
	 * flag is of type boolean, represents if the thread/this class is on or off. 
	 */
	private boolean flag;
	
	/**
	 * device is of type Device, represents an object of Device.
	 */
	private Device device;
	
	
	
	
	/**
	 * The constructor.
	 * @param controller is of type Controller, it allows this class to access all methods associated with the controller.
	 * @param device is of type Device, represents an object of Device.
	 */
	public UpdateOutput(Controller controller, Device device)
	{
		this.controller = controller;
		this.device = device;
	}
	
	
	/**
	 * A get method.
	 * @return the value of flag.
	 */
	public boolean isFlag() 
	{
		return flag;
	}

	/**
	 * A set method.
	 * @param flag is of type boolean, represents if the thread/this class is on or off. 
	 */
	public void setFlag(boolean flag) 
	{
		this.flag = flag;
	}
	
	
	
	/**
	 * The run method from the thread class is overwritten.
	 * It updates the current values every few seconds as determined by the user.
	 */
	public void run() 
	{
		//The updates are repeated until flag is set to false.
		while(isFlag()) 
		{
			try 
			{
				//Sets the values.
				
				if(device.getMeasurementName().equals("Temperature")){
					controller.setCurrentTempState();
				}
				else if(device.getMeasurementName().equals("Soil Moisture")){
					controller.setCurrentSoilMoisture();
				}
				else if(device.getMeasurementName().equals("Humidity")){
					controller.setCurrentHumidityState();
				}
				
				
				
				//Pauses for the seconds determined by the user before updating again.
				this.sleep((long) (device.getSampleIncrement()*1000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		return ;
	}

}

