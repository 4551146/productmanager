package cl.kibernum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class ProductManagerTest {
    private ProductManager manager;
    
    @BeforeEach
    void setUp(){
        manager = new ProductManager();
    }

    @Test
    void agregarProducto_debeAgregaUnProducto(){
        //Arange
        String nombre = "Vitamina C";
        String descripcion = "Vitamina C sabor naranja";
        double precio = 4000;

        //Act

        manager.agregarProducto(nombre,descripcion,precio);

        //Assert
        assertFalse(manager.getMap().isEmpty(),"Sin productos");
        assertEquals(1,manager.getMap().size());
    }

    @Test
    void actualizarProducto_debeActualizarUnProducto(){
         //Arange
        String nombre = "Vitamina C";
        String descripcion = "Vitamina C sabor naranja";
        double precio = 4000;

         //Act
        manager.agregarProducto(nombre,descripcion,precio);
        boolean actualizado = manager.actualizarProducto(1,"Coca-Cola","Bebida 2L Retornable", 1500);

         //Assert
        assertTrue(actualizado);
    }

    @Test
    void borrarProducto_debeBorrarUnProducto(){
        //Arange
        String nombre = "Vitamina C";
        String descripcion = "Vitamina C sabor naranja";
        double precio = 4000;

        //Act
        manager.agregarProducto(nombre,descripcion,precio);
        boolean borrado = manager.borrarProducto(1);

        //Assert
        assertTrue(borrado);
    }



    @Test
    void validarNombre_nombreDebeSerValido(){
        assertTrue(manager.validarNombre("Coca-Cola Zero"));//Nombre producto válido.
        assertFalse(manager.validarNombre(null)); //Test con nombre null.
        assertFalse(manager.validarNombre("")); //Test con nombre vacío.
    }

    @Test
    void validarDescripcion_descripcionDebeSerValida(){
        assertTrue(manager.validarDescripcion("Botellita cocalita zero"));//Descripción producto válida.
        assertFalse(manager.validarDescripcion(null));//Test con descripción null.
        assertFalse(manager.validarDescripcion(""));//Test con descripción vacía.
    }

    @Test
    void validarPrecio_precioDebeSerPositivo(){
        double precio = 1000;
        
        assertTrue(manager.validarPrecio(precio));//Es positivo

        }


        //Pruebas parametrizadas usando el método CsvSource.

         @ParameterizedTest
         @CsvSource({
            "Vitamina C, Vitamina sabor naranja, 4000, true",
            ", Bebida 2L Retornable, 1500, false",
            "Trencito, Chocolate Trencito, -1400, false",
            "W-40,,7800,false",
         })
         void testValidarProducto(String nombre, String descripcion, double precio, boolean esperado){
            Producto producto = new Producto(nombre, descripcion, precio);
            assertEquals(esperado, manager.validarProducto(producto));
         }

    
}
