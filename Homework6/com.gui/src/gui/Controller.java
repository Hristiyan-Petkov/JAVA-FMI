package gui;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import providers.CipherGenerator;
import providers.Result;
import providers.Wrapper;
import services.Cipherable;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    private Button btnGenRand;

    @FXML
    private Button btnRandSub;

    @FXML
    private Button btnQuit;

    @FXML
    void btnGenRandOnAction(ActionEvent event) {
        int size =  Integer.parseInt(txtSize.getText());
        int seed = Integer.parseInt((txtSeed.getText()));

        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct((Cipherable)wrapper.makeFixedRandom(), seed);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Generate random subset A-Z");
        alert.setHeaderText("Count distinct characters out of " + wrapper.getSize());
        alert.setContentText("Chars: " + Arrays.toString(result.getChars()) + "\n" + "Result: " + result.getData());
        alert.showAndWait();
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnRandSubOnAction(ActionEvent event) {
        int size =  Integer.parseInt(txtSize.getText());
        int seed = Integer.parseInt((txtSeed.getText()));

        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct((Cipherable)wrapper.makeFixedSelection(), seed);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Random subsequence of letters A-Z");
        alert.setHeaderText("Count distinct characters out of " + wrapper.getSize());
        alert.setContentText("Chars: " + Arrays.toString(result.getChars()) + "\n" + "Result: " + result.getData());
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnGenRand != null : "fx:id=\"btnGenRand\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnRandSub != null : "fx:id=\"btnRandSub\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";

    }
}

