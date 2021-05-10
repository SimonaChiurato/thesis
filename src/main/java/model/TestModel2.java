package model;

import java.io.IOException;
import java.util.Set;

import ilog.cplex.IloCplex.Status;

public class TestModel2 {

	public static void main(String[] args) throws IOException {
		Model model = new Model();
		String nome="yeast1.txt";
		
		model.leggiGrafo1("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\istanze\\vecchie\\"+nome);
	
		//model.leggiGrafo2("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\nuove_istanze\\bcspwr06.mtx");
	    int num=0;
		model.getGrafoFittizio();
		for(Set<Vertex> s: model.connesse()) {
		
			System.out.println("num "+num+ " size "+s.size());
			num++;
			for( Vertex v: s) {
				System.out.println("v "+v.getId());
			}
		}
		System.out.println("CONNESSI CON 10 " +model.connessi( model.vertici().get(10)));
				
				
						
					
		System.out.println(String.format("|     %-15s|", "NOME ISTANZA")+" "+String.format("|%-12s|", "TEMPO")+" "+String.format("|%-16s|", "VALORE SOLUZIONE")+" "
				+String.format("|%-12s|", "BEST BOUND")+" "+String.format("|%-12s|", "STATO")+" "+String.format("|%-12s|", "NUMERO NODI")
				+" "+String.format("|%-12s|", "NUMERO ARCHI")+" "+String.format("|%-15s|", "IS VERTEX COVER")+" "+String.format("|%-30s|", "IS CONNECTED VERTEX COVER"));
		model.solveMeVC();
		
		System.out.println("VC:  "+String.format("|%-20s|",nome )+" "+String.format("|%-12s|", model.getFormattedTime())+" "+String.format("|%-16f|", model.getObjValue())+" "
				+String.format("|%-12f|",model.getBestBound())+" "+String.format("|%-12s|", model.getStatus())+" "+String.format("|%-12d|", model.vertici().size())
	+" "+String.format("|%-12d|", model.archi().size())+" "+String.format("|%-15s|", model.isVertexCover())+" "+String.format("|%-12s|", model.isConnectedVertexCover()));
	
		model.solveMeCVC();
		
		if(model.getStatus()!=Status.Infeasible) {
		System.out.println("CVC: "+String.format("|%-20s|",nome)+" "+String.format("|%-12s|", model.getFormattedTime())+" "+String.format("|%-16f|", model.getObjValue())+" "
				+String.format("|%-12f|",model.getBestBound())+" "+String.format("|%-12s|", model.getStatus())+" "+String.format("|%-12d|", model.vertici().size())
				+" "+String.format("|%-12d|", model.archi().size())+" "+String.format("|%-15s|", model.isVertexCover())+" "+String.format("|%-12s|", model.isConnectedVertexCover())+"\n\n");
		}else {
			System.out.println(model.vertici());
			System.out.println(model.connesse());
		}
		
		
	}

}
