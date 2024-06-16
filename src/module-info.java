module webtoon {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jsoup;
	requires java.desktop;
	requires javafx.web;
	requires javafx.base;



	opens application to javafx.graphics, javafx.fxml;
}
