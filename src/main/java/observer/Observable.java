package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	/**
	 * @param player
	 * @param o
	 */
	public void registerObserver(Player player, Observer<C> o){
		if(o==null) {
			throw new NullPointerException("Observers cannot be null"); 
		}
		this.observers.add(o);
		this.observersMap.put(player, o);
	}
	
//	/**
//	 * @param o
//	 */
//	public void unregisterObserver(Observer<C> o ){
//		this.observers.remove(o);
//	}
	
	public void unregisterObserver(Player player, Observer<C> o ){
		this.observers.remove(o);
		this.observersMap.remove(player);
		System.out.println(this.observers);
	}
	
	/**
	 * @param c change to be notified to the observers
	 * @throws NullPointerException if change is null
	 */
	public void notifyObserver(C c){
		if(c==null) {
			throw new NullPointerException("Change cannot be null"); 
		}
		System.out.println("size observer: " + this.observers.size());
		for(Observer<C> o: this.observers){
			o.update(c);
			System.out.println("Observer notified");
		}
	}
	
	/**
	 * @param player
	 * @param c
	 * notifies not null observers
	 */
	public void notifyObserver(Player player, C c){
		if(c==null) {
			throw new NullPointerException("Change cannot be null"); 
		}
		if (this.observersMap.get(player) != null) {
				this.observersMap.get(player).update(c);	
		}
	}
	
	/**
	 * @param player
	 * @param c
	 */
	public void notifyAllExceptPlayer(Player player, C c){
		if(c==null) {
			throw new NullPointerException("Change cannot be null"); 
		}
		for(Entry<Player, Observer<C>> entry: this.observersMap.entrySet()){
			if (entry.getKey().equals(player)) {
				continue;
			} else {
				entry.getValue().update(c);
			}
		}
	}
	
	
	/**
	 * @return the observers
	 */
	public List<Observer<C>> getObservers() {
		return observers;
	}

	/**
	 * @return the observersMap
	 */
	public Map<Player, Observer<C>> getObserversMap() {
		return observersMap;
	}
}