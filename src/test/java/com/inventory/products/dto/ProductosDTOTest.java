package com.inventory.products.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductosDTOTest {

    @Test
    public void testGettersAndSetters() {
        ProductosDTO product = new ProductosDTO();
        product.setProductoid(1L);
        product.setNombre("Product1");
        product.setDescripcion("Description1");
        product.setCategoria("Category1");
        product.setPreciounitario("100");
        product.setPreciomasiva("120");
        product.setCodigoventa("12345");
        product.setStockactual("10");

        assertEquals(1L, product.getProductoid());
        assertEquals("Product1", product.getNombre());
        assertEquals("Description1", product.getDescripcion());
        assertEquals("Category1", product.getCategoria());
        assertEquals("100", product.getPreciounitario());
        assertEquals("120", product.getPreciomasiva());
        assertEquals("12345", product.getCodigoventa());
        assertEquals("10", product.getStockactual());
    }
}
