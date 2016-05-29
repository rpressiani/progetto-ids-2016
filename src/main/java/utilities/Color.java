package utilities;

public class Color {
	private int r, g, b;
	private String stringID;
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 * @throws IllegalArgumentException if r, g, or b are <0
	 */
	public Color(int r, int g, int b) {
		if(r<0 || g<0 || b<0) {
			throw new IllegalArgumentException("r, g and b must all be >=0"); 
		}
		this.r = r; 
		this.g= g; 
		this.b = b;
		this.stringID = new String("RGB definition");
	}
	
	/**
	 * @param stringID
	 * @throws NullPointerException if stringID is null
	 */
	public Color(String stringID) {
		if(stringID==null) {
			throw new NullPointerException("stringID cannot be null"); 
		}
		this.stringID = stringID;
		this.r = -1;
		this.g = -1;
		this.b = -1;
	}
	
	public boolean isColorOk() {
		if((r<0 || r>255) || (g<0 || g>255) || (b<0 || b>255)) {
			return false; 
		}
		return true; 
	}
	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Color [r=" + r + ", g=" + g + ", b=" + b + ", stringID=" + stringID + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		result = prime * result + g;
		result = prime * result + r;
		result = prime * result + ((stringID == null) ? 0 : stringID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (b != other.b)
			return false;
		if (g != other.g)
			return false;
		if (r != other.r)
			return false;
		if (stringID == null) {
			if (other.stringID != null)
				return false;
		} else if (!stringID.equals(other.stringID))
			return false;
		return true;
	}

	/**
	 * @return the stringID
	 */
	public String getStringID() {
		return stringID;
	}
	
}



