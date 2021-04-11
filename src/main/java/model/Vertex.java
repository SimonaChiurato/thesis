package model;

public class Vertex implements Comparable<Vertex>{
	
	private int id;
	private int c;
	private boolean x;
	
	public Vertex(int id, int c, boolean x) {
		super();
		this.id = id;
		this.c = c;
		this.x = x;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public boolean isX() {
		return x;
	}

	public void setX(boolean x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "id=" + id ;
	}

	@Override
	public int compareTo(Vertex o) {
		return Integer.compare(this.getId(), o.getId());
		
	}

	

	
	
	
	

}
