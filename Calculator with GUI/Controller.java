package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller extends AnchorPane {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnDoubleZero;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMulti;

    @FXML
    private Button btnDiv;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnDelAll;

    @FXML
    private Button btnOff;

    @FXML
    private TextField txtResult;

    double firstNumber = 0;
    double secondNumber = 0;
    double result = 0;
    double rememberResult = 0;
    boolean floatingPointFlag = false;
    int functionCounter = 0;

    public Controller() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/sample/sample.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    void calculateAction(ActionEvent event) {
        if (event.getSource() == btnOne) {
            txtResult.appendText("1");
        }

        if (event.getSource() == btnTwo) {
            txtResult.appendText("2");
        }

        if (event.getSource() == btnThree) {
            txtResult.appendText("3");
        }

        if (event.getSource() == btnFour) {
            txtResult.appendText("4");
        }

        if (event.getSource() == btnFive) {
            txtResult.appendText("5");
        }

        if (event.getSource() == btnSix) {
            txtResult.appendText("6");
        }

        if (event.getSource() == btnSeven) {
            txtResult.appendText("7");
        }

        if (event.getSource() == btnEight) {
            txtResult.appendText("8");
        }

        if (event.getSource() == btnNine) {
            txtResult.appendText("9");
        }

        if (event.getSource() == btnZero) {
            txtResult.appendText("0");
        }

        if (event.getSource() == btnDoubleZero) {
            txtResult.appendText("00");
        }

        if (event.getSource() == btnPlus) {
            if(rememberResult != 0){
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 1;
            } else {
                firstNumber = Double.parseDouble(txtResult.getText());
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 1;
            }
        }

        if (event.getSource() == btnMinus) {
            if(rememberResult != 0){
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 2;
            } else {
                firstNumber = Double.parseDouble(txtResult.getText());
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 2;
            }
        }

        if (event.getSource() == btnMulti) {
            if(rememberResult != 0){
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 3;
            } else {
                firstNumber = Double.parseDouble(txtResult.getText());
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 3;
            }
        }

        if (event.getSource() == btnDiv) {
            if(rememberResult != 0){
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 4;
            } else {
                firstNumber = Double.parseDouble(txtResult.getText());
                txtResult.setText("");
                floatingPointFlag = false;
                functionCounter = 4;
            }
        }

        if (event.getSource() == btnEqual && functionCounter > 0) {
            if (rememberResult != 0){
                secondNumber = Double.parseDouble(txtResult.getText());
                switch (functionCounter){
                    case 1:
                        result = rememberResult + secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                    case 2:
                        result = rememberResult - secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                    case 3:
                        result = rememberResult * secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                    case 4:
                        result = rememberResult / secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                }
            }else {
                secondNumber = Double.parseDouble(txtResult.getText());
                switch (functionCounter) {
                    case 1:
                        result = firstNumber + secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                    case 2:
                        result = firstNumber - secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                    case 3:
                        result = firstNumber * secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                    case 4:
                        result = firstNumber / secondNumber;
                        txtResult.setText(String.valueOf(result));
                        rememberResult = result;
                        break;
                }
            }
            firstNumber = 0;
            secondNumber = 0;
            result = 0;
            floatingPointFlag = false;
            functionCounter = 0;
        }

        if (event.getSource() == btnDot) {
            if (floatingPointFlag == false) {
                txtResult.appendText(".");
                floatingPointFlag = true;
            }
        }

        if (event.getSource() == btnDel) {
            txtResult.setText("");
            floatingPointFlag = false;
        }

        if (event.getSource() == btnDelAll) {
            txtResult.setText("");
            firstNumber = 0;
            secondNumber = 0;
            result = 0;
            rememberResult = 0;
            floatingPointFlag = false;
            functionCounter = 0;
        }

        if (event.getSource() == btnOff) {
            System.exit(0);
        }
    }

    @FXML
    void initialize() {
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDoubleZero != null : "fx:id=\"btnDoubleZero\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMulti != null : "fx:id=\"btnMulti\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDiv != null : "fx:id=\"btnDiv\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnEqual != null : "fx:id=\"btnEqual\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDot != null : "fx:id=\"btnDot\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDelAll != null : "fx:id=\"btnDelAll\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'sample.fxml'.";

    }
}

