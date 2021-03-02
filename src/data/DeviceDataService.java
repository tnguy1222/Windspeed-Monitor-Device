/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Device Data Service*/

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Database;
import beans.Device;

public class DeviceDataService {

	private Database connection = null;

	/**
	 * Non default constructor takes database as parameter
	 * 
	 * @param connection
	 */
	public DeviceDataService(Database connection) {
		this.connection = connection;
	}

	/**
	 * Insert a device to the database
	 * 
	 * @param user
	 * @return
	 */
	public boolean createDevice(Device device) {
		Connection conn = null;
		// tries connecting to the database and entering the users data into a database
		// table,
		// but prints an error message if it fails to connect or insert the data.
		try {
			// get database connection
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "INSERT INTO device(TEMP, TIME, LOCATION) VALUES (?, ?, ?)";

			// prepare sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, device.getTemp());
			stmt.setString(2, device.getTime());
			stmt.setString(3, device.getLocation());

			if (stmt.executeUpdate() > 0) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}

		}
		// Prints an error message if fails to connect or enter data.
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Find device in database
	 * 
	 * @param user
	 * @return
	 */
	public List<Device> findDevice() {
		Connection conn = null;
		// tries connecting to the database and entering the users data into a database
		// table,
		// but prints an error message if it fails to connect or insert the data.
		List<Device> devices = new ArrayList<Device>();
		
		try {
			// get database connection
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "SELECT TOP 5 * FROM device ORDER BY max(TIME) desc";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Device d1 = new Device();
				d1.setTemp(rs.getInt("TEMP"));
				d1.setTime(rs.getString("TIME"));
				d1.setLocation(rs.getString("Location"));

				devices.add(d1);
			}
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return devices;
	}
}
