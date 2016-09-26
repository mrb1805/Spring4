package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import main.TradeApp;
import main.TradeData;


public class DaoTokyo implements TradeData {

	private DataSource dataSourceTK;
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSourceTK = dataSource;
	}

	public void getTradeDetails(String tradeId) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = dataSourceTK.getConnection();
			String sql = "select amount from tk_trade WHERE tradeId="+tradeId+"";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				TradeApp f = new TradeApp();
				f.setAmount(rs.getString(2));
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			try { rs.close(); pst.close(); conn.close(); } catch(Exception e) { }
		}
	}
}
