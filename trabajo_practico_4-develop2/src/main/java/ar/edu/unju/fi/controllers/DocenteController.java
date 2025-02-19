package ar.edu.unju.fi.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListarDocente;
import ar.edu.unju.fi.models.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @GetMapping("/listado")
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", ListarDocente.listarDocentes());
        model.addAttribute("titulo", "Listado de Docentes");
        return "docente"; // Nombre de la plantilla Thymeleaf para mostrar el listado de docentes
    }
    
    @GetMapping("/nuevo")
    public String formularioDocente(Model model) {
        Docente nuevoDocente = new Docente();
        model.addAttribute("docente", nuevoDocente);
        model.addAttribute("titulo", "Agregar Nuevo Docente");
        return "formularioDocente"; // Nombre de la plantilla Thymeleaf para el formulario de nuevo docente
    }

    @PostMapping("/guardar")
    public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
        ListarDocente.agregarDocente(docente);
        return new ModelAndView("redirect:/docentes/listado");
    }

    @GetMapping("/modificar/{legajo}")
    public String formularioModificarDocente(@PathVariable String legajo, Model model) {
        Docente docente = ListarDocente.buscarDocente(legajo);
        if (docente == null) {
            return "redirect:/docentes/listado";
        }
        model.addAttribute("docente", docente);
        model.addAttribute("titulo", "Modificar Docente");
        return "formularioDocente"; // Nombre de la plantilla Thymeleaf para el formulario de modificación de docente
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("docente") Docente docente) {
        ListarDocente.modificarDocente(docente);
        return "redirect:/docentes/listado";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable String legajo) {
        ListarDocente.eliminarDocente(legajo);
        return "redirect:/docentes/listado";
    }
}