package com.example.demo.dto;

public class DietaDto {
    public String alimento;
    public int    carboidratos;
    public int    kcalCarboidratos;
    public int    proteinas;
    public int    kcalProteinas;
    public int    grasas;
    public int    kcalGrasas;
    public int    kcalAlimento;

    public DietaDto() {
    }

    public DietaDto(String alimento, int carboidratos, int kcalCarboidratos, int proteinas, int kcalProteinas, int grasas, int kcalGrasas, int kcalAlimento) {
        this.alimento = alimento;
        this.carboidratos = carboidratos;
        this.kcalCarboidratos = kcalCarboidratos;
        this.proteinas = proteinas;
        this.kcalProteinas = kcalProteinas;
        this.grasas = grasas;
        this.kcalGrasas = kcalGrasas;
        this.kcalAlimento = kcalAlimento;
    }

}
