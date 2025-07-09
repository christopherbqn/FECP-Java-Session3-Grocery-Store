package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testAddProductWithValidQuantity() {
        boolean result = Main.addProduct("Banana", 30);
        assertTrue(result);
        assertTrue(Main.checkExistingProduct("Banana"));
        assertEquals(30,Main.getProductQuantity("Banana"));
    }

    @Test
    void testAddProductWithZeroQuantity(){
        boolean result = Main.addProduct("Mango", 0);
        // should not add to inventory
        assertFalse(result);
        assertFalse(Main.checkProduct("Mango"));
    }

    @Test
    void testAddProductWithNegativeQuantity(){
        boolean result = Main.addProduct("Mango", -1);
        // should not add to inventory
        assertFalse(result);
        assertFalse(Main.checkProduct("Mango"));
    }

    @Test
    void testAddProductWithExistingProduct(){
        // add a product
        Main.addProduct("Eggs", 10);
        // try to add the same existing product
        boolean result = Main.addProduct("Eggs", 15);
        assertFalse(result);
        // should not override
        assertEquals(10, Main.getProductQuantity("Eggs"));
    }

    @Test
    void testCheckProductValid(){
        // add product first
        boolean addResult = Main.addProduct("Milk", 10);
        assertTrue(addResult);

        // check product
        boolean checkResult = Main.checkProduct("Milk");
        assertTrue(checkResult);
    }

    @Test
    void testCheckNonExistingProduct(){
        // check non-existing product
        boolean result = Main.checkProduct("Ice Cream");
        assertFalse(result);
    }

    @Test
    void testUpdateProductValidQuantity(){
        // add product first
        boolean addResult = Main.addProduct("Bread", 10);
        assertTrue(addResult);

        // update product
        boolean updateResult = Main.updateProduct("Bread",15);
        assertTrue(updateResult);
        assertEquals(15, Main.getProductQuantity("Bread"));
    }

    @Test
    void testUpdateWithZeroQuantity(){
        // update Bread with 0 Quantity
        boolean updateResult = Main.updateProduct("Bread", 0 );
        // should not update quantity
        assertFalse(updateResult);
        assertEquals(15, Main.getProductQuantity("Bread"));
    }

    @Test
    void testUpdateWithNegativeQuantity(){
        // update Bread with Negative Quantity
        boolean updateResult = Main.updateProduct("Bread", -1 );
        // should not update quantity
        assertFalse(updateResult);
        assertEquals(15, Main.getProductQuantity("Bread"));
    }

    @Test
    void testUpdateNonExistingProduct(){
        boolean updateResult = Main.updateProduct("Tofu", 10);
        // should not update
        assertFalse(updateResult);
    }

    @Test
    void testRemovingProductValid(){
        Main.addProduct("Eggs", 10);
        boolean removeResult = Main.removeProduct("Eggs");
        assertTrue(removeResult);
    }

    @Test
    void testRemovingNonExistingProduct(){
        boolean removeResult = Main.removeProduct("Pizza");
        assertFalse(removeResult);
    }










}