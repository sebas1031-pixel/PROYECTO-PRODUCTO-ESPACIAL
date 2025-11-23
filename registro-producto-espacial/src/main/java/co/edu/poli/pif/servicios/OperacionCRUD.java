package co.edu.poli.pif.servicios;
import co.edu.poli.pif.model.ProductoEspacial;
/**
 * Operaciones CRUD básicas sobre {@link ProductoEspacial}.
 */
public interface OperacionCRUD {

    /**
     * Inserta un nuevo producto y asigna ID.
     * @param p producto a crear
     * @return mensaje de resultado
     */
    String create(ProductoEspacial p);

    /**
     * Devuelve todos los productos en memoria.
     * @return arreglo de productos (puede ser vacío)
     */
    ProductoEspacial[] readAll();

    /**
     * Busca un producto por su identificador.
     * @param id id a consultar
     * @return producto encontrado o null
     */
    ProductoEspacial readId(int id);

    /**
     * Reemplaza los datos del producto con ese id.
     * @param id identificador existente
     * @param p nuevo estado del producto (se respeta el id)
     * @return mensaje de resultado
     */
    String update(int id, ProductoEspacial p);

    /**
     * Elimina un producto por id.
     * @param id identificador a eliminar
     * @return producto eliminado o null si no existe
     */
    ProductoEspacial delete(int id);
}