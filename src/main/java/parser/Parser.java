/**
 * 
 */
package parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jaxb.CFGRoot;

/**
 * @author Riccardo Pressiani
 *
 */
public class Parser {
	
	private File file;
	private JAXBContext jaxbContext;
	private Unmarshaller jabxUnmarshaller;
	private CFGRoot cfgRoot; 
	
	public Parser(File file){
		try {
			this.file = new File("src/main/resources/co4_config.xsd");
			this.jaxbContext = JAXBContext.newInstance(CFGRoot.class);
			this.jabxUnmarshaller = jaxbContext.createUnmarshaller();
			this.cfgRoot = (CFGRoot) this.jabxUnmarshaller.unmarshal(file);
		}
		catch (JAXBException e){
			e.printStackTrace();
		}
		
	}

}
