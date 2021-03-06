package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import Element.Configuration;
import Element.Edge;
import Element.Vertext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApplicationController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private AnchorPane myAnchor;
	@FXML
	private AnchorPane pane;
	@FXML
	private VBox myVbox;
	@FXML
	private Button AddVertextrb, AddEdgerb, MoveVertextrb, RemoveVertextrb, 
				RemoveEdgerb, ChooseStartEndVertextrb, helpButton;
	@FXML 
	private AnchorPane MainPane;
	@FXML
	ToggleGroup MyButton;
	@FXML 
	Label myLabel;
	@FXML
	Button ResetButton;
	@FXML
	Button BFAButton;
	private boolean FlagaddEdge = false, FlagremoveEdge = false, FlagStartEndVertext = false;
	private Vertext tempVertextA = null, tempVertextB = null;
	
	private boolean isAddV = false;
	private boolean isAddE = false;
	private boolean isMoveV = false;
	private boolean isRemoveV = false;
	private boolean isRemoveE = false;
	private boolean isChooseStartEndV = false;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		show();
//		MainPane.addEventHandler(MouseEvent.MOUSE_PRESSED, AddVertextHandler);
//		AddVertextrb.setTextFill(Configuration.VertextColor);
//		isAddV = false;
		AddVertextrb.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				AddVertextrb.setTextFill(Configuration.VertextColor);
				AddEdgerb.setTextFill(Color.BLACK);
				MoveVertextrb.setTextFill(Color.BLACK);
				RemoveEdgerb.setTextFill(Color.BLACK);
				RemoveVertextrb.setTextFill(Color.BLACK);
				ChooseStartEndVertextrb.setTextFill(Color.BLACK);
				isAddV = true;
				isAddE = isMoveV = isRemoveV = isRemoveE = isChooseStartEndV = false;
			}
			
		});
		AddEdgerb.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				AddEdgerb.setTextFill(Configuration.VertextColor);
				AddVertextrb.setTextFill(Color.BLACK);
				MoveVertextrb.setTextFill(Color.BLACK);
				RemoveEdgerb.setTextFill(Color.BLACK);
				RemoveVertextrb.setTextFill(Color.BLACK);
				ChooseStartEndVertextrb.setTextFill(Color.BLACK);
				isAddE = true;
				isAddV = isMoveV = isRemoveV = isRemoveE = isChooseStartEndV = false;
			}
			
		});
		MoveVertextrb.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				AddEdgerb.setTextFill(Color.BLACK);
				AddVertextrb.setTextFill(Color.BLACK);
				MoveVertextrb.setTextFill(Configuration.VertextColor);
				RemoveEdgerb.setTextFill(Color.BLACK);
				RemoveVertextrb.setTextFill(Color.BLACK);
				ChooseStartEndVertextrb.setTextFill(Color.BLACK);
				isMoveV = true;
				isAddV = isAddE = isRemoveV = isRemoveE = isChooseStartEndV = false;
			}
			
		});
		RemoveEdgerb.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				AddEdgerb.setTextFill(Color.BLACK);
				AddVertextrb.setTextFill(Color.BLACK);
				MoveVertextrb.setTextFill(Color.BLACK);
				RemoveEdgerb.setTextFill(Configuration.VertextColor);
				RemoveVertextrb.setTextFill(Color.BLACK);
				ChooseStartEndVertextrb.setTextFill(Color.BLACK);
				isRemoveE = true;
				isAddV = isMoveV = isRemoveV = isAddE = isChooseStartEndV = false;
			}
			
		});
		RemoveVertextrb.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				AddEdgerb.setTextFill(Color.BLACK);
				AddVertextrb.setTextFill(Color.BLACK);
				MoveVertextrb.setTextFill(Color.BLACK);
				RemoveEdgerb.setTextFill(Color.BLACK);
				RemoveVertextrb.setTextFill(Configuration.VertextColor);
				ChooseStartEndVertextrb.setTextFill(Color.BLACK);
				isRemoveV = true;
				isAddV = isMoveV = isAddE = isRemoveE = isChooseStartEndV = false;
			}
			
		});
		ChooseStartEndVertextrb.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				AddEdgerb.setTextFill(Color.BLACK);
				AddVertextrb.setTextFill(Color.BLACK);
				MoveVertextrb.setTextFill(Color.BLACK);
				RemoveEdgerb.setTextFill(Color.BLACK);
				RemoveVertextrb.setTextFill(Color.BLACK);
				ChooseStartEndVertextrb.setTextFill(Configuration.VertextColor);
				isChooseStartEndV = true;
				isAddV = isMoveV = isAddE = isRemoveE = isRemoveV = false;
			}
		});
		helpButton.setOnAction(e -> {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Help.fxml"));
			try {
				Parent root1;
				root1 = loader.load();
				Stage stage1 = new Stage();
				stage1.setTitle("Help");
				Image icon = new Image("/application/dauhoi.jpg");
				stage1.getIcons().add(icon);
				stage1.setResizable(false);
				stage1.setScene(new Scene(root1));
				stage1.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	// action function for radio button
	public void ActionEventFunc(ActionEvent e) {
		if(isAddV) {
			AddVertextFunction();
		}
		else if (isAddE) {
			AddEdgeFunction();
		}
		else if (isRemoveV) {
			RemoveVertextFunction();
		}
		else if(isMoveV) {
			MoveVertextFunction();
		}
		else if(isRemoveE) {
			RemoveEdgeFunction();
		}
		else if(isChooseStartEndV) {
			ChooseStartEndVertext();
		}
	}
	// BellmanFord Algorithm
	public void BellmanFordAlgorithmFunction(ActionEvent e) throws IOException {
		if(!CheckStartEndVertext()) return;
		System.setProperty("user.dir", "BellmanFordAlgorithm");
		root = FXMLLoader.load(getClass().getResource("/application/BellmanFord/BellmanFordAlgorithm.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/astar.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void DijkstraAlgorithm(ActionEvent event) throws IOException{
		if(!CheckStartEndVertext()) return;
		System.setProperty("user.dir", "Dijkstra");
		root = FXMLLoader.load(getClass().getResource("/application/Dijkstra/DijkstraScreen.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/astar.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void aStarAlgorithm(ActionEvent event) throws IOException{
		if(!CheckStartEndVertext()) return;
		System.setProperty("user.dir", "aStar");
		root = FXMLLoader.load(getClass().getResource("/application/AStar/AStarAlgorithm.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/astar.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}	
	// reset function
	public void ResetFunction(ActionEvent e) {
		MainPane.getChildren().clear();
		Configuration.GraphNode.clear();
		myLabel.setText("");
		AddVertextFunction();
		AddVertextrb.setTextFill(Configuration.VertextColor);
		AddEdgerb.setTextFill(Color.BLACK);
		MoveVertextrb.setTextFill(Color.BLACK);
		RemoveEdgerb.setTextFill(Color.BLACK);
		RemoveVertextrb.setTextFill(Color.BLACK);
		ChooseStartEndVertextrb.setTextFill(Color.BLACK);
		isAddV = true;
		isAddE = isMoveV = isRemoveV = isRemoveE = isChooseStartEndV = false;

	}
	
	// Add Vertext Function 
	public void AddVertextFunction() {
		Configuration.allowMoveVertext = true;
		myLabel.setText("Add vertext by clicking into white scene ");
		MainPane.addEventHandler(MouseEvent.MOUSE_PRESSED, AddVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, ChooseStartEndVertextHandler);
	}
	
	// Add Edge Function
	public void AddEdgeFunction() {
		if(!CheckCanAddEdge()) return;
		Configuration.allowMoveVertext = false;
		myLabel.setText("Please choose an Vertext");
		MainPane.addEventHandler(MouseEvent.MOUSE_PRESSED, AddEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, ChooseStartEndVertextHandler);
	}
	
	// Remove Vertext function
	public void RemoveVertextFunction() {
		if(!CheckAnyVertex()) return;
		Configuration.allowMoveVertext = true;
		myLabel.setText("Please choose an vertext to remove");
		MainPane.addEventHandler(MouseEvent.MOUSE_PRESSED, RemoveVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, ChooseStartEndVertextHandler);
	}
	
	
	// Move Vertext function
	public void MoveVertextFunction() {
		if(!CheckAnyVertex()) return;
		Configuration.allowMoveVertext = true;
		myLabel.setText("Drag mouse on an vertext to move");
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, ChooseStartEndVertextHandler);
	}
	
	// Remove Edge function
	public void RemoveEdgeFunction() {
		if(!CheckCanRemoveEdge()) return;
		Configuration.allowMoveVertext = false;
		myLabel.setText("Please choose an Vertext");
		MainPane.addEventHandler(MouseEvent.MOUSE_PRESSED, RemoveEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, ChooseStartEndVertextHandler);
	}
	
	// Choose Start and End function
	public void ChooseStartEndVertext() {
		if(!CheckAnyVertex()) return;
		if(Configuration.startVertext != null || Configuration.endVertext != null) {
			Configuration.startVertext.setFill(Color.RED);
			Configuration.endVertext.setFill(Color.RED);
			Configuration.startVertext = null;
			Configuration.endVertext = null;
		}
		Configuration.allowMoveVertext = false;
		myLabel.setText("Please choose Start Vertext");
		MainPane.addEventHandler(MouseEvent.MOUSE_PRESSED, ChooseStartEndVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddVertextHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, AddEdgeHandler);
		MainPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, RemoveEdgeHandler);
	}
	
	
	// add vertext handler
	EventHandler<MouseEvent> AddVertextHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			double x = e.getX();
			double y = e.getY();
			myLabel.setText("Add vertext by clicking into white scene ");
			if(e.isPrimaryButtonDown() && !Configuration.Nodeexist(x, y)) {
				System.out.println("new vertext");
				Vertext newVertext = new Vertext(x, y);
				MainPane.getChildren().add(newVertext.getStack());
				Configuration.GraphNode.add(newVertext);
				myLabel.setText("Add Vertext succefully!!");
//				myLabel.setText("Add vertext by clicking into white scene ");
			}
		}
	};
	// choose start and end vertext
	EventHandler<MouseEvent> ChooseStartEndVertextHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			myLabel.setText("Please choose Start Vertext");
			double x = e.getX();
			double y = e.getY();
			for(Vertext vertext : Configuration.GraphNode) {
				if(vertext.checkClick(x, y)) {
					if(!FlagStartEndVertext) {
						vertext.setFill(Configuration.startColor);
						Configuration.startVertext = vertext;
						myLabel.setText("Please choose end Vertext");
						FlagStartEndVertext = true;
					}
					else {
						vertext.setFill(Configuration.endColor);
						// if click to start vertext again, refill both start and end vertext
						if(vertext.equals(Configuration.startVertext)) {
							FlagStartEndVertext = false;
							Configuration.startVertext.setFill(Configuration.VertextColor);
							if(Configuration.endVertext != null) {
								Configuration.endVertext.setFill(Configuration.VertextColor);
								Configuration.endVertext = null;
							}
							myLabel.setText("Please choose Start Vertext");
							Configuration.startVertext = null;
							return;
						}
						// if click to end vertext again, refill only end vertext
						else if(Configuration.endVertext != null && vertext.equals(Configuration.endVertext)) {
							FlagStartEndVertext = true;
							Configuration.endVertext.setFill(Configuration.VertextColor);
							Configuration.endVertext = null;
							return;
						}
						Configuration.endVertext = vertext;
						Configuration.endVertext.setFill(Configuration.endColor);
					}
				}
			}
		}
	};
	
	
	// add edge handler
	EventHandler<MouseEvent> AddEdgeHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			myLabel.setText("Please choose an Vertext");
			double x = e.getX();
			double y = e.getY();
			for(Vertext vertext : Configuration.GraphNode) {
				if(vertext.checkClick(x, y)) {
					
					if(!FlagaddEdge) {
						System.out.println("add Edge handler");
						vertext.setFill(Configuration.ChoseVertextColor);
						tempVertextA = vertext;
						myLabel.setText("Please choose another vertext to create edge");
						FlagaddEdge = true;
					}
					else {
						vertext.setFill(Configuration.ChoseVertextColor);
						if(vertext.equals(tempVertextA)){
							FlagaddEdge = false;
							tempVertextA.setFill(Configuration.VertextColor);
							myLabel.setText("Please choose an Vertext");
							return;
						}
						if(tempVertextA.isNeighborVertex(vertext)) {
							System.out.println("neighbor exists");
							vertext.setFill(Configuration.VertextColor);
							return;
						}
						tempVertextB = vertext;
						Edge newEdge = new Edge(tempVertextA, tempVertextB);
						TextField curtext = newEdge.getText();
						curtext.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e1) {
								// TODO Auto-generated method stub
								MainPane.requestFocus();
							}
						});
						MainPane.getChildren().add(0, newEdge);
						MainPane.getChildren().add(curtext);
						tempVertextA.addNeighbor(newEdge);
						tempVertextB.addNeighbor(newEdge);
						Configuration.GraphEdge.add(newEdge);
						myLabel.setText("Add Edge succesfully");
						tempVertextA.setFill(Configuration.VertextColor);
						tempVertextB.setFill(Configuration.VertextColor);
						FlagaddEdge = false;
					}
					break;
				}
			}
			
		}
		
	};
	
	EventHandler<MouseEvent> RemoveVertextHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			// only left click
			if(e.isSecondaryButtonDown()) return;
			myLabel.setText("Please choose an vertext to remove");
			double x = e.getX();
			double y = e.getY();
			Vertext curVertext = Configuration.getNode(x, y);
			if(curVertext != null) {
				for(Edge edge: curVertext.getNeighbors()) {
					MainPane.getChildren().remove(edge.getText());
					MainPane.getChildren().remove(edge);
					Vertext anotherVertext = (edge.getEnd().equals(curVertext)) ? edge.getStart(): edge.getEnd();
					anotherVertext.removeNeighbor(edge);
					Configuration.RemoveEdge(edge);
				}
//				MainPane.getChildren().removeAll(curVertext.getNeighbors());
				curVertext.removeAllNeighbor();
				MainPane.getChildren().remove(curVertext.getStack());
//				MainPane.getChildren().remove(curVertext.getText());
				int id = curVertext.getid();
				Configuration.RemoveNode(id);
				myLabel.setText("Remove Vertext succefully!!");
			}
			
		}
	};
	// remove Edge
	EventHandler<MouseEvent> RemoveEdgeHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			myLabel.setText("Please choose an Vertext");
			double x = e.getX();
			double y = e.getY();
			for(Vertext vertext : Configuration.GraphNode) {
				if(vertext.checkClick(x, y)) {
					vertext.setFill(Configuration.ChoseVertextColor);
					if(!FlagremoveEdge) {
						tempVertextA = vertext;
						myLabel.setText("Please choose another vertext to remove edge");
						FlagremoveEdge = true;
					}
					else {
						// if press on vertext A again
						if(vertext.equals(tempVertextA)){
							FlagremoveEdge = false;
							tempVertextA.setFill(Configuration.VertextColor);
							myLabel.setText("Please choose an Vertext");
							return;
						}
						if(!tempVertextA.isNeighborVertex(vertext)) {
							System.out.println("No neighbor exists");
							vertext.setFill(Configuration.VertextColor);
							return;
						}
						tempVertextB = vertext;
						Edge edge = tempVertextB.getEdge(tempVertextA);
						MainPane.getChildren().removeAll(edge, edge.getText());
						tempVertextA.removeNeighbor(tempVertextB);
						tempVertextB.removeNeighbor(tempVertextA);
						Configuration.GraphEdge.remove(edge);
						myLabel.setText("Remove Edge succesfully");
						tempVertextA.setFill(Configuration.VertextColor);
						tempVertextB.setFill(Configuration.VertextColor);
						FlagremoveEdge = false;
					}
					break;
				}
			}
			
		}
		
	};
	private void show() {
		if(Configuration.GraphNode.isEmpty()) return;
		for(Edge edge: Configuration.GraphEdge) {
			TextField curtext = edge.getText();
			curtext.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e1) {
					MainPane.requestFocus();
				}
			});
			MainPane.getChildren().addAll(edge, curtext);
		}
		for(Vertext v: Configuration.GraphNode) {
			MainPane.getChildren().addAll(v.getStack());
		}
	}
	private boolean CheckStartEndVertext() {
		if(Configuration.startVertext == null || Configuration.endVertext == null) {
			JOptionPane.showMessageDialog(null,"Check again start and end Vertext");
			return false;
		}
		return true;
	}
	// use for check move can use or remove can use
	private boolean CheckAnyVertex() {
		if(Configuration.GraphNode.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No vertex here");
			return false;
		}
		return true;
	}
	// use for check add edge
	private boolean CheckCanAddEdge() {
		if(Configuration.GraphNode.size() < 2) {
			JOptionPane.showMessageDialog(null, "Check again the number of vertext");
			return false;
		}
		return true;
	}
	// use for check can remove edge
	private boolean CheckCanRemoveEdge() {
		if(Configuration.GraphEdge.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No edge to remove");
			return false;
		}
		return true;
	}
}