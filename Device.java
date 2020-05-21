
/**
 * 
 * This program represents the models/devices used to control aspects of climate.
 * It extends Thread.
 * 
 * @author Karis Heimann, Syeda Atika
 * April 13, 2016
 *
 */
public class Device extends Thread
{

	/**
	 * flag is of type boolean, represents if the thread/this class is on or off. 
	 */
	private boolean flag = true;
	
	/**
	 * isOn is of type boolean, represents if the device is on or off.
	 */
	private boolean isOn;
	
	/**
	 * externalRateOfChange is of type double, represents the external rate of change in the climate.
	 */
	private double externalRateOfChange;
	
	/**
	 * internalRateOfChange is of type double, represents the internal rate of change in the climate.
	 */
	private double internalRateOfChange;
	
	/**
	 * minValue is of type double, represents the minimum value of the range. 
	 */
	private double minValue;
	
	/**
	 * maxValue is of type double, represents the maximum value of the range.
	 */
	private double maxValue;
	
	/**
	 * currentRateOfChange is of type double, represents the current rate of change in the climate.
	 */
	private double currentRateOfChange;
	
	/**
	 * currentValue is of type double, represents the current value in the climate.
	 */
	private double currentValue;
	
	/**
	 * sampleIncrement is of type double, represents the increment the updated values should be displayed at.
	 */
	private double sampleIncrement;
	
	/**
	 * measurementName is of type String, represents the name of the measurement the device takes.
	 */
	private String measurementName;
	
	
	
	/**
	 * Default, empty constructor.
	 */
	public Device() 
	{
		
	}
	
	
	
	/**
	 * A get method.
	 * @return the value of flag.
	 */
	public boolean isFlag() {
		return flag;
	}
	
	/**
	 * A set method.
	 * @param flag is of type boolean, represents if the thread/this class is on or off. 
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	/**
	 * A get method.
	 * @return the value of isOn.
	 */
	public boolean isOn()
	{
		return isOn;
	}
	
	/**
	 * A set method.
	 * @param isOn is of type boolean, represents if the device is on or off.
	 */
	public void setOn(boolean isOn)
	{
		this.isOn = isOn;
	}

	/**
	 * A get method.
	 * @return the value of externalRateOfChange.
	 */
	public double getExternalRateOfChange() 
	{
		return externalRateOfChange;
	}

	/**
	 * A set method.
	 * @param externalRateOfChange is of type double, represents the external rate of change in the climate.
	 */
	public void setExternalRateOfChange(double externalRateOfChange) 
	{
		this.externalRateOfChange = externalRateOfChange;
	}

	/**
	 * A get method.
	 * @return the value of minValue.
	 */
	public double getMinValue() 
	{
		return minValue;
	}

	/**
	 * A set method.
	 * @param minValue is of type double, represents the minimum value of the range. 
	 */
	public void setMinValue(double minValue) 
	{
		this.minValue = minValue;
	}

	/**
	 * A get method.
	 * @return the value of maxValue.
	 */
	public double getMaxValue() 
	{
		return maxValue;
	}

	/**
	 * A set method.
	 * @param maxValue is of type double, represents the maximum value of the range.
	 */
	public void setMaxValue(double maxValue)
	{
		this.maxValue = maxValue;
	}

	/**
	 * A get method.
	 * @return the value of internalRateOfChange. 
	 */
	public double getInternalRateOfChange() 
	{
		return internalRateOfChange;
	}

	/**
	 * A set method.
	 * @param internalRateOfChange is of type double, represents the internal rate of change in the climate.
	 */
	public void setInternalRateOfChange(double internalRateOfChange) 
	{
		this.internalRateOfChange = internalRateOfChange;
	}

	/**
	 * A get method.
	 * @return a value of currentRateOfChange.
	 */
	public double getCurrentRateOfChange() 
	{
		return currentRateOfChange;
	}

	/**
	 * A set method.
	 * @param currentRateOfChange is of type double, represents the current rate of change in the climate.
	 */
	public void setCurrentRateOfChange(double currentRateOfChange) 
	{
		this.currentRateOfChange = currentRateOfChange;
	}

	/**
	 * A get method.
	 * @return a value of currentValue.
	 */
	public double getCurrentValue() 
	{
		return currentValue;
	}

	/**
	 * A set method.
	 * @param currentValue is of type double, represents the current value in the climate.
	 */
	public void setCurrentValue(double currentValue) 
	{
		this.currentValue = currentValue;
	}

	/**
	 * A get method.
	 * @return a value of sampleIncrement.
	 */
	public double getSampleIncrement() {
		return sampleIncrement;
	}

	/**
	 * A set method.
	 * @param sampleIncrement is of type double, represents the increment the updated values should be displayed at.
	 */
	public void setSampleIncrement(double sampleIncrement) {
		this.sampleIncrement = sampleIncrement;
	}

	/**
	 * A get method.
	 * @return a value of measurementName.
	 */
	public String getMeasurementName() {
		return measurementName;
	}

	/**
	 * A set method.
	 * @param measurementName is of type String, represents the name of the measurement the device takes.
	 */
	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}



	/**
	 * A method that calculates the currentRateOfChange.
	 * @param externalRateOfChange is of type double, represents the external rate of change in the climate.
	 * @param internalRateOfChange is of type double, represents the internal rate of change in the climate.
	 * @return a value of currentRateOfChange.
	 */
	public double calculateCurrentRateOfChange(Double externalRateOfChange, Double internalRateOfChange)
	{
		return externalRateOfChange + internalRateOfChange;
	}
	
	/**
	 * A method that calculates the currentValue.
	 * @param currentValue is of type double, represents the current value in the climate.
	 * @param currentRateOfChange is of type double, represents the current rate of change in the climate.
	 * @return a value of currentValue.
	 */
	public double calculateCurrentValue(Double currentValue, double currentRateOfChange) 
	{
		return currentValue + currentRateOfChange;
	}
	
	/**
	 * A method that determines if the currentValue is in the range set by the maximum and minimum values.
	 * @return true or false.
	 */
	public boolean isInDesiredRange()
	{
		if (this.getCurrentValue() <= this.getMaxValue() && this.getCurrentValue() >= this.getMinValue())
			return true;
		else
			return false;
	}
	
	/**
	 * A method that determines if the currentValue is above the range set by the maximum value.
	 * @return true or false.
	 */
	public boolean isAboveRange()
	{
		if(this.getCurrentValue() > this.getMaxValue())
		{
			return true;
		}
		else {
			return false;
		}	
	}
	
	/**
	 * A method that determines if the currentValue is blow the range set by the minimum value.
	 * @return true or false.
	 */
	public boolean isBelowRange()
	{
		if(this.getCurrentValue() < this.getMinValue())
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	
	/**
	 * The run method from the thread class is overwritten.
	 * It simulates the changes in the current value over time.
	 */
	public void run()
	{
		//The calculations are repeated until flag is set to false.
		while(isFlag())
		{		
			try
			{
				//Determines the appropriate rate of change based on the current value and turns the device 'on' or 'off'.
				if(this.isInDesiredRange())
				{
					this.setOn(false);
					this.setCurrentRateOfChange(this.calculateCurrentRateOfChange(this.getExternalRateOfChange(), (double) 0));
					this.setCurrentRateOfChange(this.getExternalRateOfChange());
					
				}
				else if(this.isAboveRange())
				{
					this.setOn(false);
					this.setCurrentRateOfChange(this.calculateCurrentRateOfChange(this.getExternalRateOfChange(), (double) 0));
				}
				else if(this.isBelowRange())
				{
					this.setOn(true);
					this.setCurrentRateOfChange(this.calculateCurrentRateOfChange(this.getExternalRateOfChange(), this.getInternalRateOfChange()));
					
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
