

/**
 * The class view is a subclass of JFrame which has all the components of the screen, 
 * which include the 
 * @author Atika and Karis
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame
{

	/**Declares the container called paneMain*/
	private Container paneMain;
	
	/**Declares the panels*/
	private JPanel TempPanel;
	private JPanel HumidityPanel;
	private JPanel soilMoisturePanel;
	private JPanel buttonPanel;
	private JPanel outputPanel;
	
	/**Declares the initial values label*/
	private JLabel initTemp;
	private JLabel initHumidity;
	private JLabel initSoilMoisture;
	
	/**Declares the initial values text boxes*/
	private JTextField inputInitTemp;
	private JTextField inputInitHumidity;
	private JTextField inputInitSoilMoisture;
	
	/**Declares the rate of change of values by external conditions label*/
	private JLabel rateTempChangeEx;
	private JLabel rateHumidityChangeEx;
	private JLabel rateSoilMoistChangeEx;
	
	/**Declares the rate of change of values by external conditions text boxes for user input*/
	private JTextField inputTempChangeEx;
	private JTextField inputHumidityChangeEx;
	private JTextField inputSoilMoistChangeEx;
	
	/**Declares the rate of change of values by internal conditions label*/
	private JLabel rateTempChangeInFurnace;
	private JLabel rateTempChangeInAC;
	private JLabel rateHumidityChangeIn;
	private JLabel rateSoilMoistChangeIn;
	
	/**Declares the rate of change of values by internal conditions text boxes for user input*/
	private JTextField inputTempChangeInFurnace;
	private JTextField inputTempChangeInAC;
	private JTextField inputHumidityChangeIn;
	private JTextField inputSoilMoistChangeIn;
	
	/**Declares the minimum and maximum values labels*/
	private JLabel minDesiredTemp;
	private JLabel maxDesiredTemp;
	private JLabel minDesiredHumidity;
	private JLabel maxDesiredHumidity;
	private JLabel minDesiredSoilMoisture;
	private JLabel maxDesiredSoilMoisture;
	
	/**Declares the minimum and maximum values text boxes for user input*/
	private JTextField inputMinTemp;
	private JTextField inputMaxTemp;
	private JTextField inputMinHumidity;
	private JTextField inputMaxHumidity;
	private JTextField inputMinSoilMoisture;
	private JTextField inputMaxSoilMoisture;
	
	/**Declares the current values labels*/
	private JLabel currentTemp;
	private JLabel currentTempValue;
	private JLabel currentHumidity;
	private JLabel currentHumidityValue;
	private JLabel currentSoilMoisture;
	private JLabel currentSoilMoistureValue;

	/**Declares the buttons and labels for displaying the state of the devices*/
	private JButton runButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton stopButton;
	private JLabel errorMessage;
	private JLabel furnace;
	private JLabel furnaceState;
	private JLabel AC;
	private JLabel ACState;
	private JLabel sprinkler;
	private JLabel sprinklerState;
	private JLabel humidifier;
	private JLabel humidifierState;
	
	/**Declares the labels and text fields for sample increment input for the three parameters*/
	private JLabel tempIntervalLabel;
	private JLabel soilMoistureIntervalLabel;
	private JLabel humidityIntervalLabel;
	private JTextField tempIntervalInput;
	private JTextField soilMoistureIntervalInput;
	private JTextField humidityIntervalInput;

	
	/**Declares and initializes the GridBagConstraints for gridbaglayout*/
	private GridBagConstraints gbc = new GridBagConstraints();
	
	/**The default constructor initializes the labels, buttons, panels and text boxes. 
	 * Finally, it adds the components to the respective panels and the panels to the pane*/
	public View() 
	{
		//Sets the name of window
		super("Climate Control System");
		//Calls the method to set the settings of the frame
		formatFrame();
		
		//Initializes the panels
		TempPanel = new JPanel(new GridBagLayout());
		HumidityPanel = new JPanel(new GridBagLayout());
		soilMoisturePanel = new JPanel(new GridBagLayout());
		buttonPanel = new JPanel(new GridBagLayout());
		outputPanel = new JPanel(new GridBagLayout());
	
		//Initializes the button
		saveButton = new JButton("Save");
		runButton = new JButton("Run");
		loadButton = new JButton("Load");
		stopButton = new JButton("Stop");

		//Initializes the label for current values
		initTemp = new JLabel("Current temperature:");
		initHumidity = new JLabel("Current humidity level (%):");
		initSoilMoisture = new JLabel("Current soil moisture level (%):");
		
		//Initializes the text boxes for user input (initial values)
		inputInitTemp = new JTextField(5);
		inputInitHumidity = new JTextField(5);
		inputInitSoilMoisture = new JTextField(5);
		
		//Initializes the labels for external rate of change values
		rateTempChangeEx = new JLabel("Rate of change of temperature by external conditions:");
		rateHumidityChangeEx = new JLabel("Rate of change of humidity level by external conditions (% per second):");
		rateSoilMoistChangeEx = new JLabel("Rate of change of soil moisture by external conditions (% per second):");
		
		//Initializes the text boxes for user input(external rate of change values)
		inputTempChangeEx = new JTextField(5);
		inputHumidityChangeEx = new JTextField(5);
		inputSoilMoistChangeEx = new JTextField(5);
		
		//Initializes the labels for internal rate of change values
		rateTempChangeInFurnace = new JLabel("Rate of change of temperature by internal conditions (furnace) (per second):");
		rateTempChangeInAC = new JLabel("Rate of change of temperature by internal conditions (AC) (per second):");
		rateHumidityChangeIn = new JLabel("Rate of change of humidity level by internal conditions (% per second):");
		rateSoilMoistChangeIn = new JLabel("Rate of change of soil moisture by internal conditions (% per second):");
		
		//Initializes the text boxes for user input(internal rate of change values)
		inputTempChangeInFurnace = new JTextField(5);
		inputTempChangeInAC = new JTextField(5);
		inputHumidityChangeIn = new JTextField(5);
		inputSoilMoistChangeIn = new JTextField(5);
		
		//Initializes the labels for minimum and maximum values
		minDesiredTemp = new JLabel("Minimum desired temperature:");
		maxDesiredTemp = new JLabel("Maximum desired temperature:");
		minDesiredHumidity = new JLabel("Minimum desired humidity (%):");
		maxDesiredHumidity = new JLabel("Maximum desired humidity (%):");
		minDesiredSoilMoisture = new JLabel("Minimum desired soil moisture (%):");
		maxDesiredSoilMoisture = new JLabel("Maximum desired soil moisture (%):");
		
		//Initializes the text boxes for user input(minimum and maximum values)
		inputMinTemp = new JTextField(5);
		inputMaxTemp = new JTextField(5);
		inputMinHumidity = new JTextField(5);
		inputMaxHumidity = new JTextField(5);
		inputMinSoilMoisture = new JTextField(5);
		inputMaxSoilMoisture = new JTextField(5);
		
		//Initializes the labels for displaying current values
		currentTemp = new JLabel("Current temperature:");
		currentTempValue = new JLabel("");
		currentHumidity = new JLabel("Current humidity level (%):");
		currentHumidityValue = new JLabel("");
		currentSoilMoisture = new JLabel("Current soil moisture level (%):");
		currentSoilMoistureValue = new JLabel("");
		
		//Initializes the labels for displaying state of the devices and error message
		furnace = new JLabel("Furnace:");
		furnaceState = new JLabel("");
		sprinkler = new JLabel("Sprinkler:");
		sprinklerState = new JLabel("");
		AC = new JLabel("AC:");
		ACState = new JLabel("");
		humidifier = new JLabel("Humidifier:");
		humidifierState = new JLabel("");
		errorMessage = new JLabel("");
	
		//Initializes labels for sample increment input for temperature, soil moisture and humidity
		tempIntervalLabel = new JLabel("Temperature output update interval (seconds):");
		soilMoistureIntervalLabel = new JLabel("Soil moisture output update interval (seconds):");
		humidityIntervalLabel = new JLabel("Humidity output update interval (seconds):");
		tempIntervalInput = new JTextField(5);
		soilMoistureIntervalInput = new JTextField(5);
		humidityIntervalInput = new JTextField(5);

		paneMain = this.getContentPane();
		paneMain.setLayout(new FlowLayout());
		
		/*Sets the position of the components on the panel using grid bag layout and 
		 * adds the components for temperature to the temperature panel*/
		gbc.gridx=0;
		gbc.gridy = 0;
		TempPanel.add(initTemp, gbc);
		gbc.gridx= 4;
		gbc.gridy = 0;
		TempPanel.add(inputInitTemp,gbc);
		gbc.gridx= 0;
		gbc.gridy = 6;
		TempPanel.add(rateTempChangeEx,gbc);
		gbc.gridx= 4;
		gbc.gridy = 6;
		TempPanel.add(inputTempChangeEx,gbc);
		gbc.gridx= 0;
		gbc.gridy = 12;
		TempPanel.add(rateTempChangeInFurnace,gbc);
		gbc.gridx= 4;
		gbc.gridy = 12;
		TempPanel.add(inputTempChangeInFurnace,gbc);
		gbc.gridx= 0;
		gbc.gridy = 18;
		TempPanel.add(rateTempChangeInAC,gbc);
		gbc.gridx= 4;
		gbc.gridy = 18;
		TempPanel.add(inputTempChangeInAC,gbc);
		gbc.gridx= 0;
		gbc.gridy = 24;
		TempPanel.add(minDesiredTemp,gbc);
		gbc.gridx= 4;
		gbc.gridy = 24;
		TempPanel.add(inputMinTemp,gbc);
		gbc.gridx= 0;
		gbc.gridy = 30;
		TempPanel.add(maxDesiredTemp,gbc);
		gbc.gridx= 4;
		gbc.gridy = 30;
		TempPanel.add(inputMaxTemp,gbc);
		gbc.gridx= 0;
		gbc.gridy = 34;
		TempPanel.add(tempIntervalLabel,gbc);
		gbc.gridx= 4;
		gbc.gridy = 34;
		TempPanel.add(tempIntervalInput,gbc);
		
		/*Sets the position of the components on the panel using grid bag layout and 
		 * adds the components for humidity to the humidity panel*/
		gbc.gridx=0;
		gbc.gridy = 0;
		HumidityPanel.add(initHumidity,gbc);
		gbc.gridx= 4;
		gbc.gridy = 0;
		HumidityPanel.add(inputInitHumidity,gbc);
		gbc.gridx= 0;
		gbc.gridy = 6;
		HumidityPanel.add(rateHumidityChangeEx,gbc);
		gbc.gridx= 4;
		gbc.gridy = 6;
		HumidityPanel.add(inputHumidityChangeEx,gbc);
		gbc.gridx= 0;
		gbc.gridy = 12;
		HumidityPanel.add(rateHumidityChangeIn,gbc);
		gbc.gridx= 4;
		gbc.gridy = 12;
		HumidityPanel.add(inputHumidityChangeIn,gbc);
		gbc.gridx= 0;
		gbc.gridy = 18;
		HumidityPanel.add(minDesiredHumidity,gbc);
		gbc.gridx= 4;
		gbc.gridy = 18;
		HumidityPanel.add(inputMinHumidity,gbc);
		gbc.gridx= 0;
		gbc.gridy = 24;
		HumidityPanel.add(maxDesiredHumidity,gbc);
		gbc.gridx= 4;
		gbc.gridy = 24;
		HumidityPanel.add(inputMaxHumidity,gbc);
		gbc.gridx= 0;
		gbc.gridy = 30;
		HumidityPanel.add(humidityIntervalLabel,gbc);
		gbc.gridx= 4;
		gbc.gridy = 30;
		HumidityPanel.add(humidityIntervalInput,gbc);
		
		/*Sets the position of the components on the panel using grid bag layout and 
		 * adds the components for soil moisture to the soil moisture panel*/
		gbc.gridx=0;
		gbc.gridy = 0;
		soilMoisturePanel.add(initSoilMoisture,gbc);
		gbc.gridx= 4;
		gbc.gridy = 0;
		soilMoisturePanel.add(inputInitSoilMoisture,gbc);
		gbc.gridx= 0;
		gbc.gridy = 6;
		soilMoisturePanel.add(rateSoilMoistChangeEx,gbc);
		gbc.gridx= 4;
		gbc.gridy = 6;
		soilMoisturePanel.add(inputSoilMoistChangeEx,gbc);
		gbc.gridx= 0;
		gbc.gridy = 12;
		soilMoisturePanel.add(rateSoilMoistChangeIn,gbc);
		gbc.gridx= 4;
		gbc.gridy = 12;
		soilMoisturePanel.add(inputSoilMoistChangeIn,gbc);
		gbc.gridx= 0;
		gbc.gridy = 18;
		soilMoisturePanel.add(minDesiredSoilMoisture,gbc);
		gbc.gridx= 4;
		gbc.gridy = 18;
		soilMoisturePanel.add(inputMinSoilMoisture,gbc);
		gbc.gridx= 0;
		gbc.gridy = 24;
		soilMoisturePanel.add(maxDesiredSoilMoisture,gbc);
		gbc.gridx= 4;
		gbc.gridy = 24;
		soilMoisturePanel.add(inputMaxSoilMoisture,gbc);
		gbc.gridx= 0;
		gbc.gridy = 30;
		soilMoisturePanel.add(soilMoistureIntervalLabel,gbc);
		gbc.gridx= 4;
		gbc.gridy = 30;
		soilMoisturePanel.add(soilMoistureIntervalInput,gbc);
		
		//Adds buttons to a separate panel
		buttonPanel.add(runButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		
		//Adds the output value labels to another panel and sets their position of 
		// panel using grid bag layout
		gbc.gridx=0;
		gbc.gridy = 0;
		outputPanel.add(currentTemp,gbc);
		gbc.gridx= 4;
		gbc.gridy = 0;
		outputPanel.add(currentTempValue,gbc);
		gbc.gridx= 0;
		gbc.gridy = 8;
		outputPanel.add(furnace,gbc);
		gbc.gridx= 4;
		gbc.gridy = 8;
		outputPanel.add(furnaceState,gbc);
		gbc.gridx= 0;
		gbc.gridy = 12;
		outputPanel.add(AC,gbc);
		gbc.gridx= 4;
		gbc.gridy = 12;
		outputPanel.add(ACState,gbc);
		gbc.gridx= 0;
		gbc.gridy = 16;
		outputPanel.add(currentHumidity,gbc);
		gbc.gridx= 4;
		gbc.gridy = 16;
		outputPanel.add(currentHumidityValue,gbc);
		gbc.gridx= 0;
		gbc.gridy = 20;
		outputPanel.add(humidifier,gbc);
		gbc.gridx= 4;
		gbc.gridy = 20;
		outputPanel.add(humidifierState,gbc);
		gbc.gridx= 0;
		gbc.gridy = 24;
		outputPanel.add(currentSoilMoisture,gbc);
		gbc.gridx= 4;
		gbc.gridy = 24;
		outputPanel.add(currentSoilMoistureValue,gbc);
		gbc.gridx= 0;
		gbc.gridy = 28;
		outputPanel.add(sprinkler,gbc);
		gbc.gridx= 4;
		gbc.gridy = 28;
		outputPanel.add(sprinklerState,gbc);
		gbc.gridx= 0;
		gbc.gridy = 32;
		outputPanel.add(errorMessage,gbc);
		
		//Adds the panels to the paneMain ( container) and sets background color and visibility of frame
		paneMain.setLayout(new FlowLayout());
		paneMain.add(TempPanel);
		paneMain.add(HumidityPanel);
		paneMain.add(soilMoisturePanel);
		paneMain.add(buttonPanel);
		paneMain.add(outputPanel);
		paneMain.setBackground(Color.GREEN);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**Sets the size of the window relative to the screen and its location on the screen*/
	public void formatFrame() 
	{
		//Sets size of window relative to the screen.
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenDimensions = toolKit.getScreenSize();
		int height = (int) (screenDimensions.height/1.10);
		int width = (int) (screenDimensions.width/2);
		setSize(width,height);
		
		//Sets the location and alignment of the window on the screen.
		setLocation(0,0);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Gets value of initial temperature
	 * @return double value of initial temperature
	 * */
	public double getinputInitTemp()
	{
		return (Double.parseDouble(inputInitTemp.getText()));
	}
	
	/**
	 * Gets value of initial humidity level
	 * @return double 
	 * */
	public double getinputInitHumidity()
	{
		return (Double.parseDouble(inputInitHumidity.getText()));
	}
	
	/**
	 * Gets value of initial soil moisture level 
	 * @return double 
	 **/
	public double getinputInitSoilMoisture()
	{
		return (Double.parseDouble(inputInitSoilMoisture.getText()));
	}
	
	/**
	 * Gets value of rate of change of temperature by external conditions entered by user
	 * @return double
	 * */
	public double getinputTempChangeEx()
	{
		return (Double.parseDouble(inputTempChangeEx.getText()));
	}
	
	/**
	 * Gets value of rate of change of humidity level by external conditions entered by user
	 * @return double 
	 * */
	public double getinputHumidityChangeEx()
	{
		return (Double.parseDouble(inputHumidityChangeEx.getText()));
	}
	
	/**
	 * Gets value of rate of change of soil moisture level by external conditions entered by user
	 * @return double 
	 * */
	public double getinputSoilMoistChangeEx()
	{
		return (Double.parseDouble(inputSoilMoistChangeEx.getText()));
	}
	
	/**
	 * Gets value of rate of change of temperature by furnace entered by user
	 * @return double 
	 * */
	public double getinputTempChangeInFurnace()
	{
		return (Double.parseDouble(inputTempChangeInFurnace.getText()));
	}
	
	/**
	 * Gets value of rate of change of temperature by air conditioner entered by user
	 * @return double 
	 * */
	public double getinputTempChangeInAC()
	{
		return (Double.parseDouble(inputTempChangeInAC.getText()));
	}
	
	/**
	 * Gets value of rate of change of humidity level by humidifier entered by user
	 * @return double 
	 * */
	public double getinputHumidityChangeIn()
	{
		return (Double.parseDouble(inputHumidityChangeIn.getText()));
	}
	
	/**Gets value of rate of change of soil moisture level by sprinkler entered by user
	 * @return double 
	 * */
	public double getinputSoilMoistChangeIn()
	{
		return (Double.parseDouble(inputSoilMoistChangeIn.getText()));
	}
	
	/**
	 * Gets value of minimum desired temperature entered by user
	 * @return double 
	 * */
	public double getinputMinTemp()
	{
		return (Double.parseDouble(inputMinTemp.getText()));
	}
	
	/**
	 * Gets value of maximum desired temperature entered by user
	 * @return double 
	 * */
	public double getinputMaxTemp()
	{
		return (Double.parseDouble(inputMaxTemp.getText()));
	}
	
	/**
	 * Gets value of minimum desired humidity level entered by user
	 * @return double 
	 * */
	public double getinputMinHumidity()
	{
		return (Double.parseDouble(inputMinHumidity.getText()));
	}
	
	/**
	 * Gets value of maximum desired humidity level entered by user
	 * @return double 
	 * */
	public double getinputMaxHumidity()
	{
		return (Double.parseDouble(inputMaxHumidity.getText()));
	}
	
	/**
	 * Gets value of minimum soil moisture level entered by user
	 * @return double 
	 * */
	public double getinputMinSoilMoisture()
	{
		return (Double.parseDouble(inputMinSoilMoisture.getText()));
	}
	
	/**
	 * Gets value of maximum desired soil moisture level entered by user
	 * @return double 
	 * */
	public double getinputMaxSoilMoisture()
	{
		return (Double.parseDouble(inputMaxSoilMoisture.getText()));
	}
	
	/**
	 * Gets value of sample increment input entered by user for temperature
	 * @return double 
	 * */
	public  double getTempInterval()
	{
		return (Double.parseDouble(tempIntervalInput.getText()));
	}
	
	/**
	 * Gets value of sample increment input entered by user for humidity
	 * @return double 
	 * */
	public  double getHumidityInterval()
	{
		return (Double.parseDouble(humidityIntervalInput.getText()));
	}
	
	/**
	 * Gets value of sample increment input entered by user for soil moisture
	 * @return double 
	 * */
	public  double getSoilMoistureInterval()
	{
		return (Double.parseDouble(soilMoistureIntervalInput.getText()));
	}
	
	/**Sets the value of current temperature on screen*/
	public void setCurrentTemp(double value)
	{
		currentTempValue.setText(String.valueOf(value));
	}
	
	/**Sets the value of current humidity level on screen*/
	public void setCurrentHumidity(double value)
	{
		currentHumidityValue.setText(String.valueOf(value));
	}

	/**Sets the value of current soil moisture level on screen*/
	public void setCurrentSoilMoisture(double value)
	{
		currentSoilMoistureValue.setText(String.valueOf(value));
	}
	
	/**Displays the error message on screen*/
	public void setErrorMessage(String message)
	{
		errorMessage.setText(message);
	}
	
	/**Adds action listener to the buttons*/
	public void setListenerToButtons(ActionListener listener)
	{
		saveButton.addActionListener(listener);
		runButton.addActionListener(listener);
		stopButton.addActionListener(listener);
		loadButton.addActionListener(listener);

	}

	/**Sets the initial temperature in the text box
	 * @param String
	 * */
	public void setInputInitTemp(String inputInitTemp) {
		this.inputInitTemp.setText(inputInitTemp);
	}

	/**Sets the initial humidity level in the text box
	 * @param String
	 * */
	public void setInputInitHumidity(String inputInitHumidity) {
		this.inputInitHumidity.setText(inputInitHumidity);
	}

	/**Sets the initial soil moisture level in the text box*
	 * @param String
	 * */
	public void setInputInitSoilMoisture(String inputInitSoilMoisture) {
		this.inputInitSoilMoisture.setText(inputInitSoilMoisture);
	}

	/**Sets the value of rate of change in temperature by external conditions in the text box
	 * @param String
	 * */
	public void setInputTempChangeEx(String inputTempChangeEx) {
		this.inputTempChangeEx.setText(inputTempChangeEx);
	}

	/**Sets the value of rate of change in humidity level by external conditions in the text box
	 * @param String
	 * */
	public void setInputHumidityChangeEx(String inputHumidityChangeEx) {
		this.inputHumidityChangeEx.setText(inputHumidityChangeEx);
	}

	/**Sets the value of rate of change in soil moisture level by external conditions in the text box
	 * @param String
	 * */
	public void setInputSoilMoistChangeEx(String inputSoilMoistChangeEx) {
		this.inputSoilMoistChangeEx.setText(inputSoilMoistChangeEx);
	}

	/**Sets the value of rate of change in temperature by furnace in the text box
	 * @param String
	 * */
	public void setInputTempChangeInFurnace(String inputTempChangeInFurnace) {
		this.inputTempChangeInFurnace.setText(inputTempChangeInFurnace);
	}

	/**Sets the value of rate of change in temperature by air conditioner in the text box
	 * @param String
	 * */
	public void setInputTempChangeInAC(String inputTempChangeInAC) {
		this.inputTempChangeInAC.setText(inputTempChangeInAC);
	}

	/**Sets the value of rate of change in humidity by humidifier in the text box
	 * @param String
	 * */
	public void setInputHumidityChangeIn(String inputHumidityChangeIn) {
		this.inputHumidityChangeIn.setText(inputHumidityChangeIn);
	}

	/**Sets the value of rate of change in soil moisture by sprinkler in the text box*
	 *@param String
	 **/
	public void setInputSoilMoistChangeIn(String inputSoilMoistChangeIn) {
		this.inputSoilMoistChangeIn.setText(inputSoilMoistChangeIn);
	}

	/**Sets the value of minimum desired temperature in the text box
	 * @param String
	 * */
	public void setInputMinTemp(String inputMinTemp) {
		this.inputMinTemp.setText(inputMinTemp);
	}

	/**Sets the value of maximum desired temperature in the text box
	 * @param String
	 * */
	public void setInputMaxTemp(String inputMaxTemp) {
		this.inputMaxTemp.setText(inputMaxTemp);
	}

	/**Sets the value of minimum desired humidity level in the text box
	 * @param String
	 * */
	public void setInputMinHumidity(String inputMinHumidity) {
		this.inputMinHumidity.setText(inputMinHumidity);
	}

	/**Sets the value of maximum desired humidity level in the text box
	 * @param String
	 * */
	public void setInputMaxHumidity(String inputMaxHumidity) {
		this.inputMaxHumidity.setText(inputMaxHumidity);
	}

	/**Sets the value of minimum desired soil moisture level in the text box
	 * @param String
	 * */
	public void setInputMinSoilMoisture(String inputMinSoilMoisture) {
		this.inputMinSoilMoisture.setText(inputMinSoilMoisture);
	}

	/**Sets the value of maximum desired soil moisture level in the text box
	 * @param String
	 * */
	public void setInputMaxSoilMoisture(String inputMaxSoilMoisture) {
		this.inputMaxSoilMoisture.setText(inputMaxSoilMoisture);
	}
	
	/**Sets the state of furnace on screen to on or off
	 * @param String
	 * */
	public void setFurnaceState(String state)
	{
		furnaceState.setText(state);
	}
	
	/**Sets the state of air conditioner on screen to on or off
	 * @param String
	 * */
	public void setACState(String state)
	{
		ACState.setText(state);
	}
	
	/**Sets the state of humidifier on screen to on or off
	 * @param String
	 * */
	public void setHumidifierState(String state)
	{
		humidifierState.setText(state);
	}
	
	/**Sets the state of sprinkler on screen to on or off
	 * @param String
	 * */
	public void setSprinklerState(String state)
	{
		sprinklerState.setText(state);
	}
	
	/**Sets the sample increment input for temperature in the text field
	 * @param String
	 * */
	public  void setTempInterval(String value)
	{
		tempIntervalInput.setText(value);
	}
	
	/**Sets the sample increment input for humidity in the text field
	 * @param String
	 * */
	public  void setHumidityInterval(String value)
	{
		humidityIntervalInput.setText(value);
	}
	
	/**Sets the sample increment input for soil moisture in the text field
	 * @param String
	 * */
	public  void setSoilMoistureInterval(String value)
	{
		soilMoistureIntervalInput.setText(value);
	}
	
}