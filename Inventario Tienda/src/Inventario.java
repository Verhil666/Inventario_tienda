import java.util.ArrayList;

public class Inventario {
    
    //Lista donde se almacenan todos los productos
    private ArrayList<Producto> productos;

    //Constructor
    public Inventario() {
        productos = new ArrayList<>();
}

//Agregar un producto
public void agregarProducto(Producto producto) {
    productos.add(producto);
    System.out.println("Producto agregado: " + producto.getNombre());

}

//Mostrar todos los productos
producto.mostrarDatos();
{

    if(productos.isEmpty()){
        System.out.println("No hay productos en el inventario.");
    } else {
        System.out.println("Productos en el inventario:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

}

    //Buscar un producto por codigo
    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null; // Retorna null si no se encuentra el producto
    }

    //Editar un producto
    public void editarProducto(String codigo, String nuevoNombre, double nuevoPrecio) {
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            System.out.println("Producto editado: " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    //Eliminar un producto
    public void eliminarProducto(String codigo) {
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}