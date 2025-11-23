package co.edu.poli.pif.servicios;
import co.edu.poli.pif.model.ProductoEspacial;
import java.io.*; import java.util.*;
/**
 * Implementación en memoria del CRUD con serialización binaria.
 * Mantiene un {@link LinkedHashMap} para preservar el orden de inserción.
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo, Serializable {

    /** Almacén en memoria indexado por ID. */
    private final Map<Integer, ProductoEspacial> data = new LinkedHashMap<>();
    /** Siguiente ID a asignar. */
    private int nextId = 1;

    /** Crea el servicio con un almacén vacío. */
    public ImplementacionOperacionCRUD() {}

    /** Genera un ID incremental.
     *  @return nuevo id
     */
    private int generarId(){ return nextId++; }

    /** {@inheritDoc} */
    @Override
    public String create(ProductoEspacial p) {
        if (p == null) return "ERROR: objeto nulo";
        p.setId(generarId());
        data.put(p.getId(), p);
        return "OK: creado ID " + p.getId();
    }

    /** {@inheritDoc} */
    @Override
    public ProductoEspacial[] readAll() {
        return data.values().toArray(new ProductoEspacial[0]);
    }

    /** {@inheritDoc} */
    @Override
    public ProductoEspacial readId(int id) {
        return data.get(id);
    }

    /** {@inheritDoc} */
    @Override
    public String update(int id, ProductoEspacial p) {
        if (!data.containsKey(id)) return "ERROR: no existe ID " + id;
        if (p == null) return "ERROR: objeto nulo";
        p.setId(id);
        data.put(id, p);
        return "OK: actualizado ID " + id;
    }

    /** {@inheritDoc} */
    @Override
    public ProductoEspacial delete(int id) {
        return data.remove(id);
    }

    /** {@inheritDoc} */
    @Override
    public String serializar(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(nextId);
            oos.writeObject(new ArrayList<>(data.values()));
            return "OK: serializado en " + ruta;
        } catch (IOException e) {
            return "ERROR serializando: " + e.getMessage();
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public String deserializar(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            this.nextId = (Integer) ois.readObject();
            List<ProductoEspacial> lista = (List<ProductoEspacial>) ois.readObject();
            data.clear();
            for (ProductoEspacial p : lista) data.put(p.getId(), p);
            return "OK: deserializado (" + data.size() + " registros)";
        } catch (IOException | ClassNotFoundException e) {
            return "ERROR deserializando: " + e.getMessage();
        }
    }
}