package com.revature.services;


import java.util.List;

import com.revature.models.Payments;
import com.revature.repositories.PaymentDao;
import com.revature.repositories.PaymentsPostgres;

public class PaymentService {
	private PaymentDao pd = new PaymentsPostgres();
	
	public Payments makepay(Payments p) {
		Payments newPay = this.getPayById(p.getHatId());
		if(newPay != null) {
			System.out.println("Someone already made this offer");
		}
		return pd.makeaPayment(p);
		
		
	}
	
	private Payments getPayById(int id) {
		return pd.getPayed(id);
	}

	public List<Payments> viewAllPay() {
		return pd.viewAllPay();
	}
	
	public List<Payments> viewAllMyPay() {
		return pd.viewAllMyPay();
	}
}

