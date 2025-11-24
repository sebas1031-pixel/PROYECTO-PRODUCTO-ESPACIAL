package co.edu.poli.pif.servicios;

import co.edu.poli.pif.model.ProductoEspacial;
import java.io.*;
import java.util.*;

/**
 * Implementacion del CRUD con serializacion binaria.
 * Soporta IDs ingresados manualmente.
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo, Serializable {

    /** Mapa principal por ID. */
    private final Map<Integer, ProductoEspacial> data = new LinkedHashMap<>();

    /** Siguiente ID autogenerado (solo si el usuario no ingresa ID). */
    private int nextId = 1;

    /** Constructor. */
    public ImplementacionOperacionCRUD() {}

    /** Genera ID incremental. */
    private int generarId() { return nextId++; }

    /** Ajusta nextId para que nunca retroceda. */
    private void actualizarNextId(int idUsuario) {
        if (idUsuario >= nextId)
            nextId = idUsuario + 1;
    }

    // -------------------------------------------------------------------------

    @Override
    public String create(ProductoEspacial p) {
        if (p == null) return "ERROR: objeto nulo";

        int id = p.getId();

        // Si el usuario NO escribió un ID → generar uno
        if (id <= 0) {
            id = generarId();
            p.setId(id);
        } else {
            // Si el ID viene manual → respetarlo
            actualizarNextId(id);
        }

        data.put(id, p);
        return "OK: creado ID " + id;
    }

    @Override
    public ProductoEspacial[] readAll() {
        return data.values().toArray(new ProductoEspacial[0]);
    }

    @Override
    public ProductoEspacial readId(int id) {
        return data.get(id);
    }

    @Override
    public String update(int id, ProductoEspacial p) {
        if (!data.containsKey(id))
            return "ERROR: no existe ID " + id;

        p.setId(id);
        data.put(id, p);
        return "OK: actualizado ID " + id;
    }

    @Override
    public ProductoEspacial delete(int id) {
        return data.remove(id);
    }

    // -------------------- ARCHIVO ---------------------------------------------

    @Override
    public String serializar(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(nextId);
            oos.writeObject(new ArrayList<>(data.values()));
            return "OK serializado";
        } catch (IOException e) {
            return "ERROR serializando: " + e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public String deserializar(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            this.nextId = (Integer) ois.readObject();
            List<ProductoEspacial> lista = (List<ProductoEspacial>) ois.readObject();

            data.clear();
            for (ProductoEspacial p : lista) {
                data.put(p.getId(), p);
                actualizarNextId(p.getId());
            }

            return "OK deserializado";
        } catch (IOException | ClassNotFoundException e) {
            return "ERROR deserializando: " + e.getMessage();
        }
    }
}
