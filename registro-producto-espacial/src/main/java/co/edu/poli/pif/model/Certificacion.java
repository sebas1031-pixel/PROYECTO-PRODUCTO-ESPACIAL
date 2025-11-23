package co.edu.poli.pif.model;
import java.io.Serializable;
/** Certificación del producto emitida por una entidad. */
public class Certificacion implements Serializable {

    /** Identificación de la certificación. */
    private int identificacion;

    /** Nombre de la certificación. */
    private String nombreCertificacion;

    /** Entidad que emite la certificación. */
    private EntidadEmisora entidadEmisora;

    /** Fecha de emisión de la certificación (texto). */
    private String fechaEmision;

    public Certificacion() {}

    public Certificacion(int identificacion, String nombreCertificacion,
                         EntidadEmisora entidadEmisora, String fechaEmision) {
        this.identificacion = identificacion;
        this.nombreCertificacion = nombreCertificacion;
        this.entidadEmisora = entidadEmisora;
        this.fechaEmision = fechaEmision;
    }

    /** @return id */
    public int getIdentificacion() { return identificacion; }

    /** @param identificacion nuevo id */
    public void setIdentificacion(int identificacion) { this.identificacion = identificacion; }

    /** @return nombre de certificacion */
    public String getNombreCertificacion() { return nombreCertificacion; }

    /** @param nombreCertificacion nuevo nombre */
    public void setNombreCertificacion(String nombreCertificacion) { this.nombreCertificacion = nombreCertificacion; }

    /** @return entidad emisora */
    public EntidadEmisora getEntidadEmisora() { return entidadEmisora; }

    /** @param entidadEmisora nueva entidad emisora */
    public void setEntidadEmisora(EntidadEmisora entidadEmisora) { this.entidadEmisora = entidadEmisora; }

    /** @return fecha de emision */
    public String getFechaEmision() { return fechaEmision; }

    /** @param fechaEmision nueva fecha de emision */
    public void setFechaEmision(String fechaEmision) { this.fechaEmision = fechaEmision; }

    @Override public String toString() {
        return nombreCertificacion + " (" + fechaEmision + ")";
    }
}