package model;

import java.util.Comparator;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class VertexComparator implements Comparator<Vertex> {

	private SimpleWeightedGraph<Vertex, DefaultWeightedEdge> grafo;

	public VertexComparator(SimpleWeightedGraph<Vertex, DefaultWeightedEdge> grafo) {
	 this.grafo= grafo;
	}

	@Override
	public int compare(Vertex o1, Vertex o2) {
		return -Integer.compare(grafo.degreeOf(o1), grafo.degreeOf(o2));
	}

}
