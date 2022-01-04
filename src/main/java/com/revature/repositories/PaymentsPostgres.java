package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.Payments;

import util.ConnectionUtil;

public class PaymentsPostgres implements PaymentDao {

	@Override
	public Payments viewRemainingPay() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public List<Payments> viewAllPay() {
		String sql = "select * from pay;";
		List<Payments> allPays = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id1 = rs.getInt("p_id");
				int customer = rs.getInt("p_customer");
				int hat = rs.getInt("p_hat");
				double payed = rs.getDouble("p_payed");
				double remaining = rs.getInt("p_remaining");
				
				Payments newPay1 = new Payments(id1,customer,hat,payed,remaining);
				allPays.add(newPay1);
			}
		}catch (SQLException |IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allPays;
	}

	@Override
	public Payments calWeeklyPays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payments makeaPayment(Payments p) {
		Payments resultId= null;
		String sql = "insert into pay(p_customer, p_hat, p_payed, p_remaining)" + "values (?, ?, ?, ?) returning p_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, p.getCustomerId());
			ps.setInt(2, p.getHatId());
			ps.setDouble(3, p.getPayed());
			ps.setDouble(4, p.getRemaining());
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				resultId = p;
			}
			}catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultId;
	}

	@Override
	public Payments getPayed(int id) {
		String sql = "select * from payments where p_id = ? ";
		Payments payy = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int id1 = rs.getInt("p_id");
				int customer = rs.getInt("p_customer");
				int hat = rs.getInt("p_hat");
				double payed = rs.getDouble("p_payed");
				double remaining = rs.getInt("p_remaining");
				
				payy = new Payments(id1,customer,hat,payed,remaining);
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
				
		return payy;
	}



	@Override
	public List<Payments> viewAllMyPay() {
		String sql = "select p_id, p_hat, p_payed, p_remaining from pay p join offers o on p.p_customer = o.o_customer;";
		List<Payments> ownedPay = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			
			
				while (rst.next()) {
					int id = rst.getInt("p_id");
					int hat = rst.getInt("p_hat");
					double payed = rst.getDouble("p_payed");
					double remaining = rst.getDouble("p_remaining");
					
					Payments newPay = new Payments(id,hat,payed,remaining);
					ownedPay.add(newPay);
				}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return ownedPay;
	}

}
