package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ilog.cplex.IloCplex.Status;

public class TestModel {
	 public static void main(String[] args) throws IOException {
	    File folder = new File("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\nuove_istanze");
		listFiles(folder);
	 }
	    static  void listFiles(File folder) throws IOException {
		int num=1;
		
		//System.out.println(String.format("|%-20s|", "NOME ISTANZA"));
		File file = new File("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\result_nuove.txt");
		BufferedWriter in = new BufferedWriter(new FileWriter(file));
		in.write("Risultati istanze con algoritmo VC e CVC\n");
		in.write(String.format("|       %-45s|", "NOME ISTANZA")+" "+String.format("|%-12s|", "TEMPO")+" "+String.format("|%-20s|", "VALORE SOLUZIONE")+" "
				+String.format("|%-12s|", "BEST BOUND")+" "+String.format("|%-12s|", "STATO")+" "+String.format("|%-12s|", "NUMERO NODI")
				+" "+String.format("|%-12s|", "NUMERO ARCHI")+" "+String.format("|%-30s|", "IS VERTEX COVER")+" "+String.format("|%-30s|", "IS CONNECTED VERTEX COVER"));
		in.newLine();
		for ( File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFiles(fileEntry);
			} else {
				Model model = new Model();
				model.leggiGrafo2("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\nuove_istanze\\"+fileEntry.getName());
				model.getGrafoFittizio();
			//	System.out.println(model.solveMeVC());
				model.solveMeVC();
				model.connesse();
				in.write(num+" VC:  "+String.format("|%-45s|", fileEntry.getName())+" "+String.format("|%-12s|", model.getFormattedTime())+" "+String.format("|%-16f|", model.getObjValue())+" "
						+String.format("|%-12f|",model.getBestBound())+" "+String.format("|%-12s|", model.getStatus())+" "+String.format("|%-12d|", model.vertici().size())
						+" "+String.format("|%-12d|", model.archi().size())+" "+String.format("|%-15s|", model.isVertexCover())+" "+String.format("|%-12s|", model.isConnectedVertexCover())+"\n");
				System.out.println(fileEntry.getName());
				model.solveMeCVC();
				if(model.getStatus()!=Status.Infeasible) {
					in.write(num+" CVC: "+String.format("|%-45s|", fileEntry.getName())+" "+String.format("|%-12s|", model.getFormattedTime())+" "+String.format("|%-16f|", model.getObjValue())+" "
							+String.format("|%-12f|",model.getBestBound())+" "+String.format("|%-12s|", model.getStatus())+" "+String.format("|%-12d|", model.vertici().size())
							+" "+String.format("|%-12d|", model.archi().size())+" "+String.format("|%-15s|", model.isVertexCover())+" "+String.format("|%-12s|", model.isConnectedVertexCover())+"\n\n");
					System.out.println("CVC");
				}else {
						System.out.println("infeaseble " +model.vertici());
						System.out.println(model.connesse());
					}
			
				num++;
			}
		}
		in.close();
	}
	 }

