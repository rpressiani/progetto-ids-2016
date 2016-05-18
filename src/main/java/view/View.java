package view;

import actions.GeneralAction;
import observer.Change;
import observer.Observable;
import observer.Observer;

public abstract class View extends Observable<GeneralAction> implements Observer<Change> {
	
	@Override
	public void update(Change o) {
		Observer.super.update(o);
		//State to be implemented
		
	}

	public void input(String input) {
		
	}
	
}
