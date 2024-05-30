package com.inventory.products.controller;

import com.inventory.products.dto.ProductosDTO;
import com.inventory.products.entity.Product;
import com.inventory.products.services.ProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductsService productsService;

    @InjectMocks
    private ProductsController productsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productsController).build();
    }

    @Test
    public void testCreateProducts() throws Exception {
        ProductosDTO productDTO = new ProductosDTO();
        productDTO.setNombre("Product1");

        Product product = new Product();
        product.setProductoid(1L);
        product.setNombre("Product1");

        when(productsService.createProducts(any(ProductosDTO.class))).thenReturn(product);

        mockMvc.perform(post("/Products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\": \"Product1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"productoid\":1,\"nombre\":\"Product1\"}"));
    }

    @Test
    public void testGetAllProduct() throws Exception {
        Product product = new Product();
        product.setProductoid(1L);
        product.setNombre("Product1");

        when(productsService.getProducts()).thenReturn(Arrays.asList(product));

        mockMvc.perform(get("/Products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"productoid\":1,\"nombre\":\"Product1\"}]"));
    }

    @Test
    public void testGetProductById() throws Exception {
        Product product = new Product();
        product.setProductoid(1L);
        product.setNombre("Product1");

        when(productsService.getProductById(anyLong())).thenReturn(Optional.of(product));

        mockMvc.perform(get("/Products/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"productoid\":1,\"nombre\":\"Product1\"}"));
    }
}
