package dto.queries.respond;

import java.util.ArrayList;

import dto.DTOObject;

public class DTOProposalOrderResponse implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3246756731481591794L;
	
	private final ArrayList<String> proposalOrder;
	
	/**
	 * 
	 * @param proposalOrder
	 * @throws NullPointerException
	 */
	public DTOProposalOrderResponse(ArrayList<String> proposalOrder) {
		if(proposalOrder==null){
			throw new NullPointerException("proposalOrder can't be null");
		}
		this.proposalOrder = proposalOrder;
	}

	/**
	 * @return the proposalOrder
	 */
	public ArrayList<String> getProposalOrder() {
		return proposalOrder;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("[CLI] ");
		for (String color : proposalOrder) {
			str.append("<" + color + "> ");
		}
		str.append("\n");
		
		return str.toString();
	}

}
