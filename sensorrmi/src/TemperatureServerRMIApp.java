import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;
import ftmk.rmi.sensor.manager.TemperatureSensorManager;

/**
 * This class represent the server-side application using RMI
 * 
 * @author Abdullah
 *
 */
public class TemperatureServerRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Create interface object
			TemperatureSensor sensorJasin = new TemperatureSensorManager();
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Register interface object as remote object
			rmiRegistry.rebind("SensorJasin", sensorJasin);
			
			System.out.println("SensorJasin is successfully registered");
			
			//New - Create Ayer Keroh Remote Object
			//Create new interface object
			TemperatureSensor sensorAyerKeroh = new TemperatureSensorManager();
			
			// Register interface object as remote object
			rmiRegistry.rebind("SensorAyerKeroh", sensorAyerKeroh);
						
			System.out.println("SensorAyerKeroh is successfully registered");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
