package com.example.pi2024.unit;

import com.example.pi2024.model.service.IOvaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class OvaRestControllerTests {

    private MockMvc mock;

    @Mock
    private IOvaService ovaService;

    @InjectMocks
    private OvaRestController ovaRestController;

    @Before
    public void setup() {
        mock = MockMvcBuilders.standaloneSetup(ovaRestController).build();
    }

    @Test
    public void returnsListaOvas() throws Exception {
        Ovas ova1 = new Ovas();
        Ovas ova2 = new Ovas();
        ova1.setTitulo("Nombre de ejemplo 1");
        ova1.setDescripcion("Descripcion de ejemplo 1");
        ova2.setTitulo("Nombre de ejemplo 2");
        ova2.setDescripcion("Descripcion de ejemplo 1");
        List<Ovas> ovasList = Arrays.asList(ova1,ova2);

        when(ovaService.findAll()).thenReturn(ovasList);

        mock.perform(get("/api/ova-service/ovas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].titulo", is("Nombre de ejemplo 1")))
                .andExpect(jsonPath("$[1].titulo", is("Nombre de ejemplo 2")));

        verify(ovaService).findAll();
    }
}