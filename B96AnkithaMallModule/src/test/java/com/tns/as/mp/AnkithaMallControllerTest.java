
package com.tns.as.mp;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AnkithaMallControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AnkithaMallService service;

    @InjectMocks
    private AnkithaMallController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    

    @Test
    public void testGetMallNotFound() throws Exception {
        when(service.get(999)).thenThrow(new RuntimeException("Mall not found"));

        mockMvc.perform(get("/mall_name/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateMall() throws Exception {
       AnkithaMall existingMall = new AnkithaMall();
        when(service.get(1)).thenReturn(existingMall);

        mockMvc.perform(put("/mall/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"mall\":\"Mall Updated\"}"))
            .andExpect(status().isOk());

        verify(service, times(1)).save(any(AnkithaMall.class));
    }
    
    
    @Test
    public void testUpdateMallNotFound() throws Exception {
        when(service.get(999)).thenThrow(new RuntimeException("Mall not found"));

        mockMvc.perform(put("/mall/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":999,\"mall\":\"Non-existent\"}"))
            .andExpect(status().isNotFound());
    }
    @Test
    public void testDeleteMall() throws Exception {
        // Arrange
        doNothing().when(service).delete(1);

        // Act
        mockMvc.perform(delete("/mall/1"))
            .andExpect(status().isOk());

        // Assert
        verify(service, times(1)).delete(1);
    }
    
    @Test
    public void testGetMall() throws Exception {
        when(service.get(1)).thenReturn(new AnkithaMall(1, "Anvay", "XZ Mall", "USA","Ent", null));

        mockMvc.perform(get("/mall_name/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("XZ Mall"));
    }





    

    
}