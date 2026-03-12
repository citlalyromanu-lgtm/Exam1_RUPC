package com.example.Exam.Controllers; // Ajusta el paquete según tu proyecto

import com.example.Exam.Model.Habitacion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {

    // Simulamos la base de datos en memoria porque el examen prohíbe usar repositorios
    private List<Habitacion> listaHabitaciones = new ArrayList<>();

    // Constructor para inicializar los 10 registros de ejemplo
    public HabitacionController() {
        listaHabitaciones.add(new Habitacion(1, 101, "Sencilla", 500.00, true));
        listaHabitaciones.add(new Habitacion(2, 102, "Doble", 800.00, true));
        listaHabitaciones.add(new Habitacion(3, 103, "Suite", 1500.00, false));
        listaHabitaciones.add(new Habitacion(4, 201, "Sencilla", 500.00, true));
        listaHabitaciones.add(new Habitacion(5, 202, "Doble", 850.00, true));
        listaHabitaciones.add(new Habitacion(6, 203, "Familiar", 1200.00, true));
        listaHabitaciones.add(new Habitacion(7, 301, "Sencilla", 500.00, false));
        listaHabitaciones.add(new Habitacion(8, 302, "Doble", 800.00, true));
        listaHabitaciones.add(new Habitacion(9, 303, "Suite Presidencial", 3500.00, true));
        listaHabitaciones.add(new Habitacion(10, 401, "Penthouse", 5000.00, false));
    }

    // 1. Mostrar la lista (lista.html)
    @GetMapping
    public String listarHabitaciones(Model model) {
        model.addAttribute("habitaciones", listaHabitaciones);
        return "lista"; // Busca lista.html en templates
    }

    // 2. Mostrar formulario para agregar (crear.html)
    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "crear";
    }

    // Procesar el guardado
    @PostMapping("/guardar")
    public String guardarHabitacion(@ModelAttribute Habitacion habitacion) {
        // En un caso real el ID se genera solo, aquí lo tomamos del formulario
        listaHabitaciones.add(habitacion);
        return "redirect:/habitaciones";
    }

    // 3. Mostrar formulario para editar (editar.html)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Habitacion habitacionEditar = listaHabitaciones.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("habitacion", habitacionEditar);
        return "editar";
    }

    // Procesar la actualización
    @PostMapping("/actualizar")
    public String actualizarHabitacion(@ModelAttribute Habitacion habitacion) {
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            if (listaHabitaciones.get(i).getId().equals(habitacion.getId())) {
                listaHabitaciones.set(i, habitacion);
                break;
            }
        }
        return "redirect:/habitaciones";
    }

    // 4. Mostrar formulario para confirmar eliminación (eliminar.html)
    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Integer id, Model model) {
        Habitacion habitacionEliminar = listaHabitaciones.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("habitacion", habitacionEliminar);
        return "eliminar";
    }

    // Procesar el borrado
    @PostMapping("/borrar")
    public String borrarHabitacion(@ModelAttribute Habitacion habitacion) {
        listaHabitaciones.removeIf(h -> h.getId().equals(habitacion.getId()));
        return "redirect:/habitaciones";
    }
}