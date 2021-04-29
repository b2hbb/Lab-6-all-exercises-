package ftmk.rmi.sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface represents temperature sensor
 * 
 * @author Abdullah
 *
 */
public interface TemperatureSensor extends Remote {
	
	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;
	
	//Temperature for specific day
	public int getTemperatureForSpecificDay(String day) throws RemoteException;

	//Average weekly temperature
	public float getAverageWeeklyTemperature() throws RemoteException;
}
