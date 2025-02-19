package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.models.Alumno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ListarAlumnos {

    private static List<Alumno> alumnos = new ArrayList<>();

    public static List<Alumno> listarAlumnos() {
        return new ArrayList<>(alumnos);
    }

    public static void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public static void modificarAlumno(String dni, String nombre, String apellido, String email, String telefono, Date fechaNacimiento, String domicilio, String LU) {
        for (Alumno a : alumnos) {
            if (a.getDni().equals(dni)) {
                a.setNombre(nombre);
                a.setApellido(apellido);
                a.setEmail(email);
                a.setTelefono(telefono);
                a.setFechaNacimiento(fechaNacimiento);
                a.setDomicilio(domicilio);
                a.setLU(LU);
                break;
            }
        }
    }

    public static Alumno buscarAlumno(String dni) {
        for (Alumno a : alumnos) {
            if (a.getDni().equals(dni)) {
                return a;
            }
        }
        return null;
    }

    public static void eliminarAlumno(String dni) {
        alumnos = alumnos.stream()
                .filter(a -> !a.getDni().equals(dni))
                .collect(Collectors.toList());
    }
}