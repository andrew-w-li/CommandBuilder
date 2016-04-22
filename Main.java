import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main class for default scene and loading of the program
 */
public class Main extends Application {
	Stage primeStage;
	Scene sceneBuild, sceneDefault, sceneLibrary;
	Button goBuild, goDefault, goLibrary;
	
	VBox vBoxAll = new VBox();
	HBox hBox_Logo_Button = new HBox();
	VBox vBox_Buttons = new VBox();
	
	Image buildImg = new Image(getClass().getResourceAsStream("new.png"));
	Image libImg = new Image(getClass().getResourceAsStream("library.png"));
	Image logo = new Image(getClass().getResourceAsStream("logo.png"));
	Image mainTut = new Image(getClass().getResourceAsStream("mainTut.png"));
	
	/**
	 * launch the program
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * UI for the default page user first sees once the program is loaded.
	 * Also, button action logic to switch scenes
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//this button will direct the user to the build command template page
		goBuild = new Button("Build a Command Page", new ImageView("new.png"));
		goBuild.setOnAction(e -> {
			VBox temp = new Builder().makeBuilder();
			temp.getChildren().add(goDefault);
			sceneBuild = new Scene(temp, 800, 600);
			primeStage.setScene(sceneBuild);
		});
		
		//this button will direct the user to the view library page
		goLibrary = new Button("View Command Library", new ImageView(libImg));
		goLibrary.setOnAction(e -> {
			VBox temp = new Library().makeLibrary();
			temp.getChildren().add(goDefault);
			sceneLibrary = new Scene(temp, 800, 600);
			primeStage.setScene(sceneLibrary);
		});
		
		//this button will return the user to the default page
		goDefault = new Button("Go Back");
		goDefault.setOnAction(e -> {
			primeStage.setScene(sceneDefault);
		});
		
		//Positioning widgets into boxes
		vBox_Buttons.getChildren().addAll(goBuild, goLibrary);
		vBox_Buttons.setSpacing(10);
		
		hBox_Logo_Button.getChildren().addAll(new ImageView(logo),vBox_Buttons);
		hBox_Logo_Button.setSpacing(10);
		
		vBoxAll.getChildren().addAll(hBox_Logo_Button, new ImageView(mainTut));
		vBoxAll.setSpacing(10);
		vBoxAll.setAlignment(Pos.CENTER);
		
		//setting the default scene
		sceneDefault = new Scene(vBoxAll, 800, 600);
		primeStage = primaryStage;
		primeStage.setTitle("CommandBuilder");
		primeStage.setScene(sceneDefault);
		primeStage.show();
	}//start
}

	