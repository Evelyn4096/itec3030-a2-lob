package ca.yorku.cmg.lob.stockexchange.events;

import java.util.ArrayList;
import java.util.List;

import ca.yorku.cmg.lob.stockexchange.tradingagent.INewsObserver;

public abstract class AbstractNewsSubject {

    protected List<INewsObserver> observers = new ArrayList<>();

    public void registerObserver(INewsObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(INewsObserver obs) {
        observers.remove(obs);
    }

    protected void notifyObservers(Event e) {
        for (INewsObserver obs : observers) {
            obs.update(e);
        }
    }
}
