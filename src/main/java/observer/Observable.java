package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.player.Player;

public abstract class Observable<C> {

	private List<Observer<C>> observers;
	private Map<Player, Observer<C>> observersMap;
	
	public Observable() {
		this.observers = new ArrayList<Observer<C>>();
		this.observersMap = new HashMap<Player, Observer<C>>();
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
	
	public void registerObserver(Player player, Observer<C> o){
		System.out.println("regO 1");
		if(o==null) {
			throw new NullPointerException("Observers cannot be null"); 
		}
		System.out.println("regO 2");
		this.observers.add(o);
		System.out.println("regO 3");
		this.observersMap.put(player, o);
		System.out.println("regO 4");
		
	}
	
	/**
	 * @param o
	 */
	public void unregisterObserver(Observer<C> o ){
		this.observers.remove(o);
	}
	
	public void unregisterObserver(Player player, Observer<C> o ){
		this.observers.remove(o);
		this.observersMap.remove(player, this.observersMap.get(player));
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
	
	public void notifyObserver(Player player, C c){
		if(c==null) {
			throw new NullPointerException("Change cannot be null"); 
		}
		this.observersMap.get(player).update(c);
	}
}