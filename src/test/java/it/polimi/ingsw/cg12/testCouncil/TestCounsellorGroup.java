package it.polimi.ingsw.cg12.testCouncil;

import static org.junit.Assert.*;

import org.junit.Test;

import model.council.CounsellorGroup;
import utilities.Color;

public class TestCounsellorGroup {

	@Test
	public void testNullColorInConstructorThrowsException() {
		boolean thrown = false; 
		Color color = null; 
		try {
			CounsellorGroup group = new CounsellorGroup(color, 3); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testIfAddWorks() {
		Color color = new Color("red");
		CounsellorGroup group = new CounsellorGroup(color, 4);
		group.add();
		assertTrue(group.getCounter()==5); 
	}
	@Test
	public void testIfRemoveWorks() {
		Color color = new Color("blue");
		CounsellorGroup group = new CounsellorGroup(color, 4);
		group.remove();
		assertTrue(group.getCounter()==3); 
	}
	@Test
	public void testIfGetColorWorks() {
		Color color = new Color("white");
		CounsellorGroup group = new CounsellorGroup(color, 4);
		Color temp = group.getColor(); 
		assertTrue(temp==group.getColor()); 
	}
	@Test
	public void testIfGetCounterWorks() {
		Color color = new Color("green");
		CounsellorGroup group = new CounsellorGroup(color, 4);
		Integer temp = group.getCounter();
		assertTrue(temp==group.getCounter()); 
	}

}
