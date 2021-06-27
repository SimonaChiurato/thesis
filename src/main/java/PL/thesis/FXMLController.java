package PL.thesis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import model.Model;
import model.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCreaGrafo;
    @FXML
    private TextArea txtResult;

    @FXML
    private ComboBox<String> boxTxt;
    @FXML
    void doGrafo(ActionEvent event) throws IOException {
    	
    	this.txtResult.clear();
    	
    /*	if(this.boxTxt.getValue()== null) {
    		 this.txtResult.setText("Il file txt non è stato selezionato");
    		 return;
    	}
   	BufferedReader in = new BufferedReader(new FileReader(this.boxTxt.getValue()));
		String linea;
		while ((linea = in.readLine()) != null) {
			try {
				 if(!linea.matches("^[0-9]*(:)?[0-9 ]+")) {
					  this.txtResult.setText("Il file txt non è stato fornito nel formato giusto");
					  return;
					  }
	
			}catch (Exception e) {
			    //System.err.println("Errore");
				e.printStackTrace();
			}
		}*/
    	model.leggiGrafo2(this.boxTxt.getValue());
    	model.getGrafoFittizio();
    	
    	txtResult.appendText("Grafo creato con # vertici: " + this.model.vertici().size() + " # archi: "
				+ this.model.archi().size() + " numero di vertici prima linea: "+this.model.getNumVertex()+"\n");
    //	txtResult.appendText(this.model.vertici().toString()+ "\n" + this.model.archi().toString()+"\n");
    	String result= this.model.solveMeCVC2();
    	if( result=="") {
    		txtResult.appendText("Errore risoluzione problema");
    	}else {
    		txtResult.appendText(result); 
    	}
    	
    	txtResult.appendText("\nThe solution is a vertex cover? -->"+this.model.isVertexCover());
    	txtResult.appendText("\nThe solution is a connected vertex cover? -->"+this.model.isConnectedVertexCover());

    }  	
    	
 
   
    @FXML
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert boxTxt != null : "fx:id=\"boxTxt\" was not injected: check your FXML file 'Scene.fxml'.";
     
    }
    public void setModel(Model model) {
		this.model = model;
		this.boxTxt.getItems().clear();
    	this.boxTxt.getItems().add("email-univ.edges");
    	this.boxTxt.getItems().add("C:\\Users\\Simona\\Desktop\\PoliTo\\TESI\\istanze\\n4c6-b15.mtx");
    		
	}
}

