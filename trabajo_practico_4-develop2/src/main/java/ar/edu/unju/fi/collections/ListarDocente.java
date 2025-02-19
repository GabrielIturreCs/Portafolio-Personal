package ar.edu.unju.fi.collections;


import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.models.Docente;

public class ListarDocente {
  
    private static List<Docente> docentes = new ArrayList<>();
    
    public static List<Docente> listarDocentes() {
        // Aquí puedes cargar datos predefinidos si lo deseas
        return docentes;
    }
    
    public static void agregarDocente(Docente docente) {
        docentes.add(docente);
    }
    
    public static Docente buscarDocente(String legajo) {
        for(Docente docente : docentes) {
            if(docente.getLegajo().equals(legajo)) {
                return docente;
            }
        }
        return null;
    }
    
    public static void eliminarDocente(String legajo) {
        docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
    }
    
    public static void modificarDocente(Docente docente) {
        for(Docente d : docentes) {
            if(d.getLegajo().equals(docente.getLegajo())) {
                d.setNombre(docente.getNombre());
                d.setApellido(docente.getApellido());
                d.setEmail(docente.getEmail());
                d.setTelefono(docente.getTelefono());
                break;
            }
        }
    }
}