package train.trains;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

	public class Parser {
		private static Document getPage() throws IOException {
			String url = "https://poezdato.net/raspisanie-po-stancyi/samara/elektrichki/";
			Document page = Jsoup.parse(new URL(url), 10000);
			return page;
		}
		
		public static void main(String[] args) throws Exception {
			Document page = getPage();
			int count = 1;
			//System.out.println("Номер Маршрут Прибытие Стоянка Отправление");
			Element table = page.select("tbody").first();
			Elements rows = table.select("td");
			for(Element row : rows ) {
				if (count == 2) { // если сейчас ячейка вторая
					System.out.println("________");
					System.out.println("НОВЫЙ ПОЕЗД: ");
					System.out.println("Номер = " + row.text()); // вывести номер
					Parser2.getSsylka("https://poezdato.net" + row.select("a").first().attr("href")); // получить ссылку
					
					}
				if (count == 3) { // если сейчас ячейка третья
					System.out.println("Маршрут = " + row.text()); // вывести маршрут
					
					}
				if (count == 4) { // если сейчас ячейка четвёртая
					if (row.text().equals("")) {
						System.out.println("Прибытие = -");
					}
					else {
					System.out.println("Прибытие = " + row.text()); // вывести прибытие
						}
					}
				if (count == 5) { // если сейчас ячейка пятая
					if (row.text().equals("")) {
						System.out.println("Стоянка = -");
					}
					else {
					System.out.println("Стоянка = " + row.text()); // вывести стоянку
						}
					}
				if (count == 6) { // если сейчас ячейка шестая
					if (row.text().equals("")) {
						System.out.println("Отправление = -");
					}
					else {
					System.out.println("Отправление = " + row.text()); // вывести отправление
						}
					}
				
					count++; // счетчик увеличивается на 1
					
				if (count == 9) { // если сейчас ячейка девятая
					count=1; // 
					}	
					
				}

		}
}