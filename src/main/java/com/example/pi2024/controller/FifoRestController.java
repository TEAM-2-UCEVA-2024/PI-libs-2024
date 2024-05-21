package com.example.pi2024.controller;

import com.example.pi2024.model.entities.FIFORequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@RestController
public class FifoRestController {

    @PostMapping("/fifo")
    public ArrayList<ArrayList<Integer>> fifo(@RequestBody FIFORequest request) {

        int[] paginas = request.getNumPaginas();
        int marcos = request.getNumMarcos();

        int fallos = 0;

        Queue<Integer> memoria = new LinkedList<>(); // arreglo de la clase Queue que saca el primer elemento en llegar con el metodo .remove()

        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>(); // Matriz para ir guardando en cada fila los marcos de pagina depdendiendo de la iteracion

        ArrayList<Integer> aux = new ArrayList<>(3);

        for(int pagina : paginas) {// array para guardar los estados de la memoria, el size depende de los marcos
            if (!memoria.contains(pagina)) {
                if(memoria.size() == marcos) {
                    Integer rmpagina = memoria.remove(); //Se recibe el elemento que se va a eliminar tipo Integer
                    fallos++;
                    memoria.add(pagina); //Se añade la pagina que se debe poner
                    int index = aux.indexOf(rmpagina); // Se guarda el indice de la pagina que se removio para saber en que marco se va a poner
                    aux.remove(rmpagina);
                    aux.add(index, pagina);
                }
                else {
                    memoria.add(pagina);
                    aux.add(pagina);
                    fallos++;
                }
            }

            ArrayList<Integer> copia = new ArrayList<>();

            aux.forEach(c -> copia.add(c)); // metodo que itera sobre los elementos de aux y al mismo tiempo los va colocando en la nueva variable copia

            matriz.add(copia); // se coloca copia en vez de aux para que no se repitan los valores de cada arreglo
        }

        return matriz;
    }

    //////////////////////////////////////////

    /* ANTIGUO ALGORITMO

        @PostMapping("/fifo")
    public String fifo(@RequestBody FIFORequest request) {
        String resultado;

        int[] paginas = request.getNumPaginas();
        int marcos = request.getNumMarcos();

        int fallos = 0;

        Queue<Integer> memoria = new LinkedList<>(); // arreglo de la clase Queue que saca el primer elemento en llegar con el metodo .remove()
        ArrayList<Integer> aux = new ArrayList<>();


        StringBuilder estado = new StringBuilder();

        for(int pagina : paginas) {
            if (!memoria.contains(pagina)) {
                if(memoria.size() == marcos) {
                    Integer rmpagina = memoria.remove(); //Se recibe el elemento que se va a eliminar tipo Integer
                    estado.append("Colocando pagina ").append(pagina).append(" en memoria. "); // Se muestra en consola que pagina se va a colocar
                    fallos++;
                    memoria.add(pagina); //Se añade la pagina que se debe poner
                    int index = aux.indexOf(rmpagina); // Se guarda el indice de la pagina que se removio para saber en que marco se va a poner
                    aux.remove(rmpagina);
                    aux.add(index, pagina);
                    estado.append("Quitando pagina ").append(rmpagina).append(" de la memoria. ");

                }
                else {
                    estado.append("Colocando pagina ").append(pagina).append(" en memoria. ");
                    memoria.add(pagina);
                    aux.add(pagina);
                    fallos++;
                }
            }
            else {
                estado.append("Pagina ").append(pagina).append(" esta ya en memoria. ");
            }
            estado.append("Memoria actual: ");
            for (int p : aux) {
                estado.append(p).append(" ");
            }
            estado.append("fallos de pagina: ").append(fallos).append("\n");
        }
        resultado = estado.toString();

        return resultado;
    }
     */

}
