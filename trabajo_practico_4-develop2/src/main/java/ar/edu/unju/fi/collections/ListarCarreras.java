package ar.edu.unju.fi.collections;

import java.util.ArrayList;

public class ListarCarreras {
    private static ArrayList<ListarCarreras> carreras = new ArrayList<>();
    private String codigo;
    private String nombre;
    private int cantidadAnios;
    private boolean estado;

    public ListarCarreras(String codigo, String nombre, int cantidadAnios, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadAnios = cantidadAnios;
        this.estado = estado;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCantidadAnios() { return cantidadAnios; }
    public void setCantidadAnios(int cantidadAnios) { this.cantidadAnios = cantidadAnios; }
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    // Métodos estáticos
    public static void agregarCarrera(ListarCarreras carrera) {
        carreras.add(carrera);
    }

    public static ArrayList<ListarCarreras> listarCarreras() {
        return carreras;
    }

    public static ListarCarreras buscarCarrera(String codigo) {
        for (ListarCarreras carrera : carreras) {
            if (carrera.getCodigo().equals(codigo)) {
                return carrera;
            }
        }
        return null;
    }

    public static void modificarCarrera(String codigo, String nuevoNombre, int nuevaCantidadAnios, boolean nuevoEstado) {
        ListarCarreras carrera = buscarCarrera(codigo);
        if (carrera != null) {
            carrera.setNombre(nuevoNombre);
            carrera.setCantidadAnios(nuevaCantidadAnios);
            carrera.setEstado(nuevoEstado);
        }
    }

    public static void eliminarCarrera(String codigo) {
        ListarCarreras carrera = buscarCarrera(codigo);
        if (carrera != null) {
            carreras.remove(carrera);
        }
    }

    static {
        carreras.add(new ListarCarreras("C1", "Ingeniería Informática", 5, true));
        carreras.add(new ListarCarreras("C2", "Ingeniería Industrial", 5, true));
        carreras.add(new ListarCarreras("C3", "Ingeniería Civil", 5, true));
        carreras.add(new ListarCarreras("C4", "Ingeniería Química", 5, true));
    }
}