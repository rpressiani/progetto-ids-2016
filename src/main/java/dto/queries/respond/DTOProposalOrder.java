package dto.queries.respond;

import java.util.ArrayList;

import dto.DTOObject;

public class DTOProposalOrder implements DTOObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3246756731481591794L;
	
	private final ArrayList<String> proposalOrder;
	
	public DTOProposalOrder(ArrayList<String> proposalOrder) {
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
