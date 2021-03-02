/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Response Data Model*/

package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDataModel extends ResponseModel {

	private List<Device> data;
	
	public ResponseDataModel() {
		super();
		data = new ArrayList<Device>();
	}

	public List<Device> getData() {
		return data;
	}

	public void setData(List<Device> realtimeData) {
		this.data = realtimeData;
	}
	
	
}
