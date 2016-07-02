package it.polimi.ingsw.cg12.testDTO.queries.respond;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dto.queries.respond.DTOProposalOrderResponse;

public class TestDTOProposalOrderResponse {

	@Test
	public void testNullProposalOrderInConstructorThrowsException() {
		boolean thrown = false; 
		ArrayList<String> proposalOrder = null;
		try {
			@SuppressWarnings("unused")
			DTOProposalOrderResponse response = 
					new DTOProposalOrderResponse(proposalOrder); 
		} catch(NullPointerException e) {
			thrown = true; 
		}
		assertTrue(thrown); 
	}
	@Test
	public void testGetProposalOrder() {
		ArrayList<String> proposalOrder = new ArrayList<String>();
		DTOProposalOrderResponse response = 
				new DTOProposalOrderResponse(proposalOrder);
		assertEquals(proposalOrder, response.getProposalOrder()); 
	}

}
