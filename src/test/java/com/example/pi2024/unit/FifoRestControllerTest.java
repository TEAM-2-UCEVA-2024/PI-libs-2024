package com.example.pi2024.unit;

import com.example.pi2024.controller.FifoRestController;
import com.example.pi2024.model.entities.FIFORequest;
import org.junit.Test;

import java.util.ArrayList;

public class FifoRestControllerTest {

    @Test
    public void FifoTest() {
        FIFORequest request = new FIFORequest();
        request.setNumMarcos(3);
        request.setNumPaginas(new int[]{2,3,4,2,5,6,2,3,1,4}); // Valores de prueba

        FifoRestController fifoRestController = new FifoRestController();

        ArrayList<ArrayList<Integer>> response;
        response = fifoRestController.fifo(request);

        System.out.println(response);
    }

}
