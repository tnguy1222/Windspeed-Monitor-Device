/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Line Chart Model*/

package beans;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import business.WeatherRestService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LineChartBean {
	private LineChartModel lineModel;

	@PostConstruct
	public void init() {
		lineModel = new LineChartModel();
		LineChartSeries s = new LineChartSeries();
		s.setLabel("IoT Device");

		WeatherRestService wrs = new WeatherRestService();
		List<Device> list = new ArrayList<Device>();
		try {
			list = wrs.getWeather();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<list.size(); i++)
		{
			s.set(i, list.get(i).getTemp());
		}

		lineModel.addSeries(s);
		lineModel.setLegendPosition("e");
		Axis y = lineModel.getAxis(AxisType.Y);
		y.setMin(0);
		y.setMax(120);
		y.setLabel("Temperature");

		Axis x = lineModel.getAxis(AxisType.X);
		x.setMin(0);
		x.setMax(6);
		x.setTickInterval("1");
		x.setLabel("Time");

	}

	public LineChartModel getLineModel() {
		return lineModel;
	}
}