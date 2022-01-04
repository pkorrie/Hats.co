package com.revature.repositories;

import java.util.List;

import com.revature.models.Offers;

public interface OffersDao {
	Offers makeAnOffer(Offers offer);
	Offers getOfferById(int id);
	boolean updateOffer(Offers  of);
	boolean deleteOffer(Offers  of);
	List<Offers> getAllOffers();
	List<Offers> getAllPendingOffers();
	boolean deleteAllOffers(Offers  of);
}
