package com.revature.services;

import java.util.List;

import com.revature.models.Offers;
import com.revature.repositories.OffersDao;
import com.revature.repositories.OffersPostgres;

public class OffersService {
	private OffersDao od = new OffersPostgres();
	
	public List<Offers> getAllPendingOffers(){
		return od.getAllPendingOffers();
	}
	
	public Offers makeOffer(Offers O) {
		Offers newOffer = this.getOfferById(O.getHatId());
		if(newOffer != null) {
			System.out.println("Someone already made this offer");
		}
		return od.makeAnOffer(O);
		
	}

	private Offers getOfferById(int id) {
		return od.getOfferById(id);
	}
	
	public boolean  updateOffer(Offers of)  {
		return od.updateOffer(of);
	}
	
	public boolean deleteOffer(Offers of) {
		
		return od.deleteOffer(of);
		}
	
}
