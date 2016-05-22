package view;

import client.ClientMessage;
import controller.Change;
import observer.Observable;
import observer.Observer;

public abstract class View extends Observable<ClientMessage> implements Observer<Change> {
	
	@Override
	public void update(Change o) {
		Observer.super.update(o);
		//State to be implemented
		
	}

	public void input(String input) {
		
	}
	
}
