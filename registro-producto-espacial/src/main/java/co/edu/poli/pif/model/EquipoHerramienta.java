package co.edu.poli.pif.model;
import java.io.Serializable;
/**
 * Rama de equipos y herramientas reutilizables.
 */
public class EquipoHerramienta extends ProductoEspacial implements Serializable {

    /** Nivel de desgaste (0..1). */
    protected double nivelDesgaste;
    /** Indica si requiere energía eléctrica para operar. */
    protected boolean requiereEnergia;

    /** Constructor por defecto: fija el tipo como EQUIPO. */
    public EquipoHerramienta(){ this.tipo = TipoProducto.EQUIPO; }

    /**
     * Crea un equipo/herramienta con datos básicos.
     * @param nombre nombre del producto
     * @param masa masa total en kg
     * @param cant cantidad en inventario
     */
    public EquipoHerramienta(String nombre,double masa,int cant){
        super(nombre, TipoProducto.EQUIPO, masa, cant);
    }

    /** Devuelve el nivel de desgaste (0..1).
     *  @return nivel de desgaste 0..1
     */
    public double getNivelDesgaste(){ return nivelDesgaste; }

    /** Establece el nivel de desgaste (0..1).
     *  @param nivelDesgaste nuevo nivel 0..1
     */
    public void setNivelDesgaste(double nivelDesgaste){ this.nivelDesgaste = nivelDesgaste; }

    /** Indica si el equipo requiere energía.
     *  @return true si requiere energia
     */
    public boolean isRequiereEnergia(){ return requiereEnergia; }

    /** Cambia el requisito de energía.
     *  @param requiereEnergia nuevo indicador de energia
     */
    public void setRequiereEnergia(boolean requiereEnergia){ this.requiereEnergia = requiereEnergia; }

    /** Indica si requiere mantenimiento por alto desgaste.
     *  @return true si el desgaste es ≥ 0.7
     */
    public boolean requiereMantenimiento(){ return nivelDesgaste >= 0.7; }

    /** Devuelve una etiqueta de seguridad simple.
     *  @return texto de seguridad
     */
    public String etiquetaSeguridad(){ return "Uso interno — energía: " + (requiereEnergia?"sí":"no"); }

    /** {@inheritDoc} */
    @Override public String listar(){ return "Equipo/Herramienta — " + nombre; }
}