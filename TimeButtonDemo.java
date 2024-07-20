import javafx.scene.text.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.Calendar;

import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import javafx.scene.input.KeyCode;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Date;

public class TimeButtonDemo extends Application {

  
  protected BorderPane getPane() {
    
    BorderPane pane = new BorderPane(); // pane for containing buttons and clock  
  
    HBox paneForButtons = new HBox(50); // pane for containing buttons    
     ImageView usa = new ImageView(new Image("usa.jpg"));
     ImageView eu = new ImageView(new Image("eu.jpg"));

     usa.setFitWidth(100);
     usa.setPreserveRatio(true);
     eu.setFitWidth(100);
     eu.setPreserveRatio(true);
  
    // write code for buttons 
      Button bt12 = new Button("12 hr",usa);
      Button bt24 = new Button("24 hr", eu);
      paneForButtons.getChildren().addAll(bt12,bt24);
      paneForButtons.setAlignment(Pos.CENTER);
      paneForButtons.setStyle("-fx-border-color: green");
      pane.setBottom(paneForButtons);  
      Text clock = DigitalClock.DigiClock();
    //DigitalClock clock = new DigitalClock();  // clock to be added to pane
    pane.setCenter(clock);
    
    // handle button clicks with lambdas
      bt12.setOnAction(e -> {
        System.out.println("chum is fum");
            DigitalClock.changeFormat12();
      });
      bt24.setOnAction(e -> {
          DigitalClock.changeFormat24();
          
      }); 
      pane.setOnKeyPressed(e -> { 
        switch (e.getCode()){
          case UP: clock.setFill(Color.RED); break;
          case DOWN: clock.setFill(Color.CYAN); break;
          case ENTER: clock.setFill(Color.BLACK); break;

          default: break;
        }
        });
      return pane;
      };  
         
    // handle keyboard presses with lambdas
    
          
  
  
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(getPane(),250, 150);
    primaryStage.setTitle("ClockApplication"); // Set the stage title
    
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
public static void main(String[] args) {
    launch(args);
  }
}

class DigitalClock extends Label {

    private static  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static Timeline animation;
    private static Calendar time;
    
    public static Text DigiClock () {
      
        // get time and set text with lambda
        //super();
        time = Calendar.getInstance();
        //Date date = time.getTime();
         Text text = new Text();
         text.setText(dateFormat.format(time.getTime()));
        //this.getChildren().add(text);
        //this.setText(dateFormat.format(new Date()));

        // change text font here



        



        
        //this.setFont(new Font(30));
       // this.setFont(Font.font("Arial",30));
       text.setFont(Font.font("Arial",100));
       //this.setTextFill(Color.RED);
       ///scene.setOnKeyPressed(e -> { 
         //switch (e.getCode()){
           //case UP: text.setFill(Color.RED); break;
           //case DOWN: text.setFill(Color.CYAN); break;
           //case ENTER: text.setFill(Color.BLACK); break;

          // default: break;
         //}
         //});

        // set animation here
        EventHandler<ActionEvent> eventHandler = e ->{
                Date date = new Date();
                text.setText(dateFormat.format(date));
        };
        animation = new Timeline(new KeyFrame(Duration.seconds(1), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        return text;
       }



    
    
    public static void changeFormat24(){
        // write code here for changing to 24 hour clock
         dateFormat = new SimpleDateFormat("HH:mm:ss ");
    
     }
    
    public static void changeFormat12(){
        // write code here for changing to 12 hour clock
        dateFormat = new SimpleDateFormat("hh:mm:ss a");
    } 
              
}

 
