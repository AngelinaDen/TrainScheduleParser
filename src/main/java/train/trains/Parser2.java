package train.trains;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser2 {
	public static void getSsylka (String url ) throws IOException {
		Document page = Jsoup.parse(new URL(url), 10000);
		int count = 1;
		
		Element table = page.select("tbody").first();
		Elements rows = table.select("td");
		for(Element row : rows ) {
			if (count == 1) { // если сейчас ячейка 1
				System.out.println("Станция = " + row.text()); // вывести станцию
				}
			if (count == 2) { // если сейчас ячейка 2
				if (row.text().equals("")) {
					System.out.println("Прибытие = -");
				}
				else {
				System.out.println("Прибытие = " + row.text()); // вывести прибытие
					}
				}
			if (count == 3) { // если сейчас ячейка 3
				if (row.text().equals("")) {
					System.out.println("Стоянка = -");
				}
				else {
				System.out.println("Стоянка = " + row.text()); // вывести стоянку
					}
				}
			if (count == 4) { // если сейчас ячейка 4
				if (row.text().equals("")) {
					System.out.println("Отправление = -");
				}
				else {
				System.out.println("Отправление = " + row.text()); // вывести отправление
					}
				}
			if (count == 5) { // если сейчас ячейка 5
				if (row.text().equals("")) {
					System.out.println("В пути = -");
				}
				else {
				System.out.println("В пути = " + row.text()); // вывести в пути
					}
				System.out.println("————————");
				}
			
			
				count++; // счетчик увеличивается на 1
				
			if (count == 6) { // если сейчас ячейка шестая
				count=1; // 
				}	
		}
	}
}

