package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Subscribe;

import util.ConnectionUtil;

public class SubscribePostgres {
	public Subscribe addSubscribe(Subscribe sub) {
		String sql = "insert into subscribers(s_customer)" + "values (?)  returning s_id;";
		Subscribe resultId= null; 
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, sub.getSubscriber());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				resultId = sub;
			}
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
			}
		
		return resultId;
		
	}
	
	public Subscribe getsubsById(int id) {
		String sql = "select * from subscribers where s_id = ? ";
		Subscribe cust = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("s_id");
				int subscriber = rs.getInt("s_customer");
				cust = new Subscribe(id1,subscriber);
			}
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return cust;
	}

}
