package controller;

import dto.DTOObject;
import dto.actions.main.DTOElectCounsellor;
import dto.map.DTORegion;
import dto.utilities.DTOColor;
import model.GameState;
import model.actions.main.ElectCounsellor;
import model.map.Region;
import model.player.Player;
import utilities.Color;

public class PerformingAction {
	 
	 public PerformingAction(Class<? extends DTOElectCounsellor> cl, DTOObject obj, GameState game){
		 DTOElectCounsellor dto = (DTOElectCounsellor) obj;
		 Region region = game.getMap().getRegions().get(dto.getRegion());
		 Color color = new Color(dto.getColor().getColorString());
		 ElectCounsellor realAction = new ElectCounsellor(region, color);
		 
//		 player.move(realAction, game);
	 }
	 
	 public PerformingAction(DTOColor color){
		 System.out.println("evvai");
	 }
	 
	 public PerformingAction(DTORegion region){
		 System.out.println("region");
	 }

}
