package ar.edu.unju.fi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListarAlumnos;
import ar.edu.unju.fi.models.Alumno;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/alumnos")
public class ControllerAlumno {

    @GetMapping("/listado")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", ListarAlumnos.listarAlumnos());
        model.addAttribute("titulo", "Alumnos");
        return "estudiante";
    }

    @GetMapping("/nuevo")
    public String formularioAlumno(Model model) {
        model.addAttribute("alumno", new Alumno(null, null, null, null, null, null, null, null));
        model.addAttribute("titulo", "Nuevo Alumno");
        model.addAttribute("edicion", false); // No es edición
        return "formularioAlumno";
    }

    @PostMapping("/agregar")
    public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        ListarAlumnos.agregarAlumno(alumno);
        return new ModelAndView("redirect:/alumnos/listado");
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        ListarAlumnos.modificarAlumno(alumno.getDni(), alumno.getNombre(), alumno.getApellido(), alumno.getEmail(), alumno.getTelefono(), alumno.getFechaNacimiento(), alumno.getDomicilio(), alumno.getLU());
        return "redirect:/alumnos/listado";
    }

    @GetMapping("/modificar/{dni}")
    public String formularioModificarAlumno(@PathVariable String dni, Model model) {
        Alumno alumno = ListarAlumnos.buscarAlumno(dni);
        if (alumno == null) {
            return "redirect:/alumnos/listado";
        }
        model.addAttribute("alumno", alumno);
        model.addAttribute("titulo", "Modificar Alumno");
        model.addAttribute("edicion", true); // Es edición
        return "formularioAlumno";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable String dni) {
        ListarAlumnos.eliminarAlumno(dni);
        return "redirect:/alumnos/listado";
    }
}