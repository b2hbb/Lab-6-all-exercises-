import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

//New client created for Ayer Keroh
public class TemperatureClientAyerKerohRMIApp {
	public static void main(String[] args) {
		try {

			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();

			// Look-up for the remote object
			TemperatureSensor remoteSensorAyerKeroh =
							(TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");

			//Getting input day
			//Capitalizing first letter of day to match with tempData map key
			String day = args[0].substring(0, 1).toUpperCase() + args[0].substring(1);
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorAyerKeroh.getTemperature();
			
			System.out.println("Current temperature in Ayer Keroh is " + currentTemperature + " Celcius");
			
			//Get temperature for specific day
			int specificDayTemp = remoteSensorAyerKeroh.getTemperatureForSpecificDay(day);

			System.out.println(day + " temperature in Ayer Keroh is " + specificDayTemp + " Celcius");
			
			//Get weekly avg temperature
			float avgWklyTemp = remoteSensorAyerKeroh.getAverageWeeklyTemperature();

			System.out.println("Average weekly temperature in Ayer Keroh is " + avgWklyTemp + " Celcius");

		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
