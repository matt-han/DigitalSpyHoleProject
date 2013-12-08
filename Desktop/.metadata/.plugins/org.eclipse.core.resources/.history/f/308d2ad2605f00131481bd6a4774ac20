package windowsSpyHole;


import windowsSpyHole.registrationWindow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class passwortWindow extends Application {

	private GridPane gridPane;
	private Stage stage;

	public static void main(String[] args)
	{
		launch(args);
		
	}

	@Override
	public void start(Stage pwWind)
	{
		initGridPane();
		txtRegis();
		
	/*********************** Buttons ***************************************************************/
	
		Button btn_RegOK = new Button("OK");	
		HBox okBtn = new HBox(10);
		okBtn.setAlignment(Pos.BOTTOM_RIGHT);
		okBtn.getChildren().add(btn_RegOK);
		gridPane.add(okBtn, 0, 4);
		
		btn_RegOK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event)
			{
				// Wenn login korrekt nächste Scene anzeigen. Datenbank Abfrage!!!!
            	stage = new Stage();
            	//Starten des nächsten Fensters
            	streamWindow strWin = new streamWindow();
            	strWin.start(stage);
            	
				System.out.println("OK Button");
		
			}
		});
/**			nicht nötig ???!!!
		Button btn_RegABB = new Button("Abbruch");
		HBox abbBtn = new HBox(10);
		abbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		abbBtn.getChildren().add(btn_RegABB);
		gridPane.add(abbBtn, 1, 4);
		
		btn_RegABB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0)
			{
				System.out.println("Abbruch Button");
			}
		});	
*/
		Button btn_reg = new Button("Registrierung");
		HBox regBtn = new HBox(10);
		regBtn.setAlignment(Pos.BOTTOM_RIGHT);
		regBtn.getChildren().add(btn_reg);
		gridPane.add(regBtn, 1, 4);
		
		btn_reg.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event)
			{   stage = new Stage();
		        //Starten des nächsten Fensters
		       	registrationWindow regWin = new registrationWindow();
		       	regWin.start(stage);
				System.out.println("Registrierung Button");
			}

		});
		
	/*********************** Fenster Eigenschaften *************************************************/	
		pwWind.setTitle("Login");	
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        pwWind.setScene(new Scene(root, 340, 220));
        root.getStylesheets().add("myStyle.css");
        pwWind.show();
    /***********************************************************************************************/

	}
	
	private void txtRegis()
	{
		Label regis_text = new Label("Login");
		regis_text.getStyleClass().add("txt_Login");
		gridPane.add(regis_text, 0, 0, 2, 1);
		
		Label userName = new Label("Name:");
		gridPane.add(userName, 0, 1);
		
		TextField userTextField = new TextField();
		gridPane.add(userTextField, 1, 1);
		
		Label pw = new Label("Password:");
		gridPane.add(pw, 0, 2);
		
		// text field to show password as unmasked
		final TextField pwTextField = new TextField();
		gridPane.add(pwTextField, 1, 2);
		
		// Set initial state
		pwTextField.setManaged(false);
		pwTextField.setVisible(false);

		// Actual password field
		final PasswordField passwordField = new PasswordField();
		gridPane.add(passwordField, 1, 2);

		CheckBox checkBox = new CheckBox("Show/Hide");
		gridPane.add(checkBox, 0, 3);

		// Bind properties. Toggle textField and passwordField
		// visibility and managability properties mutually when checkbox's state
		// is changed.
		// Because we want to display only one component (textField or
		// passwordField)
		// on the scene at a time.
		pwTextField.managedProperty().bind(checkBox.selectedProperty());
		pwTextField.visibleProperty().bind(checkBox.selectedProperty());

		passwordField.managedProperty().bind(checkBox.selectedProperty().not());
		passwordField.visibleProperty().bind(checkBox.selectedProperty().not());

		// Bind the textField and passwordField text values bidirectionally.
		pwTextField.textProperty().bindBidirectional(
				passwordField.textProperty());
			
	}


    private void initGridPane()
    {
    	gridPane = new GridPane();
    	gridPane.setAlignment(Pos.CENTER);
    	gridPane.setHgap(10);
    	gridPane.setVgap(10);
    	gridPane.setPadding(new Insets(25, 25, 25, 25));
    }
    
}
