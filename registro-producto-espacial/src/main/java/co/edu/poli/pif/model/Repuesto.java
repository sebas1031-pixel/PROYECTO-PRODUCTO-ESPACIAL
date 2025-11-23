package co.edu.poli.pif.model;
import java.io.Serializable;
/**
 * Repuesto genérico del inventario espacial.
 * Es una subclase directa de {@link ProductoEspacial}.
 */
public class Repuesto extends ProductoEspacial implements Serializable {

    /** Número de parte del fabricante (opcional). */
    private int ndeparte;
    /** Vida útil estimada (texto opcional). */
    private String vidautil;
    /** Indica si es componente crítico. */
    private boolean componenteCritico;

    /** Constructor por defecto: fija el tipo como REPUESTO. */
    public Repuesto() {
        this.tipo = TipoProducto.REPUESTO;
    }

    /**
     * Constructor básico usado por el menú de consola.
     * @param nombre   nombre del repuesto
     * @param masaKg   masa total en kg
     * @param cantidad cantidad en inventario
     */
    public Repuesto(String nombre, double masaKg, int cantidad) {
        super(nombre, TipoProducto.REPUESTO, masaKg, cantidad);
    }

    // ---------- Getters/Setters opcionales ----------

    /** @return número de parte. */
    public int getNdeparte() { return ndeparte; }

    /** @param ndeparte nuevo número de parte. */
    public void setNdeparte(int ndeparte) { this.ndeparte = ndeparte; }

    /** @return vida útil estimada. */
    public String getVidautil() { return vidautil; }

    /** @param vidautil nueva vida útil estimada. */
    public void setVidautil(String vidautil) { this.vidautil = vidautil; }

    /** @return {@code true} si el repuesto es crítico. */
    public boolean isComponenteCritico() { return componenteCritico; }

    /** @param componenteCritico marca el repuesto como crítico o no. */
    public void setComponenteCritico(boolean componenteCritico) { this.componenteCritico = componenteCritico; }

    /**
     * Indica si es apto para inventario regular.
     * @return {@code true} si NO es crítico.
     */
    public boolean aptoParaInventario() { return !componenteCritico; }

    /** {@inheritDoc} */
    @Override
    public String listar() {
        return "Repuesto — " + (getNombre()==null ? "N/A" : getNombre());
    }
}