package ex4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FlightRepositoryImplAnnotated implements FlightRepository {

	@Autowired
	private DataSource dataSource;
	
	public List<Flight> getAvailableFlights() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from flights_test";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			List<Flight> rows = new ArrayList<Flight>();
			while(rs.next()) {
				Flight f = new Flight();
				f.setFlightNo(rs.getString(1));
				f.setCarrier(rs.getString(2));
				f.setFrom(rs.getString(3));
				f.setTo(rs.getString(4));
				rows.add(f);
			}
			return rows;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			try { rs.close(); pst.close(); conn.close(); } catch(Exception e) { }
		}
	}
}
