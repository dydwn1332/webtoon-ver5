package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Comment implements Initializable{

    @FXML
    private WebView wb;
    static WebEngine we;
    @FXML
    private static Label output;
    static void test() {
    	we.load(SampleController.WtUrl.replace("webtoon/detail", "comment/comment"));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		we = wb.getEngine();		
	}
}
