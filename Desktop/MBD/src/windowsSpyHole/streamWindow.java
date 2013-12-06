package windowsSpyHole;

import windowsSpyHole.dataWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class streamWindow {
	
	private GridPane gridPane;
	private Stage stage;
	private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	
	//private static final String MEDIA_URL = "http://192.168.178.27:8080/video/mjpg.cgi";
    private static String arg1;
	
    public void start(Stage primaryStage) {
    	
    	initGridPaneButtons();
    	
    //	TextArea txtOutput = new TextArea(); 	
    //	txtOutput.getStyleClass().add("txt_Stream");
	//	gridPane.add(txtOutput, 0, 1);
    	
        primaryStage.setTitle("Stream");
        Button btn_1 = new Button("1");
		HBox btn1 = new HBox(10);
		btn1.setAlignment(Pos.BOTTOM_CENTER);
		btn1.getChildren().add(btn_1);
		gridPane.add(btn1, 5, 1);
        btn_1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
           /* 	stage = new Stage();
            	//Starten des n�chsten Fensters
            	StartWindow2 sw2 = new StartWindow2();
            	sw2.start(stage);
           */
            }
        });
        
        Button btn_data = new Button("Datenbank");
        HBox data_btn = new HBox(10);
        data_btn.setAlignment(Pos.BOTTOM_CENTER);
        data_btn.getChildren().add(btn_data);
		gridPane.add(data_btn, 5, 2);
		btn_data.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	stage = new Stage();
            	//Starten des n�chsten Fensters
            	dataWindow dataWin = new dataWindow();
            	dataWin.start(stage);
           
            }
        });
        
        Button btn_3 = new Button("3");
        HBox btn3 = new HBox(10);
        btn3.setAlignment(Pos.BOTTOM_CENTER);
        btn3.getChildren().add(btn_3);
		gridPane.add(btn3, 5, 3);
        btn_3.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
           /* 	stage = new Stage();
            	//Starten des n�chsten Fensters
            	StartWindow2 sw2 = new StartWindow2();
            	sw2.start(stage);
           */
            }
        });  

        // create media player
        Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        // create mediaView and add media player to the viewer
        MediaView mediaView = new MediaView(mediaPlayer);
       // ((Group)scene.getRoot()).getChildren().add(mediaView);
        gridPane.add(mediaView, 0, 0, 5, 35);
       
        StackPane root = new StackPane();
        root.getChildren().addAll(gridPane);
        primaryStage.setScene(new Scene(root, 750, 450));
        root.getStylesheets().add("myStyle.css");
        primaryStage.show();
   
	}
        
    private void initGridPaneButtons()
    {
    	gridPane = new GridPane();
    	gridPane.setAlignment(Pos.TOP_RIGHT);
    	gridPane.setHgap(30);
    	gridPane.setVgap(10);
    	gridPane.setPadding(new Insets(0, 25, 0, 25));
    }
    
	
}
