package com.bilgeadam.egitim.enumx;

import com.bilgeadam.controller.PencilController;

public class PencilMain {
	
	public static void main(String[] args) {
		PencilEntity entity = new PencilEntity();
		entity.setPencilName("Adel 44");
		entity.setPencilTrade("Adel");
		entity.setPencilType(EPencil.TukenmezKalem);
		
		PencilController pencilController = new PencilController();
		pencilController.create(entity);
		
	}
	
}
