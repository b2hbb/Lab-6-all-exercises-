package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author Abdullah
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {
	
	Map<String, Integer> tempData = null;
	
	public TemperatureSensorManager() throws RemoteException {
		super();
		//Loading tempData when object created
		loadTemperatureData();
	}
	
	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}
	
	//Getting Temperature for specific day in Ayer Keroh
		@Override
		public int getTemperatureForSpecificDay(String day)
											throws RemoteException {
			//Checking input is null or not
			if (day == null) {
				return 0;
			}
			
			//Getting temperature from Map data
			if (tempData != null) {
				//Checking day is available or not
				if (tempData.containsKey(day)) {
					
					//Returning specified day temperature
					return tempData.get(day);
				}
			}
			return 0;
		}
		
		//Loading temperature in Map
		public Map<String, Integer> loadTemperatureData() {
			tempData = new HashMap<>();
			tempData.put("Monday", 32);
			tempData.put("Tuesday", 31);
			tempData.put("Wednesday", 33);
			tempData.put("Thursday", 35);
			tempData.put("Friday", 36);
			tempData.put("Saturday", 33);
			tempData.put("Sunday", 33);
			
			return tempData;
		}
		
		@Override
		public float getAverageWeeklyTemperature() throws RemoteException {
			int totalTmp = 0;
			if (tempData != null) {
				for (String s : tempData.keySet()) {
					totalTmp += tempData.get(s);
				}
				
				return totalTmp / (float)7;
			}
			return 0.0f;
		}
	
}
