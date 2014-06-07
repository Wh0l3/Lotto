/**
 * Sample Skeleton for 'Application.fxml' Controller Class
 */

package application;

import java.awt.List;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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
	// fx:id="grid_starNumbers"
	private GridPane grid_starNumbers; // Value injected by FXMLLoader

	@FXML
	// fx:id="grid_superStarNumbers"
	private GridPane grid_superStarNumbers; // Value injected by FXMLLoader
	
	@FXML
	private ArrayList<Button> numberButtonList = new ArrayList<Button>();
	
	@FXML
	private ArrayList<Button> starNumberButtonList = new ArrayList<Button>();
	
	@FXML
	private ArrayList<Button> superStarNumberButtonList = new ArrayList<Button>();

	@FXML
	void alert(ActionEvent event) {
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
	void selectFile(ActionEvent event) throws JAXBException {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			if (file.getName().contains(".xml")) {
				setResponseText("File " + file.getName() + " erhalten");
				getFileContent(file);
			} else {
				setResponseText("File ist kein XML File. Bitte nochmals probieren");
			}
		} else {
			setResponseText("Kein File enthalten");
		}
	}

	@FXML
    void setLottoNumber(ActionEvent event) {

    }

    @FXML
    void setLottoStarNumber(ActionEvent event) {

    }

    @FXML
    void setLottoSuperStarNumber(ActionEvent event) {

    }

	@FXML
	// This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert mnu_close != null : "fx:id=\"mnu_close\" was not injected: check your FXML file 'Application.fxml'.";
		assert grid_superStarNumbers != null : "fx:id=\"grid_superStarNumbers\" was not injected: check your FXML file 'Application.fxml'.";
		assert tab_uploadMultiple != null : "fx:id=\"tab_uploadMultiple\" was not injected: check your FXML file 'Application.fxml'.";
		assert tab_uploadSingle != null : "fx:id=\"tab_uploadSingle\" was not injected: check your FXML file 'Application.fxml'.";
		assert grid_starNumbers != null : "fx:id=\"grid_starNumbers\" was not injected: check your FXML file 'Application.fxml'.";
		assert lbl_responses != null : "fx:id=\"lbl_responses\" was not injected: check your FXML file 'Application.fxml'.";
		assert grid_Numbers != null : "fx:id=\"grid_Numbers\" was not injected: check your FXML file 'Application.fxml'.";
		assert btn_uploadSingle != null : "fx:id=\"btn_uploadSingle\" was not injected: check your FXML file 'Application.fxml'.";
		assert btn_uploadMultiple != null : "fx:id=\"btn_uploadMultiple\" was not injected: check your FXML file 'Application.fxml'.";
		assert mnu_about != null : "fx:id=\"mnu_about\" was not injected: check your FXML file 'Application.fxml'.";
		setGridPaneNumbers();
		setGridPaneStarNumbers();
		setGridPaneSuperStarNumbers();
	}

	@FXML
	void setGridPaneNumbers() {
		int gridLabel = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				gridLabel++;
				//numberButtonList.add(gridLabel, new Button(gridLabel + ""));
				grid_Numbers.add(new Button(gridLabel + ""), i, j);
			}
		}
	}

	@FXML
	void setGridPaneStarNumbers() {
		int gridLabel = 0;
		for (int i = 0; i < 11; i++) {
			gridLabel++;
			//starNumberButtonList.add(gridLabel, new Button(gridLabel + ""));
			grid_starNumbers.add(new Button(gridLabel + ""), i, 0);
		}
	}

	@FXML
	void setGridPaneSuperStarNumbers() {
		int gridLabel = 0;
		for (int i = 0; i < 4; i++) {
			gridLabel++;
			//superStarNumberButtonList.add(gridLabel, new Button(gridLabel + ""));
			grid_superStarNumbers.add(new Button(gridLabel + ""), i, 0);
			//button.setOnAction(new EventHandler<ActionEvent>() {
			 //   @Override public void handle(ActionEvent e) {
			  //  	e.getSource().getClass();
			    	//setLottoNumber(gridLabel);
			    	//System.out.print(e);
			   // }
			//});
		}
	}

	void getFileContent(File file) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance("application");
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File tmpFile = new File("lottery_tickets2.xml");
		// UnMashal the XML - File
		System.out.print(tmpFile.exists());
		LotteryTicketsType tickets = (LotteryTicketsType) unmarshaller
				.unmarshal(tmpFile);
		for (int i = 0; i < tickets.getLotteryTicket().size(); i++) {
			if (tickets.getLotteryTicket().get(i) instanceof LotteryTicketType) {
				LotteryTicketType ticket = (LotteryTicketType) tickets
						.getLotteryTicket().get(i);
				System.out.print(ticket);
				for (int j = 0; j < ticket.getPlay().size(); j++) {
					PlayType play = (PlayType) ticket.getPlay().get(j);
				}
			}
		}
	}

}
