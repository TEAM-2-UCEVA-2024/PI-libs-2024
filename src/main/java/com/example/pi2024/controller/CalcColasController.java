package com.example.pi2024.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/calc") //por si quieren modificar la URL
public class CalcColasController {

        @GetMapping("/{llegada}/{servicio}/{clientes}")
        public List<Double> calculadora(@PathVariable double llegada, @PathVariable double servicio, @PathVariable double clientes){
            List<Double> listDeValores = new ArrayList<Double>();
            //Calcular Probabilidad de hallar máximo 0 clientes en la cola (Pn)
            listDeValores.add((1-(llegada/servicio))*Math.pow((llegada/servicio), clientes));
            //Probabilidad de hallar el sistema ocupado (ρ)
            listDeValores.add(llegada/servicio);
            //El número esperado de clientes en el sistema (L)
            listDeValores.add(llegada/(servicio-llegada));
            //El número esperado de clientes en la cola (Lq)
            listDeValores.add(Math.pow(llegada, 2)/(servicio*(servicio-llegada)));
            //El tiempo promedio esperado en el sistema por los clientes (W)
            listDeValores.add(1/(servicio-llegada));
            //El tiempo esperado en la cola por los clientes (Wq)
            listDeValores.add(listDeValores.get(3)/llegada);
            return listDeValores;
        }
}
