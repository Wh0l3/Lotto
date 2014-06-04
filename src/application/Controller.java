/**
 * Sample Skeleton for 'Application.fxml' Controller Class
 */

package application;

import java.awt.Font;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Controller {

	@FXML
	// ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	// URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML
	// fx:id="mnu_close"
	private MenuItem mnu_close; // Value injected by FXMLLoader

	@FXML
	// fx:id="tab_uploadMultiple"
	private Tab tab_uploadMultiple; // Value injected by FXMLLoader

	@FXML
	// fx:id="tab_uploadSingle"
	private Tab tab_uploadSingle; // Value injected by FXMLLoader

	@FXML
	// fx:id="btn_uploadSingle"
	private Button btn_uploadSingle; // Value injected by FXMLLoader

	@FXML
	// fx:id="btn_uploadMultiple"
	private Button btn_uploadMultiple; // Value injected by FXMLLoader

	@FXML
	// fx:id="mnu_about"
	private MenuItem mnu_about; // Value injected by FXMLLoader

	@FXML
	// fx:id="lbl_responses"
	private Label lbl_responses; // Value injected by FXMLLoader

	@FXML
	// fx:id="grid_Numbers"
	private GridPane grid_Numbers; // Value injected by FXMLLoader

	@FXML
	void alert(ActionEvent event) {
		// System.out.println("asdfasdf");
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			System.out.print("File erhalten");
			lbl_responses.setText("File erhalten");
		} else {
			lbl_responses.setText("Kein File enthalten");
		}
	}

	@FXML
	void setResponseText(String text) {
		lbl_responses.setText(text);
	}

	@FXML
	void selectFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			setResponseText("File "+file.getName()+" erhalten");

		} else {
			setResponseText("Kein File enthalten");
		}
	}

	@FXML
	// This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert mnu_close != null : "fx:id=\"mnu_close\" was not injected: check your FXML file 'Application.fxml'.";
		assert tab_uploadMultiple != null : "fx:id=\"tab_uploadMultiple\" was not injected: check your FXML file 'Application.fxml'.";
		assert tab_uploadSingle != null : "fx:id=\"tab_uploadSingle\" was not injected: check your FXML file 'Application.fxml'.";
		assert btn_uploadSingle != null : "fx:id=\"btn_uploadSingle\" was not injected: check your FXML file 'Application.fxml'.";
		assert btn_uploadMultiple != null : "fx:id=\"btn_uploadMultiple\" was not injected: check your FXML file 'Application.fxml'.";
		assert mnu_about != null : "fx:id=\"mnu_about\" was not injected: check your FXML file 'Application.fxml'.";
		setGridPaneNumbers();
	}
	
	@FXML
	void setGridPaneNumbers() {
		final Label label = new Label();
        int gridLabel = 0;
        for(int i=0;i<10;i++){
        	for(int j=0;j<5;j++){
        		gridLabel++;
        		grid_Numbers.add(new Label(gridLabel + ""), i, j);
        	}
        }
	}

	@FXML
	void setGridPaneStarNumbers() {

	}

	@FXML
	void setGridPaneSuperStarNumbers() {

	}
}
