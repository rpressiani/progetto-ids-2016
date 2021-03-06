package view;

import client.ClientMessage;
import model.changes.Change;
import observer.Observable;
import observer.Observer;

public abstract class View extends Observable<ClientMessage> implements Observer<Change> {
	
	/**
	 * @see observer.Observer#update(java.lang.Object)
	 */
	@Override
	public void update(Change o) {
		Observer.super.update(o);
	}
	
	/**
	 * Starts player's timers
	 */
	public abstract void startTimer();
	
	/**
	 * Stop player's timers
	 */
	public abstract void stopTimer();
	
	/**
	 * Restart player's timers from the beginning
	 */
	public abstract void resetTimer();
	
	public abstract void disconnect();

}