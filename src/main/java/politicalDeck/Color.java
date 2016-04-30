package politicalDeck;

public class Color {
	private int r; 
	private int g; 
	private int b; 
	
	public Color(int r, int g, int b) {
		this.r = r; 
		this.g = g; 
		this.b = b; 
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
	public String getColorAsString(Color color) {
		
	}
	

}
