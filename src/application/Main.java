package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		
		BorderPane root = new BorderPane();
		
		GridPane left = new GridPane();
        left.setPadding(new Insets(10, 10, 10, 10));
        
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(10, 10, 10, 10));
        
        Label label1 = new Label("Ile par: ");
        label1.setPadding(new Insets(10, 10, 10, 10)); 
        TextField textfield1 = new TextField("");
        textfield1.setPrefSize(100,1);
        Button but1 = new Button("Go!");
        hbox1.getChildren().addAll(label1,textfield1,but1);
        left.add(hbox1, 0, 0);
        
        but1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {
            	textfield1.requestFocus();
            	textfield1.positionCaret(0);
            	Integer ile = Integer.parseInt(textfield1.getText());
            	
            	String[] tablicaLiczbZaprzyjaznionych = new String[5];
            	tablicaLiczbZaprzyjaznionych[0]="220 i 284";
            	tablicaLiczbZaprzyjaznionych[1]="1184 i 1210";
            	tablicaLiczbZaprzyjaznionych[2]="2620 i 2924";
            	tablicaLiczbZaprzyjaznionych[3]="5020 i 5564";
            	tablicaLiczbZaprzyjaznionych[4]="6232 i 6368";
            	
            	VBox vbox2 = new VBox();
            	vbox2.setPadding(new Insets(10, 10, 10, 10));
            	
            	TextArea textarea1 = new TextArea();
            	String text="";
            	            	
                for(int i=1;i<=ile;i++) {
                	text = text +i+". "+tablicaLiczbZaprzyjaznionych[i-1]+"\n";
                }
                textarea1.setText(text);
                
                vbox2.setPrefSize(200,200);
                
                vbox2.getChildren().add(textarea1);
                left.add(vbox2, 0,1);
            }
        });
        
        
        
        root.setLeft(left);
			
			Scene scene = new Scene(root,250,250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Liczby zaprzyjaznione");
			primaryStage.setScene(scene);
			primaryStage.show();
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
