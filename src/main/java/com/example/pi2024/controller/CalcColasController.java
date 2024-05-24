package com.example.pi2024.controller;

import com.example.pi2024.lib.io.CalculadoraColas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calcularcolas")
public class CalcColasController {

    static {

        System.loadLibrary("calculatorcolas");
    }

    CalculadoraColas javaCal = new CalculadoraColas();

    @GetMapping("/iocalculator/{λ}/{μ}/{n}")
    public List<Double> calcularOva(@PathVariable double λ, @PathVariable double μ, @PathVariable int n) {
        List <Double> listaIO = new ArrayList<>();
        listaIO.add(javaCal.calculasls(λ,μ));
        listaIO.add(javaCal.calcularlq(λ,μ));
        listaIO.add(javaCal.calcularws(λ,μ));
        listaIO.add(javaCal.calcularwq(λ,μ));
        listaIO.add(javaCal.calcularp(λ,μ));
        listaIO.add(javaCal.calcularp0(λ,μ));
        listaIO.add(javaCal.calcularpn(λ,μ,n));

        return listaIO;

    }
}
