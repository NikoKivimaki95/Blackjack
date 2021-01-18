package quickstart;

import java.util.Comparator;

public class CompObj implements Comparator<Card>{

	public int compare(Card o1, Card o2) {
		if(o1.getValue() == o2.getValue()) {
			return 0;
		}
		if(o1.getValue() < o2.getValue()) {
			return -1;
		}
		else {
			return 1;
		}
	}

}
