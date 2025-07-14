package cl.kibernum;
import java.util.HashMap;
import java.util.Map;

public class ProductManager {

    private Map<Integer, Producto> productos = new HashMap<>();

    private int contadorId=0;

    public void agregarProducto(String nombre, String descripcion, double precio) {
        this.contadorId++;
        productos.put(this.contadorId, new Producto(nombre, descripcion, precio));
    }

    public Map<Integer, Producto> getMap(){
         return Map.copyOf(this.productos);
    }

    public boolean actualizarProducto(int id, String nombre, String descripcion, double precio) {
        Producto producto = productos.get(id);
        if (producto == null) {
            return false;
        }

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        return true;
    }

    public boolean borrarProducto(int id){
        return productos.remove(id) !=null;
    }

    public boolean validarNombre(String nombre){
        return nombre != null && !nombre.trim().isEmpty();
    }

    public boolean validarDescripcion(String descripcion) {
        return descripcion != null && !descripcion.trim().isEmpty();
    }
    
    public boolean validarPrecio(double precio){
        return precio > 0; //&& Pattern.matches(PATRON_MONEDA_CHILENA, precio);
    }

    public boolean validarProducto(Producto producto) {
        return validarNombre(producto.getNombre()) &&
               validarDescripcion(producto.getDescripcion()) &&
               validarPrecio(producto.getPrecio());
    }

}
