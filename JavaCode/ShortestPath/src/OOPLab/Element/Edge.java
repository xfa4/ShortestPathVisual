package OOPLab.Element;

import java.util.Random;

import OOPLab.MainApplicationController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Edge extends Line {
	private int ID;
	private int weight;
	private Vertext start, end;
	private TextField text;
	private double textwidth = Configuration.textWeightwidth, textheight = Configuration.textWeighheight;
	public double PosTextx() {
		return Math.max(0.0, (this.start.getCenterX() + this.end.getCenterX())/2 - textwidth/2);
	}
	public double PosTexty() {
		return Math.max(0.0, (this.start.getCenterY() + this.end.getCenterY())/2 - textheight/2);
	}
	// constructor Edge with parameters
	public Edge(Vertext start, Vertext end) {
		super(start.getCenterX(), start.getCenterY(), end.getCenterX(), end.getCenterY());
		// set max size for text box
		ID = Configuration.GraphEdge.size();
		// assign start vertext
		this.setStart(start);
		// assign end vertext
		this.setEnd(end);
		// assign color
		this.setStroke(Color.BLUE);
		// assign weight of edge with random number from min to max
		this.weight = new Random().nextInt(Configuration.maxWeight - Configuration.minWeight) + Configuration.minWeight;
		
		text = new TextField(String.valueOf(this.weight));
		text.setMaxSize(textwidth, textheight);
	
		// assignment text Layout
		text.setLayoutX(PosTextx());
		text.setLayoutY(PosTexty());
		text.setAlignment(Pos.CENTER);
		text.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent t) {
				// TODO Auto-generated method stub
				if(t.getCode() == KeyCode.ENTER) {
					try {
						weight = Integer.valueOf(text.getText());
						System.out.println("Edge id: " + ID + " weight " + weight);
						text.cancelEdit();
					}
					catch(Exception e){
						System.out.println("Error in weight");
					}
				}
			}
			
		});

		this.endXProperty().bind(this.end.centerXProperty());
		this.endYProperty().bind(this.end.centerYProperty());
		this.startXProperty().bind(this.start.centerXProperty());
		this.startYProperty().bind(this.start.centerYProperty());
		this.end.centerXProperty().addListener((v, oldvalue, newvalue)->{
			text.setLayoutX(PosTextx());
			text.setLayoutY(PosTexty());
		});
		this.end.centerYProperty().addListener((v, oldvalue, newvalue)->{
			text.setLayoutX(PosTextx());
			text.setLayoutY(PosTexty());
		});
		this.start.centerXProperty().addListener((v, oldvalue, newvalue)->{
			text.setLayoutX(PosTextx());
			text.setLayoutY(PosTexty());
		});
		this.start.centerYProperty().addListener((v, oldvalue, newvalue)->{
			text.setLayoutX(PosTextx());
			text.setLayoutY(PosTexty());
		});
		
//		text.setTextFormatter(new TextFormatter<>(TextFormatter.IDENTITY_STRING_CONVERTER));
	}
	
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Vertext getStart() {
		return start;
	}
	public void setStart(Vertext start) {
		this.start = start;
	}
	public Vertext getEnd() {
		return end;
	}
	public void setEnd(Vertext end) {
		this.end = end;
	}
	public int getID() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public TextField getText() {
		return text;
	}
}
