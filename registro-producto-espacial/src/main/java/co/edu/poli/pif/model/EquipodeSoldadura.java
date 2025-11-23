package co.edu.poli.pif.model;

import java.io.Serializable;

/**
 * Rama de productos de tipo equipo enfocada en herramientas de soldadura.
 * Incluye desgaste, requisito de energía, tipo de soldadura y potencia.
 */
public class EquipodeSoldadura extends ProductoEspacial implements Serializable {

    /** Nivel de desgaste (0..1). */
    private double nivelDesgaste;
    /** Indica si requiere energía eléctrica para operar. */
    private boolean requiereEnergia;
    /** Tipo de soldadura (MIG, TIG, Arco, etc.). */
    private String tipoSoldadura;
    /** Potencia nominal en vatios. */
    private int potenciaW;

    /** Constructor por defecto: fija el tipo como EQUIPO. */
    public EquipodeSoldadura(){ this.tipo = TipoProducto.EQUIPO; }

    /**
     * Crea un equipo de soldadura con datos básicos.
     * @param nombre nombre del equipo
     * @param masaKg masa total en kg
     * @param cantidad cantidad en inventario
     * @param tipoSoldadura tipo de soldadura (MIG, TIG, etc.)
     * @param potenciaW potencia nominal en vatios
     * @param requiereEnergia si requiere energía eléctrica
     */
    public EquipodeSoldadura(String nombre, double masaKg, int cantidad,
                             String tipoSoldadura, int potenciaW, boolean requiereEnergia) {
        super(nombre, TipoProducto.EQUIPO, masaKg, cantidad);
        this.tipoSoldadura = tipoSoldadura;
        this.potenciaW = potenciaW;
        this.requiereEnergia = requiereEnergia;
    }

    /** Nivel de desgaste (0..1).
     *  @return nivel de desgaste 0..1
     */
    public double getNivelDesgaste(){ return nivelDesgaste; }

    /** Establece el nivel de desgaste (0..1).
     *  @param nivelDesgaste nuevo nivel 0..1
     */
    public void setNivelDesgaste(double nivelDesgaste){ this.nivelDesgaste = nivelDesgaste; }

    /** Indica si requiere energía eléctrica.
     *  @return true si requiere energia
     */
    public boolean isRequiereEnergia(){ return requiereEnergia; }

    /** Cambia el requisito de energía.
     *  @param requiereEnergia nuevo indicador de energia
     */
    public void setRequiereEnergia(boolean requiereEnergia){ this.requiereEnergia = requiereEnergia; }

    /** Tipo de soldadura (MIG, TIG, Arco, etc.).
     *  @return tipo de soldadura
     */
    public String getTipoSoldadura(){ return tipoSoldadura; }

    /** Cambia el tipo de soldadura.
     *  @param tipoSoldadura nuevo tipo de soldadura
     */
    public void setTipoSoldadura(String tipoSoldadura){ this.tipoSoldadura = tipoSoldadura; }

    /** Potencia nominal en vatios.
     *  @return potencia en vatios
     */
    public int getPotenciaW(){ return potenciaW; }

    /** Cambia la potencia nominal.
     *  @param potenciaW nueva potencia en vatios
     */
    public void setPotenciaW(int potenciaW){ this.potenciaW = potenciaW; }

    /** Indica si requiere mantenimiento por alto desgaste.
     *  @return true si el desgaste es ≥ 0.7
     */
    public boolean requiereMantenimiento(){ return nivelDesgaste >= 0.7; }

    /**
     * Calcula el consumo energético en kWh.
     * @param horas horas de uso (≥ 0)
     * @return energía consumida en kWh
     */
    public double consumoEnergetico(double horas){
        return Math.max(0, horas) * potenciaW / 1000.0;
    }

    /**
     * Incrementa y devuelve el nivel de desgaste.
     * @param horas horas adicionales de uso
     * @return nivel de desgaste resultante (0..1)
     */
    public double estimarDesgaste(double horas){
        double nuevo = Math.min(1.0, this.nivelDesgaste + Math.max(0, horas) * 0.01);
        this.nivelDesgaste = nuevo;
        return nuevo;
    }

    /** {@inheritDoc} */
    @Override public String listar(){
        return "Eq. Soldadura — " +
               (tipoSoldadura==null?"N/A":tipoSoldadura) +
               " ("+potenciaW+"W, " + (requiereEnergia?"con energía":"sin energía") + ")";
    }
}
