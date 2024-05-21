package com.example.pi2024.controller;

import com.example.pi2024.model.entities.NewtonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/analisis")
public class NewtonCalcRestController {

    ArrayList<Float> devConstantes = new ArrayList<>();//crece dependiendo de las contantes
    ArrayList<Integer> divexponentes = new ArrayList<>();
    List<Float> listaDeResultados = new ArrayList<>();
    List<Float> listaDeErrores = new ArrayList<>();
    int cont; //el contador de las operaciones
    float errorCalc; //pal error de la calculaculadora xd

    @PostMapping("/newtoncal")
    public ResponseEntity<List<List<Float>>> calcularNewton(@RequestBody NewtonRequest request){
        List<List<Float>> resultados = new ArrayList<>();
        cont = 0;
        errorCalc = 100;

        float [] constantes = request.getConstantes(); //y si el exponente es 0?
        int [] exponentes = request.getExponentes();
        int tamPolinomio = request.getTamPolinomio();

        /*--------- PARTE DONDE SE DERIVA --------*/
        switch (tamPolinomio){

            case 1: //se ve como f(x) = ax + b. donde a y b son constantes
                obtenerValores(constantes, exponentes, 1);
                obtenerResultados(constantes, exponentes, request.getXsubcero(), request.getError(), 1, 0);
                break;
            case 2: //se ve como f(x) = ax^2 + bx + c. donde a, b, c son constantes
                obtenerValores(constantes, exponentes, 2);
                obtenerResultados(constantes, exponentes, request.getXsubcero(), request.getError(), 2, 1);
                break;
            case 3: //se ve como f(x) = ax^3 + bx^2 + cx + d. donde a, b, c, d son constantes
                obtenerValores(constantes, exponentes, 3);
                obtenerResultados(constantes, exponentes, request.getXsubcero(), request.getError(), 3, 2);
                break;
            case 4: //se ve como f(x) = ax^4 + bx^3 + cx^2 + dx + e. donde a, b, c, d, e son constantes
                obtenerResultados(constantes, exponentes, request.getXsubcero(), request.getError(), 4, 3);
                obtenerValores(constantes, exponentes, 4);
                break;
            default:
        }
        /*--------- PARTE DONDE ESTÁ EL BUCLE Y GUARDAR LOS RESULTADOS --------*/
        resultados.add(listaDeResultados);
        resultados.add(listaDeErrores);
        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }

    public void obtenerValores(float [] constantes, int [] exponentes, int cont){
        for(int i = 0; i < cont; i++){
            devConstantes.add(constantes[i] * exponentes[i]);
            if (exponentes[i] != 0) {
                divexponentes.add(exponentes[i]-1);
            }else{
                divexponentes.add(exponentes[i]);
            }
        }
        devConstantes.add(0F);
    }

    public float sumarNumerador(float [] constantes, int [] exponentes, float xsubcero, int cont){
        float acumulador = 0;
        for (int i = 0; i < cont; i++) {
            acumulador = acumulador + (float) (constantes[i]*Math.pow(xsubcero, exponentes[i]));
        }
        acumulador = acumulador + constantes[cont];
        return acumulador;
    }

    public float sumarDenominador(ArrayList<Float> constantes, ArrayList<Integer> exponentes, float xsubcero, int cont){
        float acumulador = 0;
        for (int i = 0; i < cont; i++) {
            acumulador = acumulador + (float) (constantes.get(i) *Math.pow(xsubcero, exponentes.get(i)));
        }
        acumulador = acumulador + constantes.get(cont);
        return acumulador;
    }

    public void obtenerResultados(float [] constantes, int [] exponentes, float xsubcero, float error, int contNum, int contDen){
        do {
            listaDeResultados.add(xsubcero - sumarNumerador(constantes, exponentes, xsubcero, contNum)/sumarDenominador(devConstantes, divexponentes, xsubcero, contDen));
            cont++;
            xsubcero = listaDeResultados.get(cont-1);
            if (cont >= 2) {
                listaDeErrores.add(Math.abs((listaDeResultados.get(cont-1)-listaDeResultados.get(cont-2))/listaDeResultados.get(cont-1)));
                errorCalc = listaDeErrores.get(cont-2);
            }
        } while (errorCalc != 0 && errorCalc > error);
    }
}