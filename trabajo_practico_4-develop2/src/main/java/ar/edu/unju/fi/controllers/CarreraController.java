package ar.edu.unju.fi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListarCarreras;
import ar.edu.unju.fi.models.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

    @GetMapping("/listado")
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", ListarCarreras.listarCarreras());
        model.addAttribute("titulo", "Carreras");
        return "carreras";
    }

    @GetMapping("/nuevo")
    public String formularioCarrera(Model model) {
        model.addAttribute("carrera", new Carrera(null, null, 0, true)); // Cambiar a true
        model.addAttribute("titulo", "Nueva Carrera");
        model.addAttribute("edicion", false);
        return "carrera";
    }

    @PostMapping("/agregar")
    public ModelAndView guardarCarrera(@ModelAttribute("carrera") ListarCarreras carrera) {
        carrera.setEstado(true);
        ListarCarreras.agregarCarrera(carrera);
        return new ModelAndView("redirect:/carreras/listado");
    }
    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute("carrera") ListarCarreras carrera) {
        ListarCarreras.modificarCarrera(carrera.getCodigo(), carrera.getNombre(), carrera.getCantidadAnios(), carrera.isEstado());
        return "redirect:/carreras/listado";
    }
    @GetMapping("/modificar/{codigo}")
    public String formularioModificarCarrera(@PathVariable String codigo, Model model) {
        ListarCarreras carrera = ListarCarreras.buscarCarrera(codigo);
        if (carrera == null) {
            return "redirect:/carreras/listado";
        }
        model.addAttribute("carrera", carrera);
        model.addAttribute("titulo", "Modificar Carrera");
        model.addAttribute("edicion", true);
        return "carrera";
    }


    

    @GetMapping("/eliminar/{codigo}")
    public String eliminarCarrera(@PathVariable String codigo) {
        ListarCarreras.eliminarCarrera(codigo);
        return "redirect:/carreras/listado";
    }
}