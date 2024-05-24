package com.example.pi2024.controller;

import com.example.pi2024.lib.newton.CalculadoraNewtonRaphon;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analisis")
public class NewtonCalcRestController {

    static {
        System.loadLibrary("newtonraphson");
    }

    @GetMapping("calnewton/{xo}/{errorweb}/{eleccion}")
    public float[][]  Prueba(@PathVariable float xo, @PathVariable float errorweb, @PathVariable int eleccion) {
        int cont = 0;
        float[] Xn = new float[8];
        float[] error = new float[8];
        float errorCalc = 100;
        float[][] matriz = new float[2][8];

        CalculadoraNewtonRaphon javaCal = new CalculadoraNewtonRaphon();

        do {
            Xn[cont] = javaCal.newton_raphson(eleccion, xo);
            cont++;
            if (cont >= 2) {
                error[cont - 2] = javaCal.error(Xn[cont - 1], Xn[cont - 2]);
                errorCalc = error[cont - 2];
            }
            xo = Xn[cont-1];

        } while (errorCalc != 0 && errorCalc > errorweb);

        System.out.println("Valores de Xn:");
        for (float valor : Xn) {
            System.out.printf("%.6f ", valor);
        }
        System.out.println("\nValores de error:");
        for (float e : error) {
            System.out.printf("%.6f ", e);
        }

        for (int i = 0; i < 8; i++) {
            matriz[0][i] = Xn[i]; // Primera fila
            matriz[1][i] = error[i]; // Segunda fila
        }
        return matriz;
    }

}