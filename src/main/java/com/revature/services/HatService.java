package com.revature.services;

import java.util.List;

import com.revature.exceptions.HatAlreadyExistsException;
import com.revature.exceptions.HatDoesNotExistException;
import com.revature.models.Hat;
import com.revature.repositories.HatDao;
import com.revature.repositories.HatPostgres;



public class HatService {
	
	private HatDao hs = new HatPostgres();

	public Hat addHat(Hat h) throws HatAlreadyExistsException {
		Hat newHat = this.getHatByType(h.getType());
		if(newHat != null) {
			throw new HatAlreadyExistsException();
			
		}
		
		return hs.addHat(h);
	}

	private Hat getHatByType(String type) {
		List<Hat> hats =hs.getAllHats();
		for(Hat i :hats) {
			if(i.getType().equals(type)) {
				return i;
			}
		}
		return null;
	}
	
	public List<Hat> getAllHats() {
		return hs.getAllHats();
	}
	
	public List<Hat> getAllAvaliableHats() {
		return hs.getAllAvaliableHats();
	}
	
	public Hat getHatById(int id) {
		return hs.getHatById(id);
	}
	

	public List<Hat> viewOwnedHats() {
		
				return hs.viewOwnedHats();
		}
		
		
	
	
	public int removeHatById(int id1) throws HatDoesNotExistException {
		int result =-1;
		Hat rmhat =this.getHatById(id1);
		if(rmhat != null ) {
			result = hs.removeHat(id1);
			return result;
			} else {
				throw new HatDoesNotExistException();
				}
		}


			
	}
		
		
	
