package co.edu.poli.pif.model;

import java.io.Serializable;
import co.edu.poli.pif.model.Consumible;
/** Subtipo de consumible orientado a alimentos. */
public class Alimento extends Consumible implements Serializable {

    /** Kilocalorías por unidad. */
    private int kcalPorUnidad;

    /** Constructor vacío. */
    public Alimento() { super(); setTipo(TipoProducto.CONSUMIBLE); }

    /**
     * Constructor completo usado por el menú.
     * @param id                id del producto
     * @param nombre            nombre
     * @param masaKg            masa en kg
     * @param cantidad          cantidad
     * @param fechaVencimiento  fecha de caducidad (texto)
     * @param tipoConsumible    tipo de consumible (p. ej., “Alimento”)
     * @param kcalPorUnidad     kcal por unidad
     */
    public Alimento(int id, String nombre, double masaKg, int cantidad,
                    String fechaVencimiento, String tipoConsumible,
                    int kcalPorUnidad) {

        // Llamamos al constructor que sí existe en Consumible
        super(nombre, masaKg, cantidad, fechaVencimiento);

        // Completamos campos heredados que no van en el super
        setId(id);
        setTipoConsumible(tipoConsumible);
        setTipo(TipoProducto.CONSUMIBLE);

        // Propio de Alimento
        this.kcalPorUnidad = kcalPorUnidad;
    }

    /** Obtiene las kilocalorías por unidad.
     *  @return kilocalorías por unidad.
     */
    public int getKcalPorUnidad() { return kcalPorUnidad; }

    /** Establece las kilocalorías por unidad.
     *  @param kcalPorUnidad nuevas kcal por unidad
     */
    public void setKcalPorUnidad(int kcalPorUnidad) { this.kcalPorUnidad = kcalPorUnidad; }

    /** Calcula las kilocalorías totales según la cantidad actual.
     *  @return kcal totales (= cantidad * kcalPorUnidad), nunca negativo
     */
    public int kcalTotales() { return Math.max(0, getCantidad()) * Math.max(0, kcalPorUnidad); }

    /** {@inheritDoc} */
    @Override public String listar() {
        return "Alimento — " + getNombre() + " (" + kcalPorUnidad + " kcal/u, vence " + getFechaCaducidad() + ")";
    }
}