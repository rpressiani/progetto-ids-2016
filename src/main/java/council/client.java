package council;

import parser.Parser;

public class client {

	public static void main(String[] args) {
		Parser parser = new Parser();
		GarbageState garbage = new GarbageState(parser);
		Balcony balcony1 = new Balcony(garbage, parser);
		Balcony balcony2 = new Balcony(garbage, parser);
		Balcony balcony3 = new Balcony(garbage, parser);
		Balcony balcony4 = new Balcony(garbage, parser);
		System.out.println("1"+balcony1.toString());
		System.out.println("2"+balcony2.toString());
		System.out.println("3"+balcony3.toString());
		System.out.println("4"+balcony4.toString());
		System.out.println(garbage);
		
		

	}

}
