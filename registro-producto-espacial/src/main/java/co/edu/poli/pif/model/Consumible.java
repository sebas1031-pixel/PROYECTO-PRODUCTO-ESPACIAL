package co.edu.poli.pif.model;
import java.io.Serializable;
/**
 * Rama de productos que vencen (alimentos, medicinas, etc.).
 */
public class Consumible extends ProductoEspacial implements Serializable {

    /** Tipo de consumible (Alimento, Medicamento, etc.). */
    private String tipoConsumible;

    /** Constructor por defecto: fija el tipo como CONSUMIBLE. */
    public Consumible(){ this.tipo = TipoProducto.CONSUMIBLE; }

    /**
     * Crea un consumible con datos básicos.
     * @param nombre nombre del producto
     * @param masa masa total en kg
     * @param cant cantidad en inventario
     * @param fecha fecha de caducidad como texto
     */
    public Consumible(String nombre,double masa,int cant,String fecha){
        super(nombre, TipoProducto.CONSUMIBLE, masa, cant);
        this.fechaCaducidad = fecha;
    }

    /** Devuelve el tipo de consumible.
     *  @return tipo de consumible
     */
    public String getTipoConsumible(){ return tipoConsumible; }

    /** Cambia el tipo de consumible.
     *  @param tipoConsumible nuevo tipo
     */
    public void setTipoConsumible(String tipoConsumible){ this.tipoConsumible = tipoConsumible; }

    /** Estimación simple de días para vencer (placeholder).
     *  @return 0 si no hay fecha, 1 si existe
     */
    public int diasParaVencer(){ return (fechaCaducidad==null||fechaCaducidad.isBlank())?0:1; }

    /** {@inheritDoc} */
    @Override public String listar(){
        return "Consumible — vence: " + (fechaCaducidad==null?"N/A":fechaCaducidad);
    }
}