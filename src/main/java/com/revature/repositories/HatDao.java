package com.revature.repositories;

import java.util.List;

import com.revature.models.Hat;

public interface HatDao {
	List<Hat> getAllHats();
	List<Hat> getAllAvaliableHats();
	List<Hat> viewOwnedHats();
	Hat getHatById(int id);
	Hat addHat(Hat hat); 
	boolean editHat(Hat eh);   
	int removeHat(int id); 
}