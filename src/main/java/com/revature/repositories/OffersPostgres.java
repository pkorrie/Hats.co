package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Offers;

import util.ConnectionUtil;

public class OffersPostgres implements OffersDao {

	@Override
	public Offers makeAnOffer(Offers offer) {
		Offers resultId= null;
		String sql = "insert into offers(o_hat,o_offer )"+ "values (?, ?) returning o_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, offer.getHatId());
			ps.setDouble(2, offer.getOffer());
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				resultId = offer;
			}
		}catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultId;
	}

	@Override
	public boolean updateOffer(Offers of) {
		String sql = "update offers set o_acceptOffer = ?" + "Where o_id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, of.getAcceptoffer());
			ps.setInt(2, of.getId());
			
			rowsChanged = ps.executeUpdate();
			
		}catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}
		
		

	@Override
	public List<Offers> getAllOffers() {
		String sql = "select * from offers;";
		List<Offers> allOffers = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("o_id");
				int hat = rs.getInt("o_hat");
				double offer = rs.getDouble("o_offer");
				int customer = rs.getInt("o_customer");
				String acceptoffer = rs.getString("o_acceptoffer");
				
				Offers newOffer = new Offers(id,customer,hat,offer,acceptoffer);
				allOffers.add(newOffer);
				}
			} catch (SQLException |IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return allOffers;
	}

	@Override
	public List<Offers> getAllPendingOffers() {
		String sql = "select * from offers where o_acceptoffer = 'false';";
		List<Offers> allOffers1 = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("o_id");
				int hat = rs.getInt("o_hat");
				double offer = rs.getDouble("o_offer");
				int customer = rs.getInt("o_customer");
				String acceptoffer = rs.getString("o_acceptoffer");
				
				Offers newOffer1 = new Offers(id,customer,hat,offer,acceptoffer);
				allOffers1.add(newOffer1);
				}
			} catch (SQLException |IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return allOffers1;
	}

	@Override
	public Offers getOfferById(int id) {
		String sql = "select * from offers where o_id = ? ";
		Offers off = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int id1 = rs.getInt("o_id");
				int hat = rs.getInt("o_hat");
				double offer = rs.getDouble("o_offer");
				int customer = rs.getInt("o_customer");
				
				
				off = new Offers(id1,customer,hat,offer);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return off;
	}


	@Override
	public boolean deleteOffer(Offers of) {
		String sql = "delete from offers where o_id = ?;";
		
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);			
			ps.setInt(1, of.getId());		
			ps.executeUpdate();
			return true;
			
			
		}catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;

	}

	@Override
	public boolean deleteAllOffers(Offers  of) {
		String sql = "delete * offers where o_acceptoffer = 'false' and o_hat = ?;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);			
			ps.setInt(1, of.getHatId()); 
			ps.executeUpdate();
			return true;
		
		}catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}

}
