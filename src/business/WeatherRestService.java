/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Weather REST API*/

package business;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Device;
import beans.ResponseDataModel;

@RequestScoped
@Path("/weather")
@Produces({ "application/json" })
@Consumes({ "application/json" })
public class WeatherRestService {

	List<Device> deviceList = new ArrayList<Device>();
	
	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public WeatherRestService()
	{

	}
	
	@GET
	@Path("http://192.168.1.16:8080/DataGenerator/rest/device/getdevicej")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Device> getWeather() throws JsonParseException, JsonMappingException, MalformedURLException, IOException
	{
		deviceList.removeAll(deviceList);
		DeviceBusinessService dbs = new DeviceBusinessService();
		ObjectMapper oj = new ObjectMapper();
		
		ResponseDataModel d1 = oj.readValue(new URL("http://192.168.1.16:8080/DataGenerator/rest/device/getdevicej"), ResponseDataModel.class);
	
		
		for(int i=0; i<d1.getData().size(); i++)
		{
			Device device = d1.getData().get(i);
			deviceList.add(device);
			dbs.createDevice(device);
		}
		
		return deviceList;
	}
}