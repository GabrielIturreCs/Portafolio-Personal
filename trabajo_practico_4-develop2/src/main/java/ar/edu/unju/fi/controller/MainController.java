package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        List<Noticia> noticias = new ArrayList<>();
        noticias.add(new Noticia("Noticia 1", "https://fi.unju.edu.ar/images/2024-Noticias/Ingeniavoz-2024-01.png", "El Comité Organizador del CADI-CAEDI 2024 invita a los/as estudiantes a la convocatoria de la propuesta “IngeniaVoz”.", "https://www.fi.unju.edu.ar/alumnos-noticias/4577-reunion-informativa-ingeniavoz-24-05-16-30hs.html"));
        noticias.add(new Noticia("Noticia 2", "https://fi.unju.edu.ar/images/2024-Noticias/campamento-de-idiomas.jpeg", "La capacitación está dirigida a docentes, estudiantes y no docentes.", "https://www.fi.unju.edu.ar/unju/4547-campamento-de-idiomas-la-unju-habla-con-el-mundo.html"));
        noticias.add(new Noticia("Noticia 3", "https://fi.unju.edu.ar/images/2024-Noticias/convocatoria_fiunju.jpg", "La Facultad de Ingeniería informa que se realizará un evento hacia estudiantes.", "https://www.fi.unju.edu.ar/investigacion-noticias/4546-convocatoria-de-proyectos-de-investigacion-en-la-facultad-de-ingenieria-participa-y-desarrolla-tu-potencial.html"));

        model.addAttribute("noticias", noticias);
        model.addAttribute("titulo", "Inicio");
        return "index";
    }
    @GetMapping("/inicio")
    public String getIndexPage(Model model) {
    	model.addAttribute("titulo","Inicio");
    	return "main";
    }

    public static class Noticia {
        private String titulo;
        private String imagen;
        private String descripcion;
        private String url;

        public Noticia(String titulo, String imagen, String descripcion, String url) {
            this.titulo = titulo;
            this.imagen = imagen;
            this.descripcion = descripcion;
            this.url = url;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}