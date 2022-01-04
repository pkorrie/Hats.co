package com.revature.services;

import com.revature.exceptions.SubscriberAlreadyExistsException;
import com.revature.models.Subscribe;
import com.revature.repositories.SubscribePostgres;

public class SubscribeService {
	private SubscribePostgres sp = new SubscribePostgres();
	
	public Subscribe addSubscriber( Subscribe s) throws SubscriberAlreadyExistsException {
		Subscribe subs = this.getSubById(s.getSubscriber());
		if(subs != null) {
			throw new SubscriberAlreadyExistsException();
			
		}
		return sp.addSubscribe(s);
		
	}
	
	public Subscribe getSubById(int id) {
		return sp.getsubsById(id);
	}

}
