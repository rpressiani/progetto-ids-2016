package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<C> {

	private List<Observer<C>> observers;
	
	public Observable() {
		this.observers = new ArrayList<Observer<C>>();
	}
	
	/**
	 * @param o observer to be added to the list of observers
	 * @throws NullPointerException if the observer is null
	 */
	public void registerObserver(Observer<C> o){
		if(o==null) {
			throw new NullPointerException("Observers cannot be null"); 
		}
		this.observers.add(o);
	}
	
	/**
	 * @param o
	 */
	public void unregisterObserver(Observer<C> o ){
		this.observers.remove(o);
	}
	
	/**
	 * @param c change to be notified to the observers
	 * @throws NullPointerException if change is null
	 */
	public void notifyObserver(C c){
		if(c==null) {
			throw new NullPointerException("Change cannot be null"); 
		}
		for(Observer<C> o: this.observers){
			o.update(c);
		}
	}
}