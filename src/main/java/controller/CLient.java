package controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import dto.DTOObject;
import dto.map.DTORegion;
import dto.utilities.DTOColor;

public class CLient {

	public static void main(String[] args) {
		
		DTOObject obj = new DTORegion("ciao");
		Constructor[] ctors = PerformingAction.class.getDeclaredConstructors();
		Constructor ctor = null;
		
		for (int i = 0; i < ctors.length; i++) {
		    ctor = ctors[i];
		    if (ctor.getGenericParameterTypes()[0].getTypeName().equals(obj.getClass().getTypeName()))
			break;
		}
		
		ctor.setAccessible(true);
		try {
			PerformingAction performingAction = (PerformingAction)ctor.newInstance(obj);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
