

public interface Subject {

		public void notifyObservers();
		public void registerObserver(Observer o);
		public void removeObserver(Observer o);
}

