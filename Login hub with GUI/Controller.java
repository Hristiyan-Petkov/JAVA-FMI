package Registrationform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPass;

    @FXML
    private Label lblConfPass;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtConfPass;

    @FXML
    private Label lblUsernameAlert;

    @FXML
    private Label lblPhoneAlert;

    @FXML
    private Label lblEmailAlert;

    @FXML
    private Label lblPassAlert;

    @FXML
    private Label lblConfPassAlert;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnLognOnActon(ActionEvent event) {
        if (!isUsernameValid()) {
            lblUsernameAlert.setText("Invalid username");
        } else {
            lblUsernameAlert.setText("");
        }

        if (!isPhoneValid()) {
            lblPhoneAlert.setText("Invalid phone number");
        } else {
            lblPhoneAlert.setText("");
        }

        if (!isEmailValid()) {
            lblEmailAlert.setText("Invalid email address");
        } else {
            lblEmailAlert.setText("");
        }


        if (!isConfirmationPassValid()) {
            lblConfPassAlert.setText("Invalid confirmation password, the two passwords should be identical");
        } else {
            lblConfPassAlert.setText("");
        }


    }

    private boolean isUsernameValid() {
        boolean usernameValid = txtUsername.getText().matches("[a-zA-Z]{2,200}");
        return usernameValid;
    }

    private boolean isPhoneValid() {
        boolean phoneValid = txtPhone.getText().matches("^\\([0-9]{4}\\)\\([0-9]{7}\\)$");
        return phoneValid;
    }

    private boolean isEmailValid() {
        boolean emailValid = txtEmail.getText().matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+");
        return emailValid;
    }

    private boolean isConfirmationPassValid() {
        boolean passValid = txtPass.getText().matches(txtConfPass.getText());
        return passValid;
    }

    @FXML
    void initialize() {
        assert lblUsername != null : "fx:id=\"lblUsername\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblPhone != null : "fx:id=\"lblPhone\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblPass != null : "fx:id=\"lblPass\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblConfPass != null : "fx:id=\"lblConfPass\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtPass != null : "fx:id=\"txtPass\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtConfPass != null : "fx:id=\"txtConfPass\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblUsernameAlert != null : "fx:id=\"lblUsernameAlert\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblPhoneAlert != null : "fx:id=\"lblPhoneAlert\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblEmailAlert != null : "fx:id=\"lblEmailAlert\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblPassAlert != null : "fx:id=\"lblPassAlert\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblConfPassAlert != null : "fx:id=\"lblConfPassAlert\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'sample.fxml'.";

    }
}


