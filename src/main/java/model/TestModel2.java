package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import ilog.cplex.IloCplex.Status;

public class TestModel2 {

	public static void main(String[] args) throws IOException {
		
	
		System.out.println(String.format("|     %-15s|", "NOME ISTANZA") + " " + String.format("|%-12s|", "TEMPO") + " "
				+ String.format("|%-16s|", "VALORE SOLUZIONE") + " " + String.format("|%-12s|", "BEST BOUND") + " "
				+ String.format("|%-12s|", "STATO") + " " + String.format("|%-12s|", "NUMERO NODI") + " "
				+ String.format("|%-12s|", "NUMERO ARCHI") + " " + String.format("|%-15s|", "IS VERTEX COVER") + " "
				+ String.format("|%-30s|", "IS CONNECTED VERTEX COVER"));
		
			Model model = new Model(10, 5);

			String nome = "email-univ.edges      ";
			model.leggiGrafo2("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\nuove_istanze\\" + nome);

			// model.leggiGrafo2("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\nuove_istanze\\bcspwr06.mtx");

			model.getGrafoFittizio();
//System.out.println(model.vertexCasualOrder());
		/*	String result= model.solveMeVC();
			 
			 System.out.println("VC:  "+String.format("|%-20s|",nome
			 )+" "+String.format("|%-12s|",
			  model.getFormattedTime())+" "+String.format("|%-16f|",
			  model.getObjValue())+" "
			  +String.format("|%-12f|",model.getBestBound())+" "+String.format("|%-12s|",
			  model.getStatus())+" "+String.format("|%-12d|", model.vertici().size())
			  +" "+String.format("|%-12d|",
			  model.archi().size())+" "+String.format("|%-15s|",
			  model.isVertexCover())+" "+String.format("|%-12s|",
			  model.isConnectedVertexCover()));*/
			//System.out.println(result);
		String	result= model.solveMeCVC2();

			if (model.getStatus() != Status.Infeasible) {
				System.out.println("CVC: " + String.format("|%-20s|", nome) + " "
						+ String.format("|%-12s|", model.getFormattedTime()) + " "
						+ String.format("|%-16f|", model.getObjValue()) + " "
						+ String.format("|%-12f|", model.getBestBound()) + " "
						+ String.format("|%-12s|", model.getStatus()) + " "
						+ String.format("|%-12d|", model.vertici().size()) + " "
						+ String.format("|%-12d|", model.archi().size()) + " "
						+ String.format("|%-15s|", model.isVertexCover()) + " "
						+ String.format("|%-12s|", model.isConnectedVertexCover()) + "\n\n");
				//System.out.println(result);
			} else {
				System.out.println(model.vertici());
				System.out.println(model.connesse());
			}

		}

	
}
