package model;

import java.io.IOException;
import java.util.List;

public class TestModel {

	public static void main(String[] args) throws IOException {
	Model model= new Model();
	model.leggiGrafo("prova.txt");
	for(Vertex v: model.vertici()) {
		List<Vertex> vicini= model.viciniFittizi(v);
		System.out.println("Partenza "+v.toString()+" ");
		for(Vertex u: vicini) {
			System.out.println(u.getId()+" ");
		}
	}

	}

}
