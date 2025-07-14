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
        
        assertTrue(manager.validarPrecio(1000));//Es positivo

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


        //   @Test
//   void testMayorDeEdad() {
//     int edad = -20;
//     assumeTrue(edad > 0, "La edad debe ser positiva"); // si no, el test se omite
//     assertTrue(validadorUsuario.esMayorDeEdad(edad), "La edad debe ser mayor o igual a 18 años");

    

        /* Métodos tradicionales con Junit 5 */
  
//         @Test
//   void testNombreValido() {
//     assertTrue(validadorUsuario.esNombreValido("Sofia")); // Es un nombre válido
//     assertFalse(validadorUsuario.esNombreValido("")); // vacio
//     assertFalse(validadorUsuario.esNombreValido(null)); // null
//     assertFalse(validadorUsuario.esNombreValido("A")); // nombre muy corto
//     assertNotNull(validadorUsuario);
//   }

//  
//   }

//   // La edad debe ser mayor o igual a 18 años. (Junit 5)
//   @Test
//   void testMayorDeEdad() {
//     int edad = -20;
//     assumeTrue(edad > 0, "La edad debe ser positiva"); // si no, el test se omite
//     assertTrue(validadorUsuario.esMayorDeEdad(edad), "La edad debe ser mayor o igual a 18 años");
//   }

//   /*Proveedor de usuarios validos */
//   static Stream<Usuario> usuariosValidos() {
//     return Stream.of(
//       new Usuario("Sofia", "sofia@correo.com", 20),
//       new Usuario("Richard", "richard@correo.com", 30));
//   }

//   @ParameterizedTest
//   @MethodSource("usuariosValidos")
//   void testUsuariosValidos(Usuario usuario) {
//     assertThat(validadorUsuario.validarUsuario(usuario), is(true));
//     assertThat(usuario.getNombre(), allOf(notNullValue(), not(blankString())));
//     assertThat(usuario.getEmail(), containsString("@")); 
//   }

//   @Test
//   void testValidarUsuarioAssumingThat() {
//     Usuario usuario = new Usuario("Sofia", "sofia@correo.com", 10);
//     // assertTrue(validadorUsuario.validarUsuario(usuario), "El usuario debe ser válido si es mayor de edad");
//     assumingThat(validadorUsuario.esMayorDeEdad(usuario.getEdad()), () -> {
//       System.out.println("Este mensaje solo aparece si es mayor de edad");
//       assertTrue(validadorUsuario.validarUsuario(usuario), "El usuario debe ser válido si es mayor de edad");
//     });

//   } 
    
}
