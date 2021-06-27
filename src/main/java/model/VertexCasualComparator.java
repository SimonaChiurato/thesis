package model;

import java.util.Comparator;

public class VertexCasualComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex o1, Vertex o2) {
		int o= (int) Math.random()*100;
		return Integer.compare(o1.getId()+o, o2.getId());
	}

}
