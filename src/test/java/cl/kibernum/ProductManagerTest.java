package cl.kibernum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    private ProductManager productManager;
    
    @BeforeEach
    void setUp(){
        productManager = new ProductManager();

        /* Métodos tradicionales con Junit 5 */
  
//         @Test
//   void testNombreValido() {
//     assertTrue(validadorUsuario.esNombreValido("Sofia")); // Es un nombre válido
//     assertFalse(validadorUsuario.esNombreValido("")); // vacio
//     assertFalse(validadorUsuario.esNombreValido(null)); // null
//     assertFalse(validadorUsuario.esNombreValido("A")); // nombre muy corto
//     assertNotNull(validadorUsuario);
//   }

//   /* Métodos de Hamcrest */
//   @Test
//   void testEmailValido() {
//     // - El email debe tener formato válido (ejemplo: usuario@dominio.com).
//     assertThat(validadorUsuario.esEmailValido("sofia@correo.com"), is(true)); // valido
//     assertThat(validadorUsuario.esEmailValido("sofia @correo.com"), is(false)); // valido
//     assertThat(validadorUsuario.esEmailValido("sofia@correo"), is(false)); // sin dominio (.cl, .org, .com)
//     assertThat(validadorUsuario.esEmailValido("correo.com"), is(false)); // sin @
//     assertThat(validadorUsuario.esEmailValido("10"), is(false)); 
//     assertThat(validadorUsuario.esEmailValido("sofia@correo.com  algo"), is(false)); 
//     assertThat(validadorUsuario.esEmailValido("sofia@correo.com.ar"), is(true)); 
//     assertThat(validadorUsuario.esEmailValido("sofia@correo.comm"), is(true)); 
//     assertThat(validadorUsuario.esEmailValido("sofia@correo@com.com"), is(false)); 
//     assertThat(validadorUsuario.esEmailValido("@correo.cl"), is(false)); 
//     assertThat(validadorUsuario.esEmailValido(".@com.cl"), is(true)); 
//     assertThat(validadorUsuario.esEmailValido(null), is(false)); // Esperaria que retorne false para null
//     // sofia@correo.comm o sofia@correo@com.com
//   }

//   // La edad debe ser mayor o igual a 18 años. (Junit 5)
//   @Test
//   void testMayorDeEdad() {
//     int edad = -20;
//     assumeTrue(edad > 0, "La edad debe ser positiva"); // si no, el test se omite
//     assertTrue(validadorUsuario.esMayorDeEdad(edad), "La edad debe ser mayor o igual a 18 años");
//   }

//   /* Prueba parametriza usando CsvSource: varios modelos y combinaciones */
//   @ParameterizedTest
//   @CsvSource({
//     "Sofia, sofia@correo.com, 20, true",
//     "Ana, ana@mail.com, 15, false",
//     ", anonimo@correo.co, 22, false",
//     "Richard, richard.stallman@correo, 30, false",
//   })
//   void testValidarUsuario(String nombre, String email, int edad, boolean esperado) {
//     Usuario usuario = new Usuario(nombre, email, edad);
//     assertEquals(esperado, validadorUsuario.validarUsuario(usuario));
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
}
