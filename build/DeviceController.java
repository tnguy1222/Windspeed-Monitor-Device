package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import beans.Device;
import beans.LineChartBean;
import business.WeatherRestService;

@ManagedBean
@ViewScoped
public class DeviceController {

	@Inject
	WeatherRestService wrs;
	
	private LineChartModel lineModel;
	
	public LineChartModel getLineModel() {
		return lineModel;
	}
	
	List<Device> list = new ArrayList<Device>();
	public void refreshData()
	{
		WeatherRestService wrs = new WeatherRestService();
		try {
			list = wrs.getWeather();
			wrs.setDeviceList(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("devices", list);
	}
	
	@PostConstruct
	public void init() {
		lineModel = new LineChartModel();
		LineChartSeries s = new LineChartSeries();
		s.setLabel("IoT Device");

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
		x.setMax(4);
		x.setTickInterval("1");
		x.setLabel("Time");

	}
	
	public WeatherRestService getWrs()
	{
		return wrs;
	}
}
