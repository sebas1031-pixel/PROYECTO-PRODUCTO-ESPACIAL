package co.edu.poli.pif.servicios;
/**
 * Operaciones de persistencia binaria simple.
 */
public interface OperacionArchivo {

    /**
     * Serializa el almacén de productos a un archivo .dat/.bin.
     * @param ruta ruta destino
     * @return mensaje de resultado
     */
    String serializar(String ruta);

    /**
     * Carga el almacén de productos desde un archivo .dat/.bin.
     * @param ruta ruta origen
     * @return mensaje de resultado
     */
    String deserializar(String ruta);
}