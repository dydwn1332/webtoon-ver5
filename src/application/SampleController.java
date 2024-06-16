package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class SampleController implements Initializable {

	@FXML private Label Title;
	@FXML private Label output;
	@FXML private TextField InputUrl;
	@FXML private ListView<?> listView;
	@FXML private TextField dirpath;

	static String eptitle;
	static String epnum;
	static String seldir;
	static String WtUrl;

	@FXML private Stage primaryStage;
	@FXML private Button inputbutton;

	@FXML
	void input(ActionEvent event) { //확인
		int a = new imgDL().imgdownload(InputUrl.getText(), dirpath.getText());
		if (a == 0) {
			output.setText("다운로드 완료");
		} else {
			output.setText("오류발생!! 링크나 저장경로를 확인하시오");
		}

	}

	@FXML
	void selDir(ActionEvent event) { //저장경로 지정
		DirectoryChooser dir = new DirectoryChooser();
		File dirfile = dir.showDialog(primaryStage);
		dirpath.setText(dirfile.getPath());
		seldir = dirfile.getPath();
	}

	@FXML
	void Nextep(ActionEvent event) { //다음화
		Document Page;
		try {
			Page = Jsoup.connect(InputUrl.getText()).get();
			Elements Url = Page.select(".item").get(4).select("a");
			String nextUrl = "https://comic.naver.com" + Url.attr("href");
			if (Url.attr("href").isEmpty()) {
				output.setText("다음화가 없습니다.");
			} else {
				InputUrl.setText(nextUrl);
				output.setText(null);
			}
			System.out.println(nextUrl);
		} catch (Exception e) {
			output.setText("오류발생!! 링크나 저장경로를 확인하시오");
			e.printStackTrace();
		}

	}

	@FXML
    void Preep(ActionEvent event) { //이전화
    	Document Page;
		try {
			Page = Jsoup.connect(InputUrl.getText()).get();
			Elements Url = Page.select(".item").get(2).select("a");
	    	String preUrl = "https://comic.naver.com" + Url.attr("href");
	    	if(Url.attr("href").isEmpty()) {
	    		output.setText("이전화가 없습니다.");
	    	}
	    	else {
	    		InputUrl.setText(preUrl);
	    		output.setText(null);
	    	}
	    	System.out.println(preUrl);
		} catch (Exception e) {
			output.setText("오류발생!! 링크나 저장경로를 확인하시오");
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		InputUrl.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				try {
					Document Page = Jsoup.connect(InputUrl.getText()).get();
					Elements title1 = Page.select(".title");
					Elements title2 = Page.select(".view h3");
					Title.setText(title1.text() + " " + title2.text());
					eptitle = title1.text();
					epnum = title2.text();
					WtUrl = InputUrl.getText();
					Comment.test();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});

	}

}
