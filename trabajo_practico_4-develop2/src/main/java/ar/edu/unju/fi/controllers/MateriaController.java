package ar.edu.unju.fi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListaMateria;
import ar.edu.unju.fi.models.Materia;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/materia")
public class MateriaController {
    private final Materia materia = new Materia();
    
    @GetMapping("/listado")
    public String getMateriasPage(Model model) {
        model.addAttribute("materias", ListaMateria.listarMaterias());
        return "materias";
    }
    
    @GetMapping("/nuevo")
    public String getMateriasFormPage(Model model) {
        boolean edicion = false;
        model.addAttribute("materia", materia);
        model.addAttribute("edicion", edicion);
        return "materiasForm";
    }
    
    @PostMapping("/guardar")
    public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
        ModelAndView modelView = new ModelAndView("materias");
        ListaMateria.agregarMateria(materia);
        modelView.addObject("materias", ListaMateria.listarMaterias());
        return modelView;
    }
    
    @GetMapping("/modificar/{codigo}")
    public String getModificarMateriaPage(Model model, @PathVariable(value = "codigo") String codigo) {
        Materia encontrado = ListaMateria.buscarMaterias(codigo);
        boolean edicion = true;
        model.addAttribute("materia", encontrado);
        model.addAttribute("edicion", edicion);
        return "materiasForm";
    }
    
    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute("materia") Materia materia) {
        ListaMateria.modificarMateria(materia);
        return "redirect:/materia/listado";
    }
    
    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable(value = "codigo") String codigo) {
        ListaMateria.eliminarMaterias(codigo);
        return "redirect:/materia/listado";
    }
}