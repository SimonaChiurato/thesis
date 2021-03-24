package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloRange;
import ilog.cplex.IloCplex;

public class Model {

	SimpleWeightedGraph<Vertex, DefaultWeightedEdge> grafo;
	int numVertex;
	List<Vertex> vertici = new ArrayList<Vertex>();

	public Model() {
		this.numVertex = 0;
		this.grafo = null;
	}

	/*
	 * Formato file: numero vertici 0: 1 1: 0 2 --> vicini 2:
	 */
	public void leggiGrafo(String nomeFile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		String linea;
		this.grafo = new SimpleWeightedGraph<Vertex, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Integer nRow = 0;

		while ((linea = in.readLine()) != null) {
			try {
				if (nRow == 0 && linea.matches("[0-9]+")) {
					this.numVertex = Integer.parseInt(linea);

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
				}

				nRow++;
			} catch (Exception e) {
				// System.err.println("Errore");
				e.printStackTrace();

			}

		}
		in.close();
	}

	public SimpleWeightedGraph<Vertex, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	public int getNumVertex() {
		return numVertex;
	}

	public Set<Vertex> vertici() {
		return this.grafo.vertexSet();
	}

	public Set<DefaultWeightedEdge> archi() {
		return this.grafo.edgeSet();
	}

	public List<Adiacenza> connessi(Vertex partenza) {
		List<Adiacenza> adiacenze = new ArrayList<>();

		List<Vertex> vicini = Graphs.neighborListOf(grafo, partenza);
		for (Vertex a : vicini) {
			adiacenze.add(new Adiacenza(partenza, a, grafo.getEdgeWeight(grafo.getEdge(partenza, a))));
		}
		return adiacenze;
	}

	public String solveMe() {
		String result="";
		if (this.grafo != null) {
			try {
				IloCplex cplex = new IloCplex();

				IloNumVar[] x = new IloNumVar[this.numVertex]; // appartiene a 1 o 0

				IloLinearNumExpr obj = cplex.linearNumExpr();
				for(Vertex v: this.grafo.vertexSet()) {
					x[v.getId()]= cplex.boolVar();
					obj.addTerm(v.getC(), x[v.getId()]);
				}

				// creata funzione obiettivo
				cplex.addMinimize(obj); // minimizza la funzione obiettivo

			// vincolo xv+xu >=1
				for(DefaultWeightedEdge e: this.grafo.edgeSet()) {
					cplex.addGe(cplex.sum(x[grafo.getEdgeSource(e).getId()], x[grafo.getEdgeTarget(e).getId()]), 1);
				}
				Integer timeRunning = 10;
				cplex.setParam(IloCplex.DoubleParam.TimeLimit, timeRunning);
				cplex.setParam(IloCplex.IntParam.Simplex.Display, 0);
				cplex.setOut(null);
				
				long start = System.currentTimeMillis();
				if (cplex.solve()) {
					long end = System.currentTimeMillis();
					Double time = (end-start)/Double.valueOf(1000);
					String formattedTime = String.format("%.3f", time);
					
					result+="obj = " + cplex.getObjValue()+" time = "+formattedTime+" s status = "+cplex.getStatus()+" \n";
					//result+="0.0 the vertex isn't in the solution \n 1.0 the vertex is in the solution";
					for(Vertex v: this.grafo.vertexSet()) {
						result+="Vertex "+ v.getId()+"-->"+cplex.getValue(x[v.getId()])+"\n";
					}
					

				} else {
					result="Model not solved";
				}
				//cplex.exportModel("model.lp");
				cplex.end();
				return result;
				
			} catch (IloException exc) {

				exc.printStackTrace();
			}
		}
		return null;
	}
}
