/**
 * Sample Skeleton for 'Application.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ch.bfh.ti.lottery.tickets.TicketType.SuperStars;
import ch.bfh.ti.lottery.tickets.TicketType.SuperStars.SuperStar;
import ch.bfh.ti.lottery.tickets.Tickets;
import ch.bfh.ti.lottery.tickets.TicketType.Plays.Play;
import ch.bfh.ti.lottery.tickets.TicketType.Plays.Play.Numbers;
import ch.bfh.ti.lottery.tickets.TicketType.Plays.Play.Stars;
import ch.bfh.ti.lottery.tickets.Tickets.Ticket;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.ScrollPane;

public class Controller {

	@FXML
	// fx:id="srollPane"
	private ScrollPane srollPane; // Value injected by FXMLLoader
	
	@FXML
	// ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	// fx:id="mnu_setGerman"
	private MenuItem mnu_setGerman; // Value injected by FXMLLoader

	@FXML
	// fx:id="mnu_setEnglish"
	private MenuItem mnu_setEnglish; // Value injected by FXMLLoader

	@FXML
	// URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML
	// fx:id="lbl_responses"
	private Label lbl_responses; // Value injected by FXMLLoader

	@FXML
	// fx:id="grid_Numbers"
	private GridPane grid_Numbers; // Value injected by FXMLLoader

	@FXML
	// fx:id="lbl_StarNumbersTaken"
	private Label lbl_StarNumbersTaken; // Value injected by FXMLLoader

	@FXML
	// fx:id="btn_uploadMultiple"
	private Button btn_uploadMultiple; // Value injected by FXMLLoader

	@FXML
	// fx:id="txt_datum"
	private TextField txt_datum; // Value injected by FXMLLoader

	@FXML
	// fx:id="lbl_SuperStarNumbersTaken"
	private Label lbl_SuperStarNumbersTaken; // Value injected by FXMLLoader

	@FXML
	// fx:id="txt_superStar"
	private TextField txt_superStar; // Value injected by FXMLLoader

	@FXML
	// fx:id="mnu_close"
	private MenuItem mnu_close; // Value injected by FXMLLoader

   @FXML
    private Menu mnu_file;

    @FXML
    private Menu mnu_lang;
    
    @FXML
    private Menu mnu_edit; 
	@FXML
	// fx:id="tab_uploadMultiple"
	private Tab tab_uploadMultiple; // Value injected by FXMLLoader

	@FXML
	// fx:id="tab_uploadSingle"
	private Tab tab_uploadSingle; // Value injected by FXMLLoader

	@FXML
	// fx:id="grid_starNumbers"
	private GridPane grid_starNumbers; // Value injected by FXMLLoader

	@FXML
	// fx:id="lbl_NumbersTaken"
	private Label lbl_drawnNumbers; // Value injected by FXMLLoader

	@FXML
	// fx:id="btn_uploadSingle"
	private Button btn_uploadSingle; // Value injected by FXMLLoader

	@FXML
	// fx:id="grid_ListResults"
	private GridPane grid_ListResults; // Value injected by FXMLLoader

	@FXML
	// fx:id="mnu_about"
	private MenuItem mnu_about; // Value injected by FXMLLoader

	@FXML
	private ArrayList<Button> numberButtonList = new ArrayList<Button>();

	@FXML
	private ArrayList<Button> starNumberButtonList = new ArrayList<Button>();

	@FXML
	private ArrayList<Button> superStarNumberButtonList = new ArrayList<Button>();

	private SimpleStringProperty superStarText = new SimpleStringProperty();
	
	LottoDraw lotto = new LottoDraw();
	
	@FXML
    private Label lbl_Date;
	/*
	 * @FXML void alert(ActionEvent event) { FileChooser fileChooser = new
	 * FileChooser(); File file = fileChooser.showOpenDialog(null); if (file !=
	 * null) { System.out.print("File erhalten");
	 * lbl_responses.setText("File erhalten"); } else {
	 * lbl_responses.setText("Kein File enthalten"); } }
	 */

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
				try {
					getFileContent(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				setResponseText("File ist kein XML File. Bitte nochmals probieren");
			}
		} else {
			setResponseText("Kein File enthalten");
		}
	}

	@FXML
	boolean setLottoNumber(Integer i) {
		if (lotto.setNumber(i)) {
			enablePanes();
			return true;
		}
		return false;

	}

	@FXML
	boolean setLottoStarNumber(Integer i) {
		if (lotto.setStarNumber(i)) {
			enablePanes();
			return true;
		}
		return false;

	}

	@FXML
	boolean setLottoSuperStarNumber(String s) {
		if (lotto.setSuperStarNumber(s)) {
			enablePanes();
			return true;
		}
		return false;
	}

	private void enablePanes() {
		System.out.println(lotto.numbers.size());
		System.out.println(lotto.starNumbers.size());
		System.out.println(lotto.superStarNumber.length());
		
		
		if (lotto.numbers.size() == 5 && lotto.starNumbers.size() == 2) {
			
			tab_uploadSingle.setDisable(false);
			tab_uploadMultiple.setDisable(false);
		} else {
			tab_uploadSingle.setDisable(true);
			tab_uploadMultiple.setDisable(true);
		}
	}

	@FXML
	// This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert srollPane != null : "fx:id=\"srollPane\" was not injected: check your FXML file 'Application.fxml'.";
		assert mnu_setGerman != null : "fx:id=\"mnu_setGerman\" was not injected: check your FXML file 'Application.fxml'.";
		assert lbl_responses != null : "fx:id=\"lbl_responses\" was not injected: check your FXML file 'Application.fxml'.";
		assert grid_Numbers != null : "fx:id=\"grid_Numbers\" was not injected: check your FXML file 'Application.fxml'.";
		assert mnu_setEnglish != null : "fx:id=\"mnu_setEnglish\" was not injected: check your FXML file 'Application.fxml'.";
		assert lbl_StarNumbersTaken != null : "fx:id=\"lbl_StarNumbersTaken\" was not injected: check your FXML file 'Application.fxml'.";
		assert btn_uploadMultiple != null : "fx:id=\"btn_uploadMultiple\" was not injected: check your FXML file 'Application.fxml'.";
		assert txt_datum != null : "fx:id=\"txt_datum\" was not injected: check your FXML file 'Application.fxml'.";
		assert lbl_SuperStarNumbersTaken != null : "fx:id=\"lbl_SuperStarNumbersTaken\" was not injected: check your FXML file 'Application.fxml'.";
		assert txt_superStar != null : "fx:id=\"txt_superStar\" was not injected: check your FXML file 'Application.fxml'.";
		assert mnu_close != null : "fx:id=\"mnu_close\" was not injected: check your FXML file 'Application.fxml'.";
		assert tab_uploadMultiple != null : "fx:id=\"tab_uploadMultiple\" was not injected: check your FXML file 'Application.fxml'.";
		assert tab_uploadSingle != null : "fx:id=\"tab_uploadSingle\" was not injected: check your FXML file 'Application.fxml'.";
		assert grid_starNumbers != null : "fx:id=\"grid_starNumbers\" was not injected: check your FXML file 'Application.fxml'.";
		assert lbl_drawnNumbers != null : "fx:id=\"lbl_NumbersTaken\" was not injected: check your FXML file 'Application.fxml'.";
		assert btn_uploadSingle != null : "fx:id=\"btn_uploadSingle\" was not injected: check your FXML file 'Application.fxml'.";
		assert grid_ListResults != null : "fx:id=\"grid_ListResults\" was not injected: check your FXML file 'Application.fxml'.";

		setGridPaneNumbers();
		setGridPaneStarNumbers();
		
		SimpleStringProperty drawnNumbers = new SimpleStringProperty();
		
		this.txt_datum.textProperty().bindBidirectional(drawnNumbers);
		
		/*
		 * try { getFileContent(new File("ticPool.xml")); } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (JAXBException e) { }// TODO
		 */

	}
	private void changeLanguage(ResourceBundle resources)
	{
		lbl_Date.setText(resources.getString("key.label.date"));
		lbl_drawnNumbers.setText(resources.getString("key.label.drawnNumbers"));
		lbl_responses.setText(resources.getString("key.tab.second"));
		this.tab_uploadSingle.setText((resources.getString("key.tab.second")));
		this.mnu_edit.setText((resources.getString("key.menu.file")));
		this.mnu_file.setText((resources.getString("key.menu.edit")));
		this.mnu_lang.setText((resources.getString("key.menu.languages")));
		this.btn_uploadSingle.setText((resources.getString("key.selectFile")));
		this.lbl_StarNumbersTaken.setText((resources.getString("key.listTable.superStar")));
		
		
	}
	@FXML
	void setEnglish(ActionEvent event) throws IOException {
		resources = ResourceBundle.getBundle("Bundle", new Locale("en", "EN"));
		System.out.println(resources.getLocale());
		this.changeLanguage(resources);
	}

	@FXML
	void setGerman(ActionEvent event) {

		resources = ResourceBundle.getBundle("Bundle", new Locale("de", "DE"));
		this.changeLanguage(resources);
	}

	@FXML
	void setLottoDate(ActionEvent event) {
		TextField tmp = (TextField) event.getSource();
		lotto.setDate((String) tmp.getCharacters());
	}

	@FXML
	void setSuperStar(ActionEvent event) {
		TextField tmp = (TextField) event.getSource();
		lotto.setSuperStarNumber((String) tmp.getCharacters());
	}

	@FXML
	void setGridPaneNumbers() {
		int gridLabel = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				gridLabel++;
				Button b = new Button(gridLabel + "");
				b.addEventHandler(MouseEvent.MOUSE_CLICKED,
						new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent arg0) {
								Button b = (Button) arg0.getSource();

								// TODO Auto-generated method stub
								if (setLottoNumber(Integer.parseInt(b.getText()))) {
									b.setEffect(new DropShadow());
								} else {
									b.setEffect(null);
								}
							}

						});
				grid_Numbers.add(b, j, i);
			}
		}
	}

	@FXML
	void setGridPaneStarNumbers() {
		int gridLabel = 0;
		for (int i = 0; i < 11; i++) {
			gridLabel++;
			Button b = new Button(gridLabel + "");
			b.addEventHandler(MouseEvent.MOUSE_CLICKED,
					new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent arg0) {
							Button b = (Button) arg0.getSource();

							// TODO Auto-generated method stub
							if (setLottoStarNumber(Integer.parseInt(b.getText()))) {
								b.setEffect(new DropShadow());
							} else {
								b.setEffect(null);
							}
						}

					});
			grid_starNumbers.add(b, i, 0);
		}
	}

	void getFileContent(File file) throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance("ch.bfh.ti.lottery.tickets");
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File tmpFile = new File("ticPool.xml");

		// UnMashal the XML - File

		Tickets tickets = (Tickets) unmarshaller.unmarshal(file);
		int columnCount = 1;
		for (int i = 0; i < tickets.getTicket().size(); i++) {

			/*
			 * every loop is a ticket
			 */

			if (tickets.getTicket().get(i) instanceof Ticket) {
				Ticket ticket = (Ticket) tickets.getTicket().get(i);
				System.out.println(ticket.getTicketId());
				// ticket.getTicketId();

				String time = ticket.getTimeStamp().getDay() + "."
						+ ticket.getTimeStamp().getMonth() + "."
						+ ticket.getTimeStamp().getYear();
				if (ticket.getValidity() == 1 && lotto.getDate().equals(time)) { // &&
					SuperStars superStar = ticket.getSuperStars();

					for (int j = 0; j < ticket.getPlays().getPlay().size(); j++) {

						Play play = (Play) ticket.getPlays().getPlay().get(j);
						Numbers numbers = play.getNumbers();
						Stars stars = play.getStars();

						int hasSuperStar = 0;
						int playId = play.getPlayId();
						int tmp = 0;
						int starTmp = 0;

						for (int number : numbers.getNumber()) {
							if (lotto.getNumbers().contains(number)) {
								tmp++;
							}
						}

						for (int starNumber : stars.getStar()) {
							if (lotto.getStarNumbers().contains(starNumber)) {
								starTmp++;
							}
						}

						for (SuperStar ele : ticket.getSuperStars()
								.getSuperStar()) {
							if (ele.equals(superStar)) {
								hasSuperStar = 1;
							}
						}

						grid_ListResults.addColumn(columnCount, new Pane());
						grid_ListResults.add(new Label(playId + ""), 0,
								columnCount);
						grid_ListResults.add(new Label(tmp + ""), 1,
								columnCount);
						grid_ListResults.add(new Label(starTmp + ""), 2,
								columnCount);
						grid_ListResults.add(new Label(hasSuperStar + ""), 3,
								columnCount);
						columnCount++;
					}
				}
			}
		}
		System.out.println("Fertig");
	}

}
