package com.example.EA2_Ramos.controller;

import com.example.EA2_Ramos.model.Trabajador;
import com.example.EA2_Ramos.service.TrabajadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    private final TrabajadorService service;

    public TrabajadorController(TrabajadorService productoService) {
        this.service = productoService;
    }

    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("trabajadores", this.service.listarTodas());
        return "trabajadores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "form";
    }

    @PostMapping
    public String guardarPersona(@ModelAttribute Trabajador trabajador) {
        this.service.guardar(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("trabajador", this.service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID invalido" + id)));
        return "form";
    }
    // Eliminar un trabajador por su ID

    @GetMapping("/eliminar/{id}")
    public String eliminarTrabajador(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/trabajadores"; // Redirigir a la lista de trabajador después de eliminar
    }
}
