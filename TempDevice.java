
/**
 * This program represents the specific model/device used to control aspects of temperature.
 * It extends Device, which extends Thread.
 * @author Karis Heimann, Syeda Atika
 * April 13, 2016
 *
 */
public class TempDevice extends Device
{
	/**
	 * airConditionerOn is of type boolean, represents if the air Conditioner is on or off.
	 */
	private boolean airConditionerOn;
	
	/**
	 * furnace is of type boolean, represents if the furnace is on or off.
	 */
	private boolean furnaceOn;
	
	/**
	 * internalRateOfChangeAirConditioner is of type double, represents the internal rate of change of the air Conditioner.
	 */
	private double internalRateOfChangeAirConditioner;
	
	/**
	 * internalRateOfChangeFurnace is of type double, represents the internal rate of change of the furnace.
	 */
	private double internalRateOfChangeFurnace;
	
	
	
	/**
	 * Default, empty constructor.
	 */
	public TempDevice() 
	{
		
	}
	
	
	
	/**
	 * A get method.
	 * @return the value of airConditionerOn.
	 */
	public boolean isAirConditionerOn() 
	{
		return airConditionerOn;
	}
	
	/**
	 * A set method.
	 * @param airConditionerOn is of type boolean, represents if the air Conditioner is on or off.
	 */
	public void setAirConditionerOn(boolean airConditionerOn) 
	{
		this.airConditionerOn = airConditionerOn;
	}
	
	/**
	 * A get method.
	 * @return the value of furnaceOn.
	 */
	public boolean isFurnaceOn() 
	{
		return furnaceOn;
	}
	
	/**
	 * A set method.
	 * @param furnaceOn is of type boolean, represents if the furnace is on or off.
	 */
	public void setFurnaceOn(boolean furnaceOn) 
	{
		this.furnaceOn = furnaceOn;
	}

	/**
	 * A get method.
	 * @return the value of internalRateOfChangeAirConditioner.
	 */
	public double getInternalRateOfChangeAirConditioner() 
	{
		return internalRateOfChangeAirConditioner;
	}
	
	/**
	 * A set method.
	 * @param internalRateOfChangeAirConditioner is of type double, represents the internal rate of change of the air Conditioner.
	 */
	public void setInternalRateOfChangeAirConditioner(double internalRateOfChangeAirConditioner) 
	{
		this.internalRateOfChangeAirConditioner = internalRateOfChangeAirConditioner;
	}
	
	/**
	 * A get method.
	 * @return the value of internalRateOfChangeFurnace.
	 */
	public double getInternalRateOfChangeFurnace() 
	{
		return internalRateOfChangeFurnace;
	}
	
	/**
	 * A set method.
	 * @param internalRateOfChangeFurnace is of type double, represents the internal rate of change of the furnace.
	 */
	public void setInternalRateOfChangeFurnace(double internalRateOfChangeFurnace) 
	{
		this.internalRateOfChangeFurnace = internalRateOfChangeFurnace;
	}
	
	
	
	/**
	 * The run method from the Device class is overwritten.
	 * It simulates the changes in the current temperature over time.
	 */
	public void run()
	{
		//The calculations are repeated until flag is set to false.
		while(isFlag())
		{
			try
			{
				//Determines the appropriate rate of change based on the current temperature and turns the air conditioner and furnace 'on' or 'off'.
				if(this.isInDesiredRange())
				{
					this.setAirConditionerOn(false);
					this.setFurnaceOn(false);
					this.setCurrentRateOfChange(this.calculateCurrentRateOfChange(this.getExternalRateOfChange(), (double) 0));
					
				}
				else if(this.isAboveRange())
				{
					this.setAirConditionerOn(true);
					this.setFurnaceOn(false);
					this.setCurrentRateOfChange(this.calculateCurrentRateOfChange(this.getExternalRateOfChange(), this.getInternalRateOfChangeAirConditioner()));
					
				}
				else if(this.isBelowRange())
				{
					this.setFurnaceOn(true);
					this.setAirConditionerOn(false);
					this.setCurrentRateOfChange(this.calculateCurrentRateOfChange(this.getExternalRateOfChange(), this.getInternalRateOfChangeFurnace()));
				}
				
				//Calculates and sets the current value using the new current rate of change.
				this.setCurrentValue(this.calculateCurrentValue(this.getCurrentValue(), this.getCurrentRateOfChange()));
				
				//Pauses for 1 second to simulate that the rate of change is per second.
				this.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		return;
	}
}
