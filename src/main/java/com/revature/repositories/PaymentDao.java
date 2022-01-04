package com.revature.repositories;

import java.util.List;

import com.revature.models.Payments;

public interface PaymentDao {
	Payments viewRemainingPay();
	List<Payments> viewAllPay();
	List<Payments> viewAllMyPay();
	Payments calWeeklyPays();
	Payments getPayed(int id);
	Payments makeaPayment(Payments p);
}
