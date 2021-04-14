package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestModel {
	 public static void main(String[] args) throws IOException {
	    File folder = new File("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\istanze\\aa");
		listFiles(folder);
	 }
	    static  void listFiles(File folder) throws IOException {
		int num=1;
		
		//System.out.println(String.format("|%-20s|", "NOME ISTANZA"));
		File file = new File("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\result2.txt");
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
				model.leggiGrafo("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\istanze\\aa\\"+fileEntry.getName());
				model.getGrafoFittizio();
			//	System.out.println(model.solveMeVC());
				model.solveMeVC();
				in.write(num+" VC:  "+String.format("|%-45s|", fileEntry.getName())+" "+String.format("|%-12s|", model.getFormattedTime())+" "+String.format("|%-12f|", model.getObjValue())+" "
						+String.format("|%-12f|",model.getBestBound())+" "+String.format("|%-12s|", model.getStatus())+" "+String.format("|%-12d|", model.vertici().size())
						+" "+String.format("|%-12d|", model.archi().size())+" "+String.format("|%-12s|", model.isVertexCover())+" "+String.format("|%-12s|", model.isConnectedVertexCover())+"\n");
				model.solveMeCVC();
				in.write(num+" CVC: "+String.format("|%-45s|", fileEntry.getName())+" "+String.format("|%-12s|", model.getFormattedTime())+" "+String.format("|%-12f|", model.getObjValue())+" "
						+String.format("|%-12f|",model.getBestBound())+" "+String.format("|%-12s|", model.getStatus())+" "+String.format("|%-12d|", model.vertici().size())
						+" "+String.format("|%-12d|", model.archi().size())+" "+String.format("|%-12s|", model.isVertexCover())+" "+String.format("|%-12s|", model.isConnectedVertexCover())+"\n\n");
			
				num++;
			}
		}
		in.close();
	}
	 }

