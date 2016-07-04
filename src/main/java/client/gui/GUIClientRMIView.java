package client.gui;

import java.rmi.RemoteException;

import client.cli.rmi.ClientRMIView;
import gui.MainApp;

public class GUIClientRMIView extends ClientRMIView {

	public GUIClientRMIView() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4748065998069256670L;
	
	@Override
	public void print(String message) throws RemoteException {
		MainApp.alert("\n" + message);
		
	}

}
