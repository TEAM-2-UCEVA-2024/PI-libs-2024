package com.example.pi2024.model.entities;

public class FIFORequest {
    int [] numPaginas;
    int numMarcos;

    public int[] getNumPaginas() {
        return numPaginas;
    }

    public int getNumMarcos() {
        return numMarcos;
    }

    public void setNumPaginas(int[] numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setNumMarcos(int numMarcos) {
        this.numMarcos = numMarcos;
    }
}
