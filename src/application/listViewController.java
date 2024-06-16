package application;

import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class listViewController {
	
	@FXML private ListView<String> listview;
	@FXML private ImageView imageview;
	@FXML private Label diroutput;
	
	ObservableList<String> list = FXCollections.observableArrayList();
	@FXML
	void refresh(ActionEvent event) {
		list.clear();
		listview.getSelectionModel().clearSelection();
		imageview.setImage(null);
		String dir = SampleController.seldir + "\\" + SampleController.eptitle + "\\" + SampleController.epnum;
		diroutput.setText(dir);
		list.addAll(new File(dir).list());
		System.out.println(list);
		listview.setItems(list);
		
		listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> arg0, Object olditem, Object newitem) {
				String filePath = dir + "\\" + newitem;
				System.out.println(filePath);
				Image img = new Image(filePath);
				imageview.setImage(img);
			}
		});

	}

}