/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Device Model*/

package beans;

public class Device {
	int temp;
	String time;
	String location;
	
	public Device(int temp, String time, String location) {
		
		this.temp = temp;
		this.time = time;
		this.location = location;
	}
	
	public Device()
	{
		temp = 0;
		time = "";
		location = "";
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
