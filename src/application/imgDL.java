package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class imgDL {
	
	public int imgdownload(String wtUrl, String dirpath) {
		try {

			Document Page = Jsoup.connect(wtUrl).get();
			Elements imgUrl = Page.select(".wt_viewer > img");
			File file1 = new File(dirpath+"\\"+ SampleController.eptitle);
			file1.mkdir();
			File file2 = new File(file1.getPath()+"\\"+ SampleController.epnum);
			file2.mkdir();
			
			for (int i = 0; i < imgUrl.size(); i++) {
				System.out.println(imgUrl.get(i).attr("src"));
				String src = imgUrl.get(i).attr("src");
				URL url = new URL(src);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Referer", src);
				String filePath;
				if (i < 9) {
					filePath = file2.getPath() + "\\" + "00" + (i + 1) + ".jpg";
				} else if (i >= 9 && i < 99) {
					filePath = file2.getPath() + "\\" + "0" + (i + 1) + ".jpg";
				} else {
					filePath = file2.getPath() + "\\" + (i + 1) + ".jpg";
				}
				BufferedImage img = ImageIO.read(conn.getInputStream());
				FileOutputStream out = new FileOutputStream(filePath);
				ImageIO.write(img, "jpg", out);
			}

		} catch (Exception e) {

			e.printStackTrace();
			return 1;
		}
		return 0;
		
	}

}
