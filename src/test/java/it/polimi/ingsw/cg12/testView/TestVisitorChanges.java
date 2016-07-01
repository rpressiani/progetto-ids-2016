package it.polimi.ingsw.cg12.testView;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.changes.ChangeHireAssistants;
import model.changes.ChangeMsg;
import model.changes.ChangePlayerStatus;
import model.changes.ChangeSubstitutePermissionCards;
import view.VisitorChanges;

public class TestVisitorChanges {

	@Test
	public void testNullChangeInVisitThrowsException() {
		boolean thrown = false; 
		ChangePlayerStatus change = null; 
		VisitorChanges visitorChanges = new VisitorChanges();
		try {
			visitorChanges.visit(change); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullChangeMsgInVisitThrowsException() {
		boolean thrown = false; 
		ChangeMsg msg = null; 
		VisitorChanges visitorChanges = new VisitorChanges();
		try {
			visitorChanges.visit(msg); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullChangeHireAssistantsInVisitThrowsException() {
		boolean thrown = false; 
		ChangeHireAssistants change = null; 
		VisitorChanges visitorChanges = new VisitorChanges();
		try {
			visitorChanges.visit(change); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testNullChangeSubstitutePermissionCardsInVisitThrowsException() {
		boolean thrown = false; 
		ChangeSubstitutePermissionCards change = null; 
		VisitorChanges visitorChanges = new VisitorChanges();
		try {
			visitorChanges.visit(change); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}

}
