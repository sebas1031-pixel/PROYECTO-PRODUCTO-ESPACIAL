package co.edu.poli.pif.model;
import java.io.Serializable;
/** Fabricante del producto espacial. */
public class Fabricante implements Serializable {

    /** Nombre del fabricante. */
    private String nombre;

    /** NIT del fabricante. */
    private int nit;

    /** Número de teléfono de contacto. */
    private String ndetelefono;

    /** País del fabricante. */
    private Pais pais;

    public Fabricante() {}

    public Fabricante(String nombre, int nit, String ndetelefono, Pais pais) {
        this.nombre = nombre;
        this.nit = nit;
        this.ndetelefono = ndetelefono;
        this.pais = pais;
    }

    /** @return nombre */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return nit */
    public int getNit() { return nit; }

    /** @param nit nuevo nit */
    public void setNit(int nit) { this.nit = nit; }

    /** @return telefono */
    public String getNdetelefono() { return ndetelefono; }

    /** @param ndetelefono nuevo telefono */
    public void setNdetelefono(String ndetelefono) { this.ndetelefono = ndetelefono; }

    /** @return pais */
    public Pais getPais() { return pais; }

    /** @param pais nuevo pais */
    public void setPais(Pais pais) { this.pais = pais; }

    /** @return etiqueta legible del fabricante */
    public String etiquetaFabricante() {
        return nombre + " (NIT " + nit + ", " + (pais==null? "N/A" : pais.getCodigo()) + ")";
    }

    @Override public String toString() { return etiquetaFabricante(); }
}