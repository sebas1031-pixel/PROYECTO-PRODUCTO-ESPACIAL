package co.edu.poli.pif.model;
import java.io.Serializable;

/** País de referencia para fabricantes, entidades, etc. */
public class Pais implements Serializable {

    /** Código de país (ISO/propio). */
    private String codigo;

    /** Ciudad principal o sede. */
    private String ciudad;

    /** Idioma predominante. */
    private String idioma;

    /** Crea un país vacío. */
    public Pais() {}

    /**
     * Crea un país con sus datos principales.
     * @param codigo código del país
     * @param ciudad ciudad principal
     * @param idioma idioma predominante
     */
    public Pais(String codigo, String ciudad, String idioma) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.idioma = idioma;
    }

    /** Obtiene el código del país.
     *  @return código de país
     */
    public String getCodigo() { return codigo; }

    /** Actualiza el código del país.
     *  @param codigo nuevo código de país
     */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /** Obtiene la ciudad principal.
     *  @return ciudad
     */
    public String getCiudad() { return ciudad; }

    /** Actualiza la ciudad principal.
     *  @param ciudad nueva ciudad
     */
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    /** Obtiene el idioma predominante.
     *  @return idioma
     */
    public String getIdioma() { return idioma; }

    /** Actualiza el idioma predominante.
     *  @param idioma nuevo idioma
     */
    public void setIdioma(String idioma) { this.idioma = idioma; }

    @Override public String toString() { return codigo + " - " + ciudad; }
}