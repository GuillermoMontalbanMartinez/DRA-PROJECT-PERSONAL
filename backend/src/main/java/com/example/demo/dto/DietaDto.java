package com.example.demo.dto;

public class DietaDto {
    public String  alimento;
    public Integer carboidratos;
    public Integer kcalCarboidratos;
    public Integer proteinas;
    public Integer kcalProteinas;
    public Integer grasas;
    public Integer kcalGrasas;
    public Integer kcalAlimento;

    public DietaDto() {
    }

    public DietaDto(String alimento, Integer carboidratos, Integer kcalCarboidratos, Integer proteinas, Integer kcalProteinas, Integer grasas, Integer kcalGrasas, Integer kcalAlimento) {
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
