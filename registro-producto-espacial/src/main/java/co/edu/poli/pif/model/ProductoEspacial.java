package co.edu.poli.pif.model;

import java.io.Serializable;
import java.text.*;
import java.util.*;

/**
 * Clase del dominio que representa un producto critico de mision.
 * 
 * Contiene atributos y comportamiento comun para todas las ramas
 * de productos espaciales que maneja el sistema.
 * 
 * La clase implementa Serializable para permitir almacenar y cargar
 * objetos desde archivos binarios.
 */
public class ProductoEspacial implements Serializable {

    /** Identificador interno del producto. */
    protected int id;

    /** Fabricante del producto. */
    protected Fabricante fabricante;

    /** Ingrediente o material principal (opcional). */
    protected Ingrediente ingrediente;

    /** Nombre legible del producto. */
    protected String nombre;

    /** Tipo general del producto. */
    protected TipoProducto tipo;

    /** Masa total del producto en kilogramos. */
    protected double masaKg;

    /** Categoria del producto. */
    protected Categoria categoria;

    /** Cantidad disponible en inventario. */
    protected int cantidad;

    /** Certificacion asociada al producto (si aplica). */
    protected Certificacion certificacion;

    /** Estado operativo (por ejemplo: OK, VENCIDO, MANTENIMIENTO). */
    protected String estado;

    /** Fecha de caducidad del producto, almacenada como texto. */
    protected String fechaCaducidad;

    /** Almacen en el que se guarda el producto. */
    protected Almacen almacen;

    /** Volumen del producto en metros cubicos. */
    protected double volumen;

    /** Nivel de criticidad (por ejemplo: Baja, Media, Alta). */
    protected String nivelCriticidad;

    /** Observaciones adicionales sobre el producto. */
    protected String observaciones;

    /** Constructor vacio requerido para serializacion. */
    public ProductoEspacial() {
    }

    /**
     * Crea un producto con datos basicos.
     *
     * @param nombre   nombre legible
     * @param tipo     tipo general del producto
     * @param masaKg   masa total en kilogramos
     * @param cantidad cantidad disponible en inventario
     */
    public ProductoEspacial(String nombre, TipoProducto tipo, double masaKg, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.masaKg = masaKg;
        this.cantidad = cantidad;
    }

    /**
     * Crea un producto con todos los campos relevantes que usa la interfaz.
     *
     * @param id              identificador interno
     * @param nombre          nombre legible
     * @param tipo            tipo general del producto
     * @param masaKg          masa total en kilogramos
     * @param volumen         volumen en metros cubicos
     * @param cantidad        cantidad disponible en inventario
     * @param fechaCaducidad  fecha de caducidad como texto
     * @param nivelCriticidad nivel de criticidad (Baja, Media, Alta)
     * @param observaciones   observaciones adicionales
     */
    public ProductoEspacial(int id, String nombre, TipoProducto tipo,
                            double masaKg, double volumen, int cantidad,
                            String fechaCaducidad, String nivelCriticidad,
                            String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.masaKg = masaKg;
        this.volumen = volumen;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
        this.nivelCriticidad = nivelCriticidad;
        this.observaciones = observaciones;
    }

    // ---------------- GETTERS Y SETTERS BASICOS ----------------

    /** Devuelve el identificador interno del producto.
     *  @return id
     */
    public int getId() {
        return id;
    }

    /** Establece el identificador interno del producto.
     *  @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Devuelve el fabricante asociado.
     *  @return fabricante
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /** Cambia el fabricante asociado.
     *  @param fabricante nuevo fabricante
     */
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    /** Devuelve el ingrediente principal (si aplica).
     *  @return ingrediente
     */
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    /** Define el ingrediente principal.
     *  @param ingrediente nuevo ingrediente
     */
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    /** Nombre legible del producto.
     *  @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /** Actualiza el nombre legible del producto.
     *  @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Tipo general del producto.
     *  @return tipo de producto
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /** Define el tipo general del producto.
     *  @param tipo nuevo tipo
     */
    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    /** Masa total en kilogramos.
     *  @return masa en kg
     */
    public double getMasaKg() {
        return masaKg;
    }

    /** Actualiza la masa total en kilogramos.
     *  @param masaKg nueva masa
     */
    public void setMasaKg(double masaKg) {
        this.masaKg = masaKg;
    }

    /** Categoria del producto.
     *  @return categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /** Cambia la categoria del producto.
     *  @param categoria nueva categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /** Cantidad disponible en inventario.
     *  @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /** Ajusta la cantidad disponible.
     *  @param cantidad nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /** Certificacion asociada (si existe).
     *  @return certificacion
     */
    public Certificacion getCertificacion() {
        return certificacion;
    }

    /** Cambia la certificacion asociada.
     *  @param certificacion nueva certificacion
     */
    public void setCertificacion(Certificacion certificacion) {
        this.certificacion = certificacion;
    }

    /** Estado operativo del producto.
     *  @return estado
     */
    public String getEstado() {
        return estado;
    }

    /** Cambia el estado operativo.
     *  @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** Texto de fecha de caducidad (si aplica).
     *  @return fecha de caducidad como texto
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /** Cambia la fecha de caducidad.
     *  @param fechaCaducidad nueva fecha de caducidad
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /** Almacen en el que se guarda el producto.
     *  @return almacen
     */
    public Almacen getAlmacen() {
        return almacen;
    }

    /** Cambia el almacen asociado.
     *  @param almacen nuevo almacen
     */
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    /** Devuelve el volumen del producto en metros cubicos.
     *  @return volumen en metros cubicos
     */
    public double getVolumen() {
        return volumen;
    }

    /** Establece el volumen del producto en metros cubicos.
     *  @param volumen nuevo volumen en metros cubicos
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    /** Devuelve el nivel de criticidad del producto.
     *  @return nivel de criticidad
     */
    public String getNivelCriticidad() {
        return nivelCriticidad;
    }

    /** Cambia el nivel de criticidad del producto.
     *  @param nivelCriticidad nuevo nivel de criticidad
     */
    public void setNivelCriticidad(String nivelCriticidad) {
        this.nivelCriticidad = nivelCriticidad;
    }

    /** Devuelve las observaciones asociadas al producto.
     *  @return observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /** Cambia las observaciones asociadas al producto.
     *  @param observaciones nuevas observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // ---------------- METODOS DE APOYO ----------------

    /** Indica si el producto es de tipo consumible.
     *  @return true si el producto es de tipo consumible
     */
    public boolean esConsumible() {
        return tipo == TipoProducto.CONSUMIBLE;
    }

    /** Devuelve una etiqueta compacta para listados.
     *  @return texto con datos clave
     */
    public final String mostrarInstrucciones() {
        return "ID " + id + " • " + nombre + " • " + tipo
                + " • x" + cantidad + " • " + masaKg + "kg";
    }

    /**
     * Verifica reglas basicas del producto para visualizacion o auditoria.
     *
     * @param modoVisual modo de verificacion (no usado, reservado)
     * @return 0 = OK, 1 = VENCIDO, 2 = BAJO_STOCK, 3 = DATOS_INVALIDOS
     */
    public int verificacionProducto(int modoVisual) {
        if (nombre == null || nombre.isBlank() || masaKg < 0 || cantidad < 0) {
            return 3;
        }
        if (esConsumible() && fechaEstaVencida()) {
            return 1;
        }
        if (cantidad == 0) {
            return 2;
        }
        return 0;
    }

    /** Devuelve la representacion legible del producto.
     *  @return texto legible
     */
    @Override
    public String toString() {
        return mostrarInstrucciones();
    }

    /** Devuelve una ficha especifica segun la subclase.
     *  Este metodo puede ser sobreescrito por clases hijas.
     *
     *  @return texto con datos particulares
     */
    public String listar() {
        return mostrarInstrucciones();
    }

    /**
     * Ajusta inventario (ingreso o salida) sin permitir valores negativos.
     *
     * @param delta variacion de inventario (positiva o negativa)
     */
    public void registrarMovimiento(int delta) {
        this.cantidad = Math.max(0, this.cantidad + delta);
    }

    /** Indica si la fecha esta vencida usando una regla simple basada en el estado.
     *  @return true si el estado es "VENCIDO"
     */
    public boolean fechaEstaVencida() {
        return "VENCIDO".equalsIgnoreCase(estado);
    }

    /** Devuelve la masa base total del producto.
     *  @return masa base total
     */
    public double calcularMasaBase() {
        return masaKg;
    }

    /**
     * Devuelve la masa base condicionada.
     *
     * @param condicion "unitaria" para masa por unidad, otro valor para total
     * @return masa en kg segun la condicion
     */
    public double calcularMasaBase(String condicion) {
        if ("unitaria".equalsIgnoreCase(condicion)) {
            return cantidad <= 0 ? 0 : masaKg / cantidad;
        }
        return calcularMasaBase();
    }
}
