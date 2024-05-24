package com.example.pi2024.controller;

import com.example.pi2024.lib.io.CalculadoraColas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController//por si quieren modificar la URL
public class CalcColasController {

    static {

        System.loadLibrary("calculatorcolas");
    }

    CalculadoraColas javaCal = new CalculadoraColas();

    @GetMapping("/iocalculator/{num1}/{num2}/{num3}")
    public List<Double> calcularOva(@PathVariable double num1, @PathVariable double num2, @PathVariable int num3) {
        List <Double> listaIO = new ArrayList<>();
        listaIO.add(javaCal.calculasls(num1,num2));
        listaIO.add(javaCal.calcularlq(num1,num2));
        listaIO.add(javaCal.calcularws(num1,num2));
        listaIO.add(javaCal.calcularwq(num1,num2));
        listaIO.add(javaCal.calcularp(num1,num2));
        listaIO.add(javaCal.calcularp0(num1,num2));
        listaIO.add(javaCal.calcularpn(num1,num2,num3));

        return listaIO;

    }
}
