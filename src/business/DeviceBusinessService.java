/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Device Business Service*/

package business;

import java.util.List;

import beans.Database;
import beans.Device;
import data.DeviceDataService;

public class DeviceBusinessService {

	public boolean createDevice(Device device)
	{
		Database db = new Database();
		DeviceDataService dds = new DeviceDataService(db);
		
		return dds.createDevice(device);
	}
	
	public List<Device> findDevice()
	{
		Database db = new Database();
		DeviceDataService dds = new DeviceDataService(db);
		
		return dds.findDevice();
	}
}
