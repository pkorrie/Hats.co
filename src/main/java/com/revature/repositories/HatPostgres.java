package com.revature.repositories;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Hat;

import util.ConnectionUtil;

public class HatPostgres implements HatDao{
	private static Logger log = LogManager.getRootLogger();

	@Override
	public List<Hat> getAllHats() {
		String sql = "select * from hats;";
		
List<Hat> hats = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("h_id");
				String type = rs.getString("h_type");
				int price = rs.getInt("h_price");
				String color = rs.getString("h_color");
				String size = rs.getString("h_size");
				int ownedById = rs.getInt("h_ownedBy_id");
				
				Hat newHat = new Hat(id, type, price, color, size, ownedById);
				hats.add(newHat);
			}
			
			} catch (SQLException |IOException e) {
				log.error("Error while trying to get item.");
				e.printStackTrace();
			} 
		return hats;
	}

	@Override
	public Hat getHatById(int id) {
		String sql = "select * from hats where h_id = ? ";
		Hat emp = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("h_id");
				String type = rs.getString("h_type");
				int price = rs.getInt("h_price");
				String color = rs.getString("h_color");
				String size = rs.getString("h_size");
				int ownedById = rs.getInt("h_ownedBy_id");

				emp = new Hat(id1, type, price, color, size, ownedById);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Hat addHat(Hat hat) {
		Hat resultId= null;
		String sql = "insert into hats (h_type, h_price, h_color, h_size) "
				+ "values (?, ?, ?, ?) returning h_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, hat.getType());
			ps.setInt(2, hat.getPrice());
			ps.setString(3, hat.getColor());
			ps.setString(4, hat.getSize());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				resultId = hat;
			}

		} catch (SQLException | IOException e) {
			log.error("Error while trying to add item.");
			e.printStackTrace();
		}
		return resultId;
	}

	@Override
	public boolean editHat(Hat eh) {
		String sql = "update hats set h_type = ?, h_price = ?, h_color = ?, h_size = ?, h_ownedBy_id = ? "
				+ "where h_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, eh.getType());
			ps.setInt(2, eh.getPrice());
			ps.setString(3, eh.getColor());
			ps.setString(4, eh.getSize());
			ps.setInt(5, eh.getOwnedBy());
			ps.setInt(6, eh.getId());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			log.error("Error while trying to update item.");
			e.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int removeHat(int id) {
		String sql = "delete from hats where h_id = ?;";
		int rowsChanged1 = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			rowsChanged1 = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			log.error("Error while trying to remove item.");
			e.printStackTrace();
		}
		return rowsChanged1;
	}

	@Override
	public List<Hat> getAllAvaliableHats() {
		String sql = "select h_id, h_type,h_price,h_color,h_size from hats where h_ownedBy_id is NULL;";
		
		List<Hat> hats = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			
			while (rst.next()) {
				int id = rst.getInt("h_id");
				String type = rst.getString("h_type");
				int price = rst.getInt("h_price");
				String color = rst.getString("h_color");
				String size = rst.getString("h_size");
				
				Hat newHat = new Hat( id, type, price, color, size);
				hats.add(newHat);
			}
		} catch (SQLException | IOException e) {
			log.error("Error while trying to get items.");
			e.printStackTrace();
		}
		
		return hats;
	}

	@Override
	public List<Hat> viewOwnedHats() {
		String sql = "select h_id, h_type, h_price, h_color, h_size from hats h join offers o on h.h_id=o.o_hat;";
		List<Hat> ownedhats = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			
			
				while (rst.next()) {
					int id = rst.getInt("h_id");
					String type = rst.getString("h_type");
					int price = rst.getInt("h_price");
					String color = rst.getString("h_color");
					String size = rst.getString("h_size");
					
					Hat newHat = new Hat( id, type, price, color, size);
					ownedhats.add(newHat);
				
			}
		} catch (SQLException | IOException e) {
			log.error("Error while trying to get items.");
			e.printStackTrace();
		}
		
		return ownedhats;
	}



}
