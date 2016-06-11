package view.rmi;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import client.rmi.ClientViewRemote;
import controller.VisitorActions;
import dto.actions.DTOAction;
import model.GameState;
import model.actions.GeneralAction;
import model.changes.Change;
import view.View;

public class RMIView extends View implements RMIViewRemote {

	private Set<ClientViewRemote> clients;
	private VisitorActions visitor;
	private GameState game;
	
	public RMIView() {
		this.clients = new HashSet<>();
		this.visitor=new VisitorActions(game);
	}
	
	@Override
	public void registerClient(ClientViewRemote clientStub) throws RemoteException {
		System.out.println("CLIENT REGISTRATO");
		this.clients.add(clientStub);
	}
	
	@Override
	public void translateAction(DTOAction action) throws RemoteException {
		
	}
	
	@Override
	public void update(Change o) {
		System.out.println("SENDING THE CHANGE TO THE CLIENT");
		try {
			for (ClientViewRemote clientstub : this.clients) {
				
				clientstub.updateClient(o);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
