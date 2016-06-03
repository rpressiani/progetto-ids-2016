package dto.changes;

public class DTOChangeFail implements DTOChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -624983021161579630L;

	private final String msg;
	
	public DTOChangeFail(String msg){
		this.msg=msg;
	}

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
