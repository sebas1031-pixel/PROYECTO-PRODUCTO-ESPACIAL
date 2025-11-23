package co.edu.poli.pif.model;

import java.io.Serializable;

/**
 * Subtipo de Repuesto para piezas mecánicas.
 */
public class RepuestoMecanico extends Repuesto implements Serializable {

    /** Material base del repuesto mecánico. */
    private String materialBase;

    /** Constructor vacío. */
    public RepuestoMecanico(){ super(); }

    /**
     * Constructor completo.
     * @param id                id del producto
     * @param nombre            nombre
     * @param masaKg            masa en kg
     * @param cantidad          cantidad en inventario
     * @param ndeparte          número de parte (heredado)
     * @param vidautil          vida útil (heredado)
     * @param componenteCritico si es componente crítico (heredado)
     * @param materialBase      material base del repuesto mecánico
     */
    public RepuestoMecanico(
            int id, String nombre, double masaKg, int cantidad,
            int ndeparte, String vidautil, boolean componenteCritico,
            String materialBase) {

        // Llama al constructor existente en Repuesto
        super(nombre, masaKg, cantidad);

        // Setea los campos heredados que no van en el super
        setId(id);
        setNdeparte(ndeparte);
        setVidautil(vidautil);
        setComponenteCritico(componenteCritico);

        // Campo propio
        this.materialBase = materialBase;
    }

    // Getters / setters
    /** @return material base del repuesto. */
    public String getMaterialBase() { return materialBase; }
    /** @param materialBase nuevo material base. */
    public void setMaterialBase(String materialBase) { this.materialBase = materialBase; }

    /**
     * Devuelve un texto corto con el material base.
     * @return descripción legible del material.
     */
    public String descripcionMaterial(){
        return "Material: " + (materialBase==null ? "N/A" : materialBase);
    }

    /** {@inheritDoc} */
    @Override public String listar(){
        return "Repuesto Mecánico — " + getNombre() + " [" + descripcionMaterial() + "]";
    }
}