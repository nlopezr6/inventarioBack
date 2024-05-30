package com.inventory.products.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        Product product = new Product();
        product.setProductoid(1L);
        product.setNombre("Product1");
        product.setDescripcion("Description1");
        product.setCategoria("Category1");
        product.setPreciounitario(100L);
        product.setPreciomasiva(120L);
        product.setCodigoventa("12345");
        product.setStockactual(10);

        assertEquals(1L, product.getProductoid());
        assertEquals("Product1", product.getNombre());
        assertEquals("Description1", product.getDescripcion());
        assertEquals("Category1", product.getCategoria());
        assertEquals(100L, product.getPreciounitario());
        assertEquals(120L, product.getPreciomasiva());
        assertEquals("12345", product.getCodigoventa());
        assertEquals(10, product.getStockactual());
    }
}
