package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class HelpController implements Initializable {
	@FXML
	TextArea helpTextArea;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		helpTextArea.setScaleShape(true);
		helpTextArea.setEditable(false);
	}

}