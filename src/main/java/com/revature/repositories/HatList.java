//package com.revature.repositories;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.revature.models.Hat;
//
//public class HatList implements HatDao{
//	private List<Hat> hats;
//	
//	
//
//	public HatList() {
//		hats = new ArrayList<>();
//		Hat Bucket = new Hat(0,"Bucket", 10, "Black", "M", null);
//		hats.add(Bucket);
//	}
//
//	@Override
//	public List<Hat> getAllHats() {
//		return hats;
//	}
//
//	@Override
//	public Hat getHatById(int id) {
//		for (Hat h : hats) {
//			if (h.getId() == id) {
//				return h;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public Hat addHat(Hat hat) {
//		hat.setId(hats.size());
//		hats.add(hat);
//		for(Hat i : hats) {
//			if(i.getId() == hat.getId()) {
//				return hat;
//			}
//		}
//		return null;
//			
//		
//	}
//
//	@Override
//	public boolean editHat(Hat eh) {
//		for(Hat i : hats) {
//			if(i.equals(eh)|| getHatById(eh.getId()) == null) {
//				return false;
//			}
//			hats.set(i.getId(), eh);//check if it works
//		}
//		
//		return true;
//	}
//
//	
//	public Hat removeHat(Hat rmHat){
//		for(Hat i : hats) {
//			if(i.getType().equals(rmHat.getType())) {
//				hats.remove(i);
//			}
//		}
//		return rmHat;
//	}
//
//
//	@Override
//	public List<Hat> getAllAvaliableHats() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int removeHat(int id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	
//
//}
