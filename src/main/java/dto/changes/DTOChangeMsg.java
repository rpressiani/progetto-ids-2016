package dto.changes;

public class DTOChangeMsg implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -624983021161579630L;

	private final String msg;
	
	/**
	 * @param msg
	 * @throws NullPointerException if msg is null
	 */
	public DTOChangeMsg(String msg) {
		if(msg==null) {
			throw new NullPointerException("msg cannot be null"); 
		}
		this.msg=msg;
	}

	/**
	 * 
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return msg;
	}
	
}
