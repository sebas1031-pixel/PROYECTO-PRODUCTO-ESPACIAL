package co.edu.poli.pif.model;
import java.io.Serializable;
/** Entidad que emite certificaciones. */
public class EntidadEmisora implements Serializable {

    /** Identificador de la entidad. */
    private int id;

    /** Nombre de la entidad emisora. */
    private String nombre;

    /** País al que pertenece la entidad. */
    private Pais pais;

    /** Año de fundación de la entidad. */
    private int anioFundacion;

    public EntidadEmisora() {}

    public EntidadEmisora(int id, String nombre, Pais pais, int anioFundacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.anioFundacion = anioFundacion;
    }

    /** @return id */
    public int getId() { return id; }

    /** @param id nuevo id */
    public void setId(int id) { this.id = id; }

    /** @return nombre */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return pais */
    public Pais getPais() { return pais; }

    /** @param pais nuevo pais */
    public void setPais(Pais pais) { this.pais = pais; }

    /** @return anio de fundacion */
    public int getAnioFundacion() { return anioFundacion; }

    /** @param anioFundacion nuevo anio de fundacion */
    public void setAnioFundacion(int anioFundacion) { this.anioFundacion = anioFundacion; }

    /** @param anioActual año de referencia
     *  @return antigüedad de la entidad en años
     */
    public int antiguedad(int anioActual){ return Math.max(0, anioActual - anioFundacion); }

    @Override public String toString() { return nombre; }
}