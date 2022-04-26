package com.example.demo.service;

import com.example.demo.dto.DietaDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

// Anotación del componente
@Component("dietaService")
public class DietaService {

    public List<DietaDto> retrieveDieta() {
        List<DietaDto> dietaData = new ArrayList<>();

        try {
            // Conexión con la página web
            Document doc = Jsoup.connect("https://es.wikipedia.org/wiki/Dieta_(alimentación)").get();
            // Selección del elemento tbody de la tabla Alimentos y energía de la web
            Element tbody = webPage.getElementById("mw-content-text").getElementsByTag("tbody").get(0);
            // Selección de los elementos hijos de la etiqueta tbody que empiezan en la posición 3.
            List<Element> rows = tbody.children().subList(3, tbody.children().size());

            for (Element row : rows) {
                Elements ths = row.getElementsByTag("th");
                if(this.isEmpty()) {
                    continue;
                }
                // Selección de los elementos th que contiene el nombe del alimento
                String alimento = ths.get(0).text();
                Element tds = row.getElementById("td");

                // Selección de los elementos td que contiene los valores de los nutrientes
                Integer carboidratos = Integer.parseInt(tds.getElementsByTag("td").get(0).text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    private Integer toIntOrNull(String replace) {
        try {
            return Integer.parseInt(replace.replace(",", ""));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
