import javafx.application.Application;
import javafx.event.{ActionEvent, EventHandler};
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
// import javafx.scene.web.WebEngine;
// import javafx.scene.web.WebView;
import javafx.stage.Stage;

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {

  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setWidth(650)
    primaryStage.setHeight(500)
    val scene = new Scene(new Group())

    val root = new VBox();
    root.setPadding(new Insets(8, 8, 8, 8));
    root.setSpacing(5);
    root.setAlignment(Pos.BOTTOM_LEFT);

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)

    val htmlCode = new TextArea()
    htmlCode.setWrapText(true)

    // val browser = new WebView()
    // val webEngine = browser.getEngine()

    val scrollPane = new ScrollPane()
    scrollPane.getStyleClass().add("noborder-scroll-pane")
    scrollPane.setStyle("-fx-background-color: white")
    scrollPane.setContent(htmlCode)
    // scrollPane.setContent(browser);
    scrollPane.setFitToWidth(true)
    scrollPane.setPrefHeight(180)

    val showHTMLButton = new Button("Produce HTML Code")
    root.setAlignment(Pos.CENTER)
    showHTMLButton.setOnAction(new EventHandler[ActionEvent] {
      override def handle(event: ActionEvent): Unit = {
        htmlCode.setText(htmlEditor.getHtmlText())
        // webEngine.loadContent(htmlEditor.getHtmlText())
      }
    })

    root.getChildren().addAll(htmlEditor, showHTMLButton, scrollPane)
    scene.setRoot(root)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}
