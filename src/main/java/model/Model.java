package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.event.ConnectedComponentTraversalEvent;
import org.jgrapht.event.EdgeTraversalEvent;
import org.jgrapht.event.TraversalListener;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import ilog.concert.IloException;
import ilog.concert.IloLPMatrix;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloRange;
import ilog.cplex.IloCplex;
import ilog.cplex.IloCplex.Status;

public class Model {

	private SimpleWeightedGraph<Vertex, DefaultWeightedEdge> grafo;
	private int numVertex;
	private List<Vertex> vertici = new ArrayList<Vertex>();
	private Vertex verticeT;
	private Map<Vertex, Vertex> visita;
	private String formattedTime;
	private double objValue;
	private Status status;
	private double bestBound;
	private int numArchi;


	public Model() {
		this.numVertex = 0;
		this.grafo = null;
		this.verticeT = null;
		visita = new HashMap<>();
		this.formattedTime=null;
		this.objValue=0.0;
		this.status=null;
		this.bestBound=0.0;
		this.numArchi=0;
	}
	

	public Vertex getVerticeT() {
		return verticeT;
	}

	public Map<Vertex, Vertex> getVisita() {
		return visita;
	}

	public String getFormattedTime() {
		return formattedTime;
	}

	public double getObjValue() {
		return objValue;
	}

	public Status getStatus() {
		return status;
	}

	public double getBestBound() {
		return bestBound;
	}
	public int getNumArchi() {
		return this.numArchi;
	}

	public SimpleWeightedGraph<Vertex, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}
	public int getNumVertex() {
		return numVertex;
	}

	/*
	 * Formato file: numero vertici 0: 1 1: 0 2 --> vicini 2: grafo parte da vertice
	 * zero, vertice fittizio ultimo vertice
	 */
	public void leggiGrafo1(String nomeFile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		String linea;
		this.grafo = new SimpleWeightedGraph<Vertex, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Integer nRow = 0;
		vertici = new ArrayList<Vertex>();
		while ((linea = in.readLine()) != null) {
			try {
				linea=linea.trim();
				if (nRow == 0 && linea.matches("[0-9]+")) {
					this.numVertex = Integer.parseInt(linea);
					//System.out.println(this.numVertex);

				} else if (nRow != 0) {
				
					StringTokenizer st1 = new StringTokenizer(linea, ":");
					String sVertex = st1.nextToken().trim();
				
					Vertex v = null;
					for (Vertex p : vertici) {
						if (p.getId() == Integer.parseInt(sVertex)) {
							v = p;
						}
					}
					
					if (v == null) {
						v = new Vertex(Integer.parseInt(sVertex), 1, false);
						vertici.add(v);
					}
					
					if(st1.hasMoreTokens()) {
					String vicini = st1.nextToken();
					StringTokenizer st2 = new StringTokenizer(vicini, " ");

					while (st2.hasMoreTokens()) {
						String sVicino = st2.nextToken();
						Vertex v2 = null;
						for (Vertex p : vertici) {
							if (p.getId() == Integer.parseInt(sVicino)) {
								v2 = p;
							}
						}
						if (v2 == null) {
							v2 = new Vertex(Integer.parseInt(sVicino), 1, false);
							vertici.add(v2);
						}

						if (!this.grafo.containsVertex(v) && !this.grafo.containsVertex(v2)) {
							Graphs.addEdgeWithVertices(grafo, v, v2, 1);
						} else if (this.grafo.containsVertex(v) && !this.grafo.containsVertex(v2)) {
							grafo.addVertex(v2);
							Graphs.addEdge(grafo, v, v2, 1);
						} else if (this.grafo.containsVertex(v) && this.grafo.containsVertex(v2)
								&& this.grafo.getEdge(v, v2) == null) {

							Graphs.addEdge(this.grafo, v, v2, 1);

						}
					}
					}else {
						grafo.addVertex(v);
					}
				}

				nRow++;
			} catch (Exception e) {
				// System.err.println("Errore");
				e.printStackTrace();

			}

		}
		/*if(grafo.vertexSet().size()==this.numVertex) {
			System.out.println("ok");
		}else {
			System.out.println("shit"+grafo.vertexSet().size());
		}
		System.out.println(this.vertici());*/
		in.close();
	}
	
	public void leggiGrafo2(String nomeFile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		String linea;
		this.grafo = new SimpleWeightedGraph<Vertex, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		//Integer nRow = 0;
		vertici = new ArrayList<Vertex>();
		while ((linea = in.readLine()) != null) {
			try {
				linea=linea.trim();
			
		/*	if (nRow == 0 && linea.matches("p [a-z]+ [0-9]+ [0-9]+")) {
					String[] valori= linea.split(" ");
					this.numVertex = Integer.parseInt(valori[2]);
					this.numArchi= Integer.parseInt(valori[3]);
					
					System.out.println(this.numVertex);
					//System.out.println(this.numArchi);
					nRow++;

				} else if (nRow != 0) {*/
				
				
				if(!linea.contains("%")) {
					String[] valori= linea.split(" ");
				//System.out.println(valori[0]+" "+valori[1]);
					int idV1 =  Integer.parseInt(valori[0])-1;
					int idV2 =  Integer.parseInt(valori[1])-1;
					if(idV1!=idV2) {
						
					
					Vertex v = null;
					Vertex v2= null;
					for (Vertex p : vertici) {
						if (p.getId() == idV1) {
							v = p;
						}else if(p.getId()==idV2) {
							v2=p;
						}
					}
					
					if (v == null && v2== null) {
						v= new Vertex(idV1, 1, false);
						v2= new Vertex(idV2, 1, false);
						Graphs.addEdgeWithVertices(grafo, v, v2, 1);
						
					}else if( v != null && v2== null) {
						v2= new Vertex(idV2, 1, false);
						grafo.addVertex(v2);
						Graphs.addEdge(grafo, v, v2, 1);
					}else if( v == null && v2!= null) {
						v= new Vertex(idV1, 1, false);
						grafo.addVertex(v);
						Graphs.addEdge(grafo, v2, v, 1);
					}else if( v != null && v2 != null && this.grafo.getEdge(v, v2) == null) {
						
						Graphs.addEdge(grafo, v, v2, 1);
					}
					
					if(!this.vertici.contains(v)) {
					vertici.add(v);
					}
					if(!this.vertici.contains(v2)) {
						vertici.add(v2);
						} 
					
					}else {
					//	System.out.println(idV1+" "+idV2);
					}
				//}

//				nRow++;
				}
				
			} catch (Exception e) {
				// System.err.println("Errore");
				e.printStackTrace();

			}
			
		}

			
	System.out.println(this.grafo.edgeSet());
Collections.sort(this.vertici);
			System.out.println();
			System.out.println(this.vertici);
			int zero=0;
	try {
		for(Vertex v: this.vertici) {
			
			if(v.getId()!=zero) {
				System.out.println(v.getId()+" "+zero);
			}
			zero++;
		}
		
	}catch(IndexOutOfBoundsException e){
		System.out.println(e+" "+zero);
	}
	
		in.close();
	}



	public SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> getGrafoFittizio() {
		SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> grafoFittizio = new SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge>(
				DefaultWeightedEdge.class);
		Vertex f = new Vertex(this.getGrafo().vertexSet().size(), 1, false);
		grafoFittizio.addVertex(f);
		for (Vertex v : this.vertici()) {
			grafoFittizio.addVertex(v);
			Graphs.addEdge(grafoFittizio, f, v, 1);
		}

		for (DefaultWeightedEdge e : this.archi()) {
			Graphs.addEdge(grafoFittizio, this.getGrafo().getEdgeSource(e), this.getGrafo().getEdgeTarget(e), 1);
			Graphs.addEdge(grafoFittizio, this.getGrafo().getEdgeTarget(e), this.getGrafo().getEdgeSource(e), 1);
			// System.out.println( this.getGrafo().getEdgeSource(e)+" "+
			// this.getGrafo().getEdgeTarget(e));
		}

		
/*		 for (DefaultWeightedEdge e : grafoFittizio.edgeSet()) { System.out.println(
		 grafoFittizio.getEdgeSource(e)+" "+ grafoFittizio.getEdgeTarget(e)); }
		 */

		return grafoFittizio;

	}



	public List<Vertex> vertici() {
		List<Vertex> result = new ArrayList<Vertex>();
		result.addAll(this.grafo.vertexSet());
		Collections.sort(result);
	//	System.out.println(result);
		return result;
	}

	public Set<DefaultWeightedEdge> archi() {
		return this.grafo.edgeSet();
	}

	public List<Vertex> viciniFittizi(Vertex partenza) {
		List<Vertex> result = new ArrayList<Vertex>();
		// System.out.println("Vicini fittizi di "+ partenza.getId()+": ");
		for (Vertex v : Graphs.neighborListOf(this.getGrafoFittizio(), partenza)) {
			if (!result.contains(v)) {
				result.add(v);
				// System.out.println(v.getId()+" ");
			}
		}
		return result;
	}

	public List<Adiacenza> connessi(Vertex partenza) {
		List<Adiacenza> adiacenze = new ArrayList<>();

		List<Vertex> vicini = Graphs.neighborListOf(grafo, partenza);
		for (Vertex a : vicini) {
			adiacenze.add(new Adiacenza(partenza, a, grafo.getEdgeWeight(grafo.getEdge(partenza, a))));
		}
		return adiacenze;
	}

	public String solveMeVC() {
		this.formattedTime=null;
		this.objValue=0.0;
		this.status=null;
		this.bestBound=0.0;
		String result = "";
		if (this.grafo != null) {
			try {
				IloCplex cplex = new IloCplex();

				IloNumVar[] x = cplex.boolVarArray(this.vertici().size()); // appartiene a 1 o 0

				IloLinearNumExpr obj = cplex.linearNumExpr();
				for (Vertex v : this.grafo.vertexSet()) {
					//x[v.getId()] = cplex.boolVar();
					obj.addTerm(v.getC(), x[v.getId()]);
				}

				// creata funzione obiettivo
				cplex.addMinimize(obj); // minimizza la funzione obiettivo

				// vincolo xv+xu >=1
				for (DefaultWeightedEdge e : this.grafo.edgeSet()) {
					cplex.addGe(cplex.sum(x[grafo.getEdgeSource(e).getId()], x[grafo.getEdgeTarget(e).getId()]), 1);
				}
				Integer timeRunning = 300;
				cplex.setParam(IloCplex.DoubleParam.TimeLimit, timeRunning);
				cplex.setParam(IloCplex.IntParam.Simplex.Display, 0);
				cplex.setOut(null);

				long start = System.currentTimeMillis();

				if (cplex.solve()) {
					long end = System.currentTimeMillis();
					Double time = (end - start) / Double.valueOf(1000);
					this.formattedTime = String.format("%.3f", time);
					this.objValue= cplex.getObjValue();
					this.status= cplex.getStatus();
					this.bestBound= cplex.getBestObjValue();

					result += "obj = " + this.objValue + " time = " + formattedTime + " s status = "
							+this.status + " \n";
					// result+="0.0 the vertex isn't in the solution \n 1.0 the vertex is in the
					// solution";
					for (Vertex v : this.vertici()) {
						result += "Vertex " + v.getId() + "-->" + cplex.getValue(x[v.getId()]) + "\n";

						if (cplex.getValue(x[v.getId()]) == 0.0) {
							v.setX(false);
						} else {
							v.setX(true);
						}
					}

				} else {
					result = "Model not solved";
				}
				// cplex.exportModel("model.lp");
				cplex.clearModel();
	        	cplex.endModel();
				cplex.end();
				cplex.close();
				return result;

			} catch (IloException exc) {

				exc.printStackTrace();
			}
		}
		return null;
	}

	public String solveMeCVC() {
		this.formattedTime=null;
		this.objValue=0.0;
		this.status=null;
		this.bestBound=0.0;
		String result = "";
		int n = this.vertici().size(); // cardinalità V
		int l = this.getGrafoFittizio().edgeSet().size();
		if (this.grafo != null) {
			
			try {
				IloCplex cplex = new IloCplex();

				IloNumVar[] x	=cplex.boolVarArray(n);
				
				IloNumVar[][] y = new IloNumVar[n][n];
				IloNumVar[][] f = new IloNumVar[l][l];
				IloNumVar[] t = cplex.boolVarArray(n);

				IloLinearNumExpr obj = cplex.linearNumExpr();
				for (Vertex v : this.vertici()) {
				
				//x[v.getId()] = cplex.boolVar();
					//t[v.getId()] = cplex.boolVar("t"); // appartiene a 1 o 0
					obj.addTerm(v.getC(), x[v.getId()]);
				}

				for (DefaultWeightedEdge e : this.archi()) {
				
					y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()] = cplex.boolVar("y");
				}
				for (DefaultWeightedEdge e : this.getGrafoFittizio().edgeSet()) {
					//System.out.println("f "+grafo.getEdgeSource(e).getId()+" "+grafo.getEdgeTarget(e).getId());
					f[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()] = cplex.numVar(0,
							Double.MAX_VALUE, "f");
					// if (grafo.getEdgeSource(e).getId() == this.vertici.size()) {

					// } else {
					// f[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()] =
					// cplex.numVar(0,
					// Double.MAX_VALUE, "f");
					// f[grafo.getEdgeTarget(e).getId()][grafo.getEdgeSource(e).getId()] =
					// cplex.numVar(0,
					// Double.MAX_VALUE, "f");
				}

				// creata funzione obiettivo
				cplex.addMinimize(obj); // minimizza la funzione obiettivo

				IloLinearNumExpr num_exp = cplex.linearNumExpr();
				for (DefaultWeightedEdge e : this.archi()) {
					cplex.addGe(cplex.sum(x[grafo.getEdgeSource(e).getId()], x[grafo.getEdgeTarget(e).getId()]), 1,
							"vincolo xi+xj >=1");//

					num_exp = cplex.linearNumExpr();
					num_exp.addTerm(1, y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]);
					num_exp.addTerm(-1, x[grafo.getEdgeSource(e).getId()]);
					num_exp.addTerm(-1, x[grafo.getEdgeTarget(e).getId()]);
					cplex.addGe(num_exp, -1, " vincolo yij-xi-xj>=-1"); //

					num_exp = cplex.linearNumExpr();
					num_exp.addTerm(1, y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]);
					num_exp.addTerm(-1, x[grafo.getEdgeSource(e).getId()]);
					cplex.addLe(num_exp, 0, " vincolo yij-xi<=0"); //

					num_exp = cplex.linearNumExpr();
					num_exp.addTerm(1, y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]);
					num_exp.addTerm(-1, x[grafo.getEdgeTarget(e).getId()]);
					cplex.addLe(num_exp, 0, " vincolo yij-xj<=0");

					num_exp = cplex.linearNumExpr();
					num_exp.addTerm(1, f[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]);
					num_exp.addTerm(-n, y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]);
					cplex.addLe(num_exp, 0, "vincolo fij-n*yij<=0"); //

					num_exp = cplex.linearNumExpr();
					num_exp.addTerm(1, f[grafo.getEdgeTarget(e).getId()][grafo.getEdgeSource(e).getId()]);
					num_exp.addTerm(-n, y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]);
					cplex.addLe(num_exp, 0, "vincolo fji-n*yij<=0");

				}
				IloLinearNumExpr sumT = cplex.linearNumExpr();
				IloLinearNumExpr sumF0i = cplex.linearNumExpr();
				IloLinearNumExpr sumXi = cplex.linearNumExpr();

				IloLinearNumExpr sumFij = cplex.linearNumExpr();

				for (Vertex v : this.vertici()) {
					num_exp = cplex.linearNumExpr();
					num_exp.addTerm(1, t[v.getId()]);
					num_exp.addTerm(-1, x[v.getId()]);
					cplex.addLe(num_exp, 0, " vincolo ti-xi<=0");

					
					
					

					sumF0i.addTerm(1, f[this.vertici().size()][v.getId()]);
					sumXi.addTerm(-1, x[v.getId()]);
					sumT.addTerm(1, t[v.getId()]);

					for (Vertex u : this.vertici()) {
						if (v.getId() < u.getId()) {
							num_exp = cplex.linearNumExpr();
							num_exp.addTerm(1, t[v.getId()]);
							num_exp.addTerm(-1, t[u.getId()]);
							num_exp.addTerm(-1, x[v.getId()]);
							cplex.addGe(num_exp, -1, "vincolo ti-tj-xi>=-1"); //
						}
					}

					sumFij = cplex.linearNumExpr();
					for (Vertex u : this.viciniFittizi(v)) {
					//	System.out.println(u.getId());
						if (u.getId() != this.vertici().size()) {
						//	 System.out.println(v.getId()+" "+u.getId()+" doppio "+ Integer.compare(u.getId(), this.vertici.size())+"   "+this.vertici.size());
							sumFij.addTerm(1, f[v.getId()][u.getId()]);
							sumFij.addTerm(-1, f[u.getId()][v.getId()]);
						} else {
							sumFij.addTerm(-1, f[u.getId()][v.getId()]);
							//System.out.println(v.getId()+" "+u.getId()+" singolo");
						}
						
					//System.out.println(v.getId());
						num_exp = cplex.linearNumExpr();
						num_exp.addTerm(1, f[this.vertici().size()][v.getId()]);
						num_exp.addTerm(-n, t[v.getId()]);
						cplex.addLe(num_exp, 0, " vincolo f0i-n*ti<=0");

					}
					// System.out.println(cplex.sum(sumFij,x[v.getId()]));

					cplex.addEq(cplex.sum(sumFij, x[v.getId()]), 0, "sum Fij- sum Fji=-xi");
				}
				cplex.addEq(sumT, 1, "vincolo sommatoria ti=1");
				cplex.addEq(cplex.sum(sumF0i, sumXi), 0, "sommatoria foi- somm xi=0");
				System.out.println("pre conto");
				Integer timeRunning = 300;
				cplex.setParam(IloCplex.DoubleParam.TimeLimit, timeRunning);
				cplex.setParam(IloCplex.IntParam.Simplex.Display, 0);
				cplex.setOut(null);
				long start = System.currentTimeMillis();

				if (cplex.solve()) {
					long end = System.currentTimeMillis();
					Double time = (end - start) / Double.valueOf(1000);
					this.formattedTime = String.format("%.3f", time);
					this.objValue= cplex.getObjValue();
					this.status= cplex.getStatus();
					//System.out.println(cplex.getStatus());
					this.bestBound= cplex.getBestObjValue();

					result += "obj = " + this.objValue + " time = " + formattedTime + " s status = "
							+this.status + " \n";
					// result+="0.0 the vertex isn't in the solution \n 1.0 the vertex is in the
					// solution";
				
					for (Vertex v : this.vertici()) {
						result += "\nVertex " + v.getId() + "--> "
								+ String.format("%1.1f", Math.abs(cplex.getValue(x[v.getId()])));
						if (cplex.getValue(t[v.getId()]) != 0.0) {
							result += "  t value--> " + cplex.getValue(t[v.getId()]) + " ";
							result += "f Vertex: (" + this.vertici.size() + " " + v.getId() + ")--> "
									+ cplex.getValue(f[this.vertici.size()][v.getId()]);
							this.verticeT = v;
						}
						if (cplex.getValue(x[v.getId()]) == 0.0) {
							v.setX(false);
						} else {
							v.setX(true);
						}
					}

					// Y è GESTITA CORRETTAMENTE

					for (DefaultWeightedEdge e : this.archi()) {
					
						if (cplex.getValue(y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]) != 0.0) {
							result += "\nY value: Vertex (" + grafo.getEdgeSource(e).getId() + " "
									+ grafo.getEdgeTarget(e).getId() + ")-->" + String.format("%1.1f", cplex.getValue(
											y[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]));
						}
						if (cplex.getValue(f[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]) != 0.0) {
							result += " F value--> " + String.format("%1.1f",
									cplex.getValue(f[grafo.getEdgeSource(e).getId()][grafo.getEdgeTarget(e).getId()]));
						} else if (cplex
								.getValue(f[grafo.getEdgeTarget(e).getId()][grafo.getEdgeSource(e).getId()]) != 0.0) {
							result += " F: Vertex (" + grafo.getEdgeTarget(e).getId() + " "
									+ grafo.getEdgeSource(e).getId() + ")-->" + String.format("%1.1f", cplex.getValue(
											f[grafo.getEdgeTarget(e).getId()][grafo.getEdgeSource(e).getId()]));
						}
					}

				} else {
					this.status=cplex.getStatus();

					result = "Model not solved -->" + this.getStatus();
				
				}
			//cplex.exportModel("model.lp");
				cplex.clearModel();
	        	cplex.endModel();
				cplex.end();
				cplex.close();
				
				return result;

			} catch (IloException exc) {

				exc.printStackTrace();
			}
		}
		return null;
	}

	public String isVertexCover() {
		for (DefaultWeightedEdge e : this.grafo.edgeSet()) {
			if (grafo.getEdgeSource(e).isX() == false && grafo.getEdgeTarget(e).isX() == false) {
				return "false";
			}
		}
		return "true";
	}

	public String isConnectedVertexCover() {
		int num=0;
		for (Vertex v : this.vertici()) {
			
			if (v.isX() == true) {
				if(this.trovaPercorso(v)==null) {
					return "false";
			}else {
				num++;
			}
		}
		}
		if(num==this.vertici().size()) {
			return "false";
		}
		return "true";
	}

	public List<Vertex> trovaPercorso(Vertex finale) {
	//	System.out.println("finale "+finale);
		List<Vertex> percorso = new ArrayList<Vertex>();
		visita.put(this.verticeT, null); // matrice key= vicino, value= partenza
		BreadthFirstIterator<Vertex, DefaultWeightedEdge> it = new BreadthFirstIterator<>(this.grafo, this.verticeT);
		it.addTraversalListener(new TraversalListener<Vertex, DefaultWeightedEdge>() {

			@Override
			public void connectedComponentFinished(ConnectedComponentTraversalEvent e) {
			}

			@Override
			public void connectedComponentStarted(ConnectedComponentTraversalEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void edgeTraversed(EdgeTraversalEvent<DefaultWeightedEdge> e) {
				Vertex sorgente = grafo.getEdgeSource(e.getEdge());
				Vertex destinazione = grafo.getEdgeTarget(e.getEdge());

				if (!visita.containsKey(destinazione) && visita.containsKey(sorgente)) {
					visita.put(destinazione, sorgente);
				} else if (!visita.containsKey(sorgente) && visita.containsKey(destinazione)) {
					visita.put(sorgente, destinazione);
				}
			}

			@Override
			public void vertexTraversed(VertexTraversalEvent<Vertex> e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void vertexFinished(VertexTraversalEvent<Vertex> e) {
				// TODO Auto-generated method stub

			}
		});
		while (it.hasNext()) {
			it.next();
		}
		if (!visita.containsKey(finale)) {
			return null;
		}
		Vertex step = finale;
		while (!step.equals(this.verticeT)) {
			percorso.add(step);
			step = visita.get(step);
		//	System.out.println(step);
		}
		percorso.add(this.verticeT);
		return percorso;
	}

	public  List<Set<Vertex>> connesse() {
		ConnectivityInspector<Vertex, DefaultWeightedEdge> ci = new ConnectivityInspector<Vertex, DefaultWeightedEdge>(this.grafo);
		
		return ci.connectedSets();
	}
}
