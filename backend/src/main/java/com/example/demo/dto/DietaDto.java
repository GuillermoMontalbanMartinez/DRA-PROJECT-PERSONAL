package com.example.demo.dto;

public class DietaDto {
    public String  alimento;
    public Double carboidratos;
    public Double kcalCarboidratos;
    public Double proteinas;
    public Double kcalProteinas;
    public Double grasas;
    public Double kcalGrasas;
    public Double kcalAlimento;

    public DietaDto() {
    }

    public DietaDto(String alimento, Double carboidratos, Double kcalCarboidratos, Double proteinas, Double kcalProteinas, Double grasas, Double kcalGrasas, Double kcalAlimento) {
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
