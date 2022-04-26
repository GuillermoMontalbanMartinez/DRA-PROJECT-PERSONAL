package com.example.demo.controller;

import com.example.demo.dto.DietaDto;
import com.example.demo.service.DietaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dieta")
public class DietaController {
    @Autowired
    // Inyección del servicio de la clase DietaService
    private DietaService dietaService;

    // Mapeo del endpoint /dieta
    @GetMapping("data")
    public ResponseEntity<List<DietaDto>> getDieta() {
        // Se llama al método retrieveDieta() del servicio
        List<DietaDto> dietaData = dietaService.retrieveDieta();
        // Se devuelve el resultado de la llamada al servicio
        return new ResponseEntity<>(dietaData, HttpStatus.OK);
    }
}
