package gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GUIMap extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7470478336620539069L;
	
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 900;
	private final int LAYER_BACKGROUND = 1;
	
	private Image backgroundImage;
	private JLabel backgroundLabel;
	private JLayeredPane layeredPane;
	
	private List<Emporium> emporiums; 
	private List<GUICouncil> councils; 
	
	private EmporiumController emporiumController; 
	
	public GUIMap() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT + getInsets().top);
		setTitle("Council of Four"); 
		setResizable(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emporiums = new ArrayList<Emporium>(); 
		councils = new ArrayList<GUICouncil>(); 
		loadResources(); 
		initComponents(); 
	}
	
	private void loadResources() {
		try {
			//still have to change
			backgroundImage = ImageIO.read(new File("./res/piazza_duomo.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void initComponents() {
		layeredPane = new JLayeredPane();
		setContentPane(layeredPane);
		backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
		backgroundLabel.setBounds(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
		add(backgroundLabel);
		layeredPane.setLayer(backgroundLabel, LAYER_BACKGROUND);
		//still have to locate all the components
	}
	public void fillCouncils() {
		
	}
	public void setBonusInCities() {
		
	}

}
