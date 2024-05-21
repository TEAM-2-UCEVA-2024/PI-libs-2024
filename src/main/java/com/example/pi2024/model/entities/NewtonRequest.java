package com.example.pi2024.model.entities;

public class NewtonRequest {
    float [] constantes;
    int [] exponentes;
    int xsubcero;
    float error;
    int tamPolinomio;

    public float[] getConstantes() {
        return constantes;
    }

    public int[] getExponentes() {
        return exponentes;
    }

    public int getXsubcero() {
        return xsubcero;
    }

    public float getError() {
        return error;
    }

    public int getTamPolinomio() {
        return tamPolinomio;
    }
}
