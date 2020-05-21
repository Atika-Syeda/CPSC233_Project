
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.JButton;

/**
 * The class Controller connects the models to one view. It implements action listener
 * by listening to events fired by buttons when user clicks on them.
 * 
 * @author Atika and Karis
 */
public class Controller implements ActionListener
{	
	/**The following attributes are declared, which include the three models (sprinkler, 
	 * humidifier, and thermostat), a view (screen) and an update output type for each model.*/
	private Device sprinkler;
	private Device humidifier;
	private TempDevice thermostat;
	private View view;
	private UpdateOutput outputUpdateSprinkler;
	private UpdateOutput outputUpdateHumidifier;
	private UpdateOutput outputUpdateThermostat;
	
	/**The default constructor initializes the three models, update output and the screen.
	 * It also adds listener to buttons in the screen*/
	public Controller() 
	{
		view = new View();
		sprinkler = new Device();
		humidifier = new Device();
		thermostat = new TempDevice();
		outputUpdateSprinkler = new UpdateOutput(this, sprinkler);
		outputUpdateHumidifier = new UpdateOutput(this, humidifier);
		outputUpdateThermostat = new UpdateOutput(this, thermostat);
		view.setListenerToButtons(this);
	}
	
	
	
	
	/**Sets the value of temperature to current/updated values
	 * on the screen from the model.
	 * Sets the state of the device on the screen. Checks if device is set on then 
	 * displays its state on the screen*/
	public void setCurrentTempState()
	{
		view.setCurrentTemp(thermostat.getCurrentValue());
		//Checks the state of the air conditioner and the furnace
				if(thermostat.isAirConditionerOn())
				{
					view.setACState("On");
				}
				else
				{
					view.setACState("Off");
				}
				
				if(thermostat.isFurnaceOn())
				{
					view.setFurnaceState("On");
				}
				else
				{
					view.setFurnaceState("Off");
				}
	}
	
	/**Sets the value of humidity to current/updated values
	 * on the screen from the model.
	 * Sets the state of the device on the screen. Checks if device is set on then 
	 * displays its state on the screen*/
	public void setCurrentHumidityState(){
		view.setCurrentHumidity(humidifier.getCurrentValue());
		//Checks the state of the humidifier
				if(humidifier.isOn())
				{
					view.setHumidifierState("On");
				}
				else
				{
					view.setHumidifierState("Off");
				}
	}
	
	/**Sets the value of soil moisture to current/updated values
	 * on the screen from the model.
	 * Sets the state of the device on the screen. Checks if device is set on then 
	 * displays its state on the screen*/
	public void setCurrentSoilMoisture(){
		view.setCurrentSoilMoisture(sprinkler.getCurrentValue());
		//Checks the state of the sprinkler
				if(sprinkler.isOn())
				{
					view.setSprinklerState("On");
				}
				else
				{
					view.setSprinklerState("Off");
				}
	}
	
	
	
	
	/**
	 * The method is overridden. The method checks source of event i.e. if it's 
	 * from which button and performs the actions for the button clicked
	 * */
	public void actionPerformed(ActionEvent e) 
	{
		//Checks if the run button is clicked
		if (((JButton)e.getSource()).getText() == "Run")
		{
			//Sets the flag(state) to true so the while loop starts
			sprinkler.setFlag(true);
			humidifier.setFlag(true);
			thermostat.setFlag(true);
			outputUpdateHumidifier.setFlag(true);
			outputUpdateSprinkler.setFlag(true);
			outputUpdateThermostat.setFlag(true);
			
			//Sets the input of the user to the model for soil moisture device(sprinkler) by taking
			// the values from the view(screen)
			sprinkler.setCurrentValue(view.getinputInitSoilMoisture());
			sprinkler.setExternalRateOfChange(view.getinputSoilMoistChangeEx());
			sprinkler.setInternalRateOfChange(view.getinputSoilMoistChangeIn());
			sprinkler.setMinValue(view.getinputMinSoilMoisture());
			sprinkler.setMaxValue(view.getinputMaxSoilMoisture());
			sprinkler.setSampleIncrement(view.getSoilMoistureInterval());
			sprinkler.setMeasurementName("Soil Moisture");
			
			//Sets the input of the user to the model for humidity device(humidifier) by taking
			// the values from the view(screen)
			humidifier.setCurrentValue(view.getinputInitHumidity());
			humidifier.setExternalRateOfChange(view.getinputHumidityChangeEx());
			humidifier.setInternalRateOfChange(view.getinputHumidityChangeIn());
			humidifier.setMinValue(view.getinputMinHumidity());
			humidifier.setMaxValue(view.getinputMaxHumidity());
			humidifier.setSampleIncrement(view.getHumidityInterval());
			humidifier.setMeasurementName("Humidity");
			
			//Sets the input of the user to the model for temperature device(thermostat) by taking
			// the values from the view(screen)
			thermostat.setCurrentValue(view.getinputInitTemp());
			thermostat.setExternalRateOfChange(view.getinputTempChangeEx());
			thermostat.setInternalRateOfChangeAirConditioner(view.getinputTempChangeInAC());
			thermostat.setInternalRateOfChangeFurnace(view.getinputTempChangeInFurnace());
			thermostat.setMinValue(view.getinputMinTemp());
			thermostat.setMaxValue(view.getinputMaxTemp());
			thermostat.setSampleIncrement(view.getTempInterval());
			thermostat.setMeasurementName("Temperature");
			
			//Starts the three threads in the model
			sprinkler.start();
			humidifier.start();
			thermostat.start();
			//Starts the update output thread which updates values of the three parameters on 
			//screen after an interval
			outputUpdateHumidifier.start();
			outputUpdateSprinkler.start();
			outputUpdateThermostat.start();
		}
		
		//Checks if the save button is clicked
		else if (((JButton)e.getSource()).getText() == "Save")
		{
			//Stops the four threads running
			sprinkler.setFlag(false);
			humidifier.setFlag(false);
			thermostat.setFlag(false);
			outputUpdateHumidifier.setFlag(false);
			outputUpdateSprinkler.setFlag(false);
			outputUpdateThermostat.setFlag(false);
			
			//Writes the values to a text file called "savedTextFile.txt" which is 
			// saved in the same workspace where the program is saved
			PrintWriter outputStream = null;
			try
			{
				outputStream = new PrintWriter(new FileOutputStream("savedFile.txt"));
				
				//First the values for humidity are taken from view and written on a text file
				outputStream.println(view.getinputInitHumidity());
				outputStream.println(view.getinputHumidityChangeEx());
				outputStream.println(view.getinputHumidityChangeIn());
				outputStream.println(view.getinputMinHumidity());
				outputStream.println(view.getinputMaxHumidity());
				outputStream.println(view.getHumidityInterval());
				outputStream.println(humidifier.getCurrentValue());
				
				//Second the values for soil moisture are taken from view and written on a text file
				outputStream.println(view.getinputInitSoilMoisture());
				outputStream.println(view.getinputSoilMoistChangeEx());
				outputStream.println(view.getinputSoilMoistChangeIn());
				outputStream.println(view.getinputMinSoilMoisture());
				outputStream.println(view.getinputMaxSoilMoisture());	
				outputStream.println(view.getSoilMoistureInterval());
				outputStream.println(sprinkler.getCurrentValue());
				
				//Second the values for temperature are taken from view and written on a text file
				outputStream.println(view.getinputInitTemp());
				outputStream.println(view.getinputTempChangeEx());
				outputStream.println(view.getinputTempChangeInAC());
				outputStream.println(view.getinputTempChangeInFurnace());
				outputStream.println(view.getinputMinTemp());
				outputStream.println(view.getinputMaxTemp());	
				outputStream.println(view.getTempInterval());
				outputStream.println(thermostat.getCurrentValue());
				
				//Finally the print writer is closed
				outputStream.close();
			}
			
			
			
			//Exception handling for case when file can not be found
			// Displays a message on the screen
			catch(FileNotFoundException exception)
			{
				view.setErrorMessage("No file found");
			}
		}
		
		//Checks if the save button is clicked
		if (((JButton)e.getSource()).getText() == "Stop")
		{
			//Stops the four threads running
			sprinkler.setFlag(false);
			humidifier.setFlag(false);
			thermostat.setFlag(false);
			outputUpdateHumidifier.setFlag(false);
			outputUpdateSprinkler.setFlag(false);
			outputUpdateThermostat.setFlag(false);
		}
		
		//Checks if the load button is clicked
		if (((JButton)e.getSource()).getText() == "Load")
		{
			//Creates a scanner to read from a text file
			Scanner inputStream = null;
			//String inputString = null;
			 try
			 {
				 inputStream = new Scanner(new FileInputStream("savedFile.txt"));
				 
				 //Sets the values on the view(screen) for humidity which is saved in the text file
				 view.setInputInitHumidity(inputStream.nextLine());
				 view.setInputHumidityChangeEx(inputStream.nextLine());
				 view.setInputHumidityChangeIn(inputStream.nextLine());
				 view.setInputMinHumidity((inputStream.nextLine()));
				 view.setInputMaxHumidity((inputStream.nextLine()));
				 view.setHumidityInterval((inputStream.nextLine()));
				 view.setCurrentHumidity(Double.parseDouble(inputStream.nextLine()));
				 
				 //Sets the values on the view(screen) for soil moisture which is saved in the text file
				 view.setInputInitSoilMoisture(inputStream.nextLine());
				 view.setInputSoilMoistChangeEx(inputStream.nextLine());
				 view.setInputSoilMoistChangeIn(inputStream.nextLine());
				 view.setInputMinSoilMoisture((inputStream.nextLine()));
				 view.setInputMaxSoilMoisture((inputStream.nextLine()));
				 view.setSoilMoistureInterval(inputStream.nextLine());
				 view.setCurrentSoilMoisture(Double.parseDouble(inputStream.nextLine()));

				 //Sets the values on the view(screen) for temperature which is saved in the text file
				 view.setInputInitTemp(inputStream.nextLine());
				 view.setInputTempChangeEx(inputStream.nextLine());
				 view.setInputTempChangeInAC(inputStream.nextLine());
				 view.setInputTempChangeInFurnace(inputStream.nextLine());
				 view.setInputMinTemp((inputStream.nextLine()));
				 view.setInputMaxTemp((inputStream.nextLine()));
				 view.setTempInterval(inputStream.nextLine());
				 view.setCurrentTemp(Double.parseDouble(inputStream.nextLine()));
			 }
			 
			//Exception handling for case when file can not be found
				// Displays a message on the screen
			 catch(FileNotFoundException exception)
			{
					view.setErrorMessage("No file found");
			}
		}
	}

}
