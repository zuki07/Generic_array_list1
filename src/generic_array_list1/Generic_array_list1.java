

/*TABLE OF CONTENTS
1. PRIVATE VARIABLES
2. SETUP TEXT FIELD
3. SETUP DROPSHADOW FOR BUTTON
4. SETUP INNER SHADOW FOR BUTTON      
5. SETUP BUTTONS
6. SETUP LABELS
7. SETUP HBOX        
8. SETUP VBOX        
9. SETUP KEY ENTER EVENT       
10. SETUP DOUBLE BUTTON LAMBDA EVENT        
11. SETUP INTEGER BUTTON LAMBDA EVENT        
12. SETUP FLOAT BUTTON LAMBDA EVENT        
13. SETUP ADD BUTTON LAMBDA EVENT
14. SETUP CALCULATE BUTTON LAMBDA EVENT         
15. SETUP CLEAR BUTTON LAMBDA EVENT         
16. ERROR MESSAGE METHOD         
17. TEST NUMBER VALUE METHOD 
*/

package generic_array_list1;

import java.util.ArrayList;                                                                    
import javafx.application.Application;                                                         
import javafx.geometry.Insets;                                                                  
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;


public class Generic_array_list1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
//                    1. PRIVATE VARIABLES
    private boolean on_off=false;                                                   //int, double and float button either on or off
    private String number_type="";                                                  //string to check if a number is int, double or float
    private ArrayList array_list;                                                   //initiate array list
    private MyList<Number> myList;                                                  //initiate mylist class as number
    private TextField array_input;                                                  //initiate textfield
    private Label array_input_label;                                                //initiate label as array list output
    
    @Override
    public void start(Stage primaryStage) {
        
        String empty_array_list="--Empty Array List--";
        
//                                2.SETUP TEXT FIELD
        array_input=new TextField();
        array_input.setAlignment(Pos.CENTER);
        array_input.setMaxWidth(250);
        array_input.setPromptText("--Click Here to Type--");
        array_input.setFocusTraversable(false);

//                            3. SETUP DROPSHADOW FOR BUTTON
        DropShadow drop_shadow=new DropShadow();
        drop_shadow.setOffsetX(10);
        drop_shadow.setOffsetY(10);
        
//                            4. SETUP INNER SHADOW FOR BUTTON
        InnerShadow inner_shadow=new InnerShadow();
        inner_shadow.setOffsetX(8);
        inner_shadow.setOffsetY(8);
        
//                               5. SETUP BUTTONS
        Button double_btn=new Button("DOUBLE");
        Button int_btn=new Button("INTEGER");
        Button float_btn=new Button("FLOAT");
        Button add_string_btn=new Button("ADD");
        Button calculate_btn = new Button("CALCULATE");
        Button clear_btn=new Button("CLEAR");
        
        double_btn.setEffect(drop_shadow);                                          //set drop shadow effect for start of application
        int_btn.setEffect(drop_shadow);                                             //set drop shadow effect for start of application
        float_btn.setEffect(drop_shadow);                                           //set drop shadow effect for start of application
        
//                                6. SETUP LABELS
        array_input_label=new Label(empty_array_list);
        array_input_label.setMaxWidth(400);
        array_input_label.setAlignment(Pos.CENTER);
        
        Label results_label=new Label();
        results_label.setAlignment(Pos.CENTER);
        results_label.setPadding(new Insets(10));

        
//                                7. SETUP HBOX
        HBox hbox=new HBox(double_btn, int_btn, float_btn);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(15);
        
//                               8. SETUP VBOX
        VBox vbox=new VBox(hbox,array_input, add_string_btn, array_input_label, 
                            calculate_btn, results_label, clear_btn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        Scene scene = new Scene(vbox, 600, 600);
        scene.getStylesheets().add("styles.css");
        
//                                9. SETUP KEY ENTER EVENT
        scene.setOnKeyReleased((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)){
                if (array_input.getText().equals("")){                                  //if text field is empty, error
                    errorMessage("Type in Something");                                  //call error method and pass in a string
                }
                else if(on_off==false){                                                 // if int, double, or float button not pressed error
                    errorMessage("Select ArrayList Type");                              //call error method and pass in a string
                }
                else{
                    testNumberValue();                                                  //testNumberValue method to see if input is int, number, or float
                    array_input.clear();                                                //clear text field
                    array_input_label.setText(myList.printAsString());                  //set label to array list
                    array_input_label.setStyle("");                                     //reset styling from style sheet
                    array_input_label.setMaxWidth(400);                                 //reset max width to 400
                }    
            }
        });
        
//                                    10. SETUP DOUBLE BUTTON LAMBDA EVENT
        double_btn.setOnAction(event ->{
            array_list=new ArrayList<Double>();                                         //define array_list as a double
            number_type="double";                                                       //set number_type to double
            double_btn.setEffect(inner_shadow);                                         //set double button to inner shadow for button pressed effect
            int_btn.setEffect(drop_shadow);                                             //set int button to drop shadow incase it is pressed
            float_btn.setEffect(drop_shadow);                                           //set float button to drop shadow incase it is pressed
            on_off=true;                                                                //set on_off to true
            array_input_label.setText(empty_array_list);                                //set label to empty array list
            array_input_label.setStyle("");                                             //reset styling from style sheet
        });
        
//                                    11. SETUP INTEGER BUTTON LAMBDA EVENT
        int_btn.setOnAction(event ->{
            array_list=new ArrayList<Integer>();                                        //define array_list as a integer
            number_type="int";                                                          //set number_type to integer
            double_btn.setEffect(drop_shadow);                                          //set double button to drop shadow incase it is pressed
            int_btn.setEffect(inner_shadow);                                            //set integer button to inner shadow for button pressed effect
            float_btn.setEffect(drop_shadow);                                           //set float button to drop shadow incase it is pressed
            on_off=true;                                                                //set on_off to true
            array_input_label.setText(empty_array_list);                                //set label to empty array list
            array_input_label.setStyle("");                                             //reset styling from style sheet
        });
        
//                                   12. SETUP FLOAT BUTTON LAMBDA EVENT
        float_btn.setOnAction(event ->{
            array_list=new ArrayList<Float>();                                          //define array_list as a float
            number_type="float";                                                        //set number_type to float
            double_btn.setEffect(drop_shadow);                                          //set double button to drop shadow incase it is pressed
            int_btn.setEffect(drop_shadow);                                             //set integer button to drop shadow incase it is pressed
            float_btn.setEffect(inner_shadow);                                          //set float button to inner shadow for button pressed effect
            on_off=true;                                                                //set on_off to true
            array_input_label.setText(empty_array_list);                                //set label to empty array list
            array_input_label.setStyle("");                                             //reset styling from style sheet
        });
        
//                                    13. SETUP ADD BUTTON LAMBDA EVENT
        add_string_btn.setOnAction(event ->{
            if (array_input.getText().equals("")){                                      //if text field is empty, error
                    errorMessage("Type in Something");                                  //call error method and pass in a string
                    array_input.requestFocus();                                         //reset focus of text field to type again
                }
                else if(on_off==false){                                                 //error if on_off is false
                    errorMessage("Select ArrayList Type");                              //call error method and pass in a string
                }
                else{
                    testNumberValue();                                                  //testNumberValue method to see if input is int, number, or float
                    array_input.clear();                                                //clear text field
                    array_input_label.setText(myList.printAsString());                  //set label to array list
                    array_input_label.setStyle("");                                     //reset styling from style sheet
                    array_input.requestFocus();                                         //reset focus of text field to type again
                    array_input_label.setMaxWidth(400);                                 //reset max width to 400
                } 
            
        });
        
//                                    14. SETUP CALCULATE BUTTON LAMBDA EVENT
        calculate_btn.setOnAction(event ->{
            Number largest_result=myList.largest();                                     //use largest method in myList class to find largest value
            Number smallest_result=myList.smallest();                                   //use smallest method in myList class to find smallest value
            Number total_result=myList.total();                                         //use total method in myList class to find total value
            Number average_result=myList.average();                                     //use average method in myList class to find average value
            array_input_label.setStyle("");                                             //clear any errors
            array_input_label.setText(myList.printAsString());                          //clear any errors
            
            if (number_type.equals("int")){                                              //find if number_type is "int"
                results_label.setText(String.format("Largest: "+largest_result+"\n"+     //set results_label to a special string
                                        "Smallest: "+smallest_result+"\n"+
                                        "Total: "+total_result+"\n"+
                                        "Average: %.2f", average_result));
            }
            else{                                                                   
                results_label.setText(String.format("Largest: "+largest_result+"\n"+     //set results_label to a special string
                                        "Smallest: "+smallest_result+"\n"+
                                        "Total: %.3f\n"+
                                        "Average: %.3f", total_result, average_result));
            }
            results_label.setStyle("-fx-background-color: rgb(0,0,0);"+                  //set results_label background color 
                                    "-fx-opacity: .75;");                                //set results_label opacity
        });
        
//                                   15. SETUP CLEAR BUTTON LAMBDA EVENT
        clear_btn.setOnAction(event ->{
            array_input.clear();                                                    //clear text field
            results_label.setText("");                                              //clear label
            results_label.setStyle("");                                             //set to default style sheet
            array_input_label.setStyle("");                                         //set to default style sheet
            array_input_label.setText(empty_array_list);                            //reset prompt value for text field
            array_list.clear();                                                     //clear array_list
            on_off=false;                                                           //set on_off to false
            double_btn.setEffect(drop_shadow);                                      //reset button to drop shadow for unpressed effect
            int_btn.setEffect(drop_shadow);                                         //reset button to drop shadow for unpressed effect
            float_btn.setEffect(drop_shadow);                                       //reset button to drop shadow for unpressed effect
        });
    
        primaryStage.setTitle("Generic Array List");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
//                                    16. ERROR MESSAGE METHOD
    public void errorMessage(String text){
            array_input_label.setText(text);                                        //set label to string passed in
            array_input.requestFocus();                                             //set text field to stay active
            array_input_label.setStyle("-fx-background-color: red;"                 //set label background color to red and padding to 10px
                                        + "-fx-padding: 10px;");
            array_input_label.setMaxWidth(250);                                     //set max width to 250
            array_input.clear();                                                    //clear text field
    }
    
//                                    17. TEST NUMBER VALUE METHOD
    public void testNumberValue(){
        switch (number_type) {              
            case "double":                                                          //if number_type is "double", try or catch
                try {                                               
                    Double.valueOf(array_input.getText());                          //try if text field is a double value
                }
                catch (NumberFormatException e){
                    errorMessage(array_input.getText()+" is not an Double\n\tTry Again");   //if not a double value, do errorMessage method
                }
                array_list.add(Double.valueOf(array_input.getText()));                  //if try works, add value of text field to array list
                myList=new MyList<>(array_list);                                        //pass array_list to constructor in MyList class
                break;
            case "int":                                                             //if number_type is "int", try or catch
                try {                   
                    Integer.valueOf(array_input.getText());                         //try if text field is a int value
                }
                catch (NumberFormatException e){
                    errorMessage(array_input.getText()+" is not an Integer\n\tTry Again");  //if not a int value, do errorMessage method
                }   
                array_list.add(Integer.valueOf(array_input.getText()));                 //if try works, add value of text field to array list
                myList=new MyList<>(array_list);                                        //pass array_list to constructor in MyList class
                break;
            case "float":                                                           //if number_type is "float", try or catch
                try {
                    Float.valueOf(array_input.getText());                           //try if text field is a float value
                }
                catch (NumberFormatException e){
                    errorMessage(array_input.getText()+" is not an Float\n\tTry Again");    //if not a float value, do errorMessage method
                }
                array_list.add(Float.valueOf(array_input.getText()));                   //if try works, add value of text field to array list
                myList=new MyList<>(array_list);                                        //pass array_list to constructor in MyList class
                break;  
            default:
                errorMessage(array_input.getText()+" is not a Number\n\tTry Again");    //if not a double, integer or float, do errorMessage method
                break;
        }
    }

}
