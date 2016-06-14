package server;

import java.rmi.Remote;

import view.rmi.RMIView;

public class RMIServer implements Remote {
	
	public RMIView connect(){
		return new RMIView();
	}
}
