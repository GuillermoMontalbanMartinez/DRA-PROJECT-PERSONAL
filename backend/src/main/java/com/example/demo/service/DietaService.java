package com.example.demo.service;

import com.example.demo.dto.DietaDto;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

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
            // Conexión con la web
            Document webPage = Jsoup.connect("https://es.wikipedia.org/wiki/Dieta_(alimentación)").get();
            // Seleccion del elemento tbody de la capa con class sortable wikitable jquery-tablesorter
            Element tbody = webPage.getElementsByClass("sortable wikitable jquery-tablesorter").get(0);
            // Selección de los elementos hijos de la etiqueta tbody que empiezan en la posición 3.
            List<Element> rows = tbody.children().subList(3, tbody.children().size());

            // Recorrer los elementos hijos de la etiqueta tbody, es decir, cada alimento
            for (Element row : rows) {
                Elements ths = row.getElementsByTag("th");
                if (ths.isEmpty())
                    continue;
                // Selección de los elementos th que contiene el nombre del alimento
                String alimento = ths.get(0).text();
                Elements tds = row.getElementsByTag("td");
          
                // Selección de los elementos td que contiene los valores de los nutrientes
                Integer carbohidratos = toIntOrNull(tds.get(1).text());
                Integer kcalCarbohidratos = toIntOrNull(tds.get(2).text());
                Integer proteinas = toIntOrNull(tds.get(3).text());
                Integer kcalProteinas = toIntOrNull(tds.get(4).text());
                Integer grasas = toIntOrNull(tds.get(5).text());
                Integer kcalGrasas = toIntOrNull(tds.get(6).text());
                Integer kcalAlimento = toIntOrNull(tds.get(7).text());
        
                dietaData.add(new DietaDto(alimento, carbohidratos, kcalCarbohidratos, proteinas, kcalProteinas, grasas, kcalGrasas, kcalAlimento));
            }

            return dietaData;
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
