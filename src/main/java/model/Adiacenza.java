package model;



public class Adiacenza {
	private Vertex partenza;
	private Vertex a;
	private double edgeWeight;
	
	public Adiacenza(Vertex partenza, Vertex a, double edgeWeight) {
		super();
		this.partenza = partenza;
		this.a = a;
		this.edgeWeight = edgeWeight;
	}
	public Vertex getPartenza() {
		return partenza;
	}
	public void setPartenza(Vertex partenza) {
		this.partenza = partenza;
	}
	public Vertex getA() {
		return a;
	}
	public void setA(Vertex a) {
		this.a = a;
	}
	public double getEdgeWeight() {
		return edgeWeight;
	}
	public void setEdgeWeight(double edgeWeight) {
		this.edgeWeight = edgeWeight;
	}
	
	@Override
	public String toString() {
		return  partenza + " è vicino a  " + a;
	}
	

}
