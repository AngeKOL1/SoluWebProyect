package com.example.MR.Barda.Controller;
import com.example.MR.Barda.Models.Empleados;
import com.example.MR.Barda.Service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleados>> getAllEmpleados() throws Exception {
        List<Empleados> empleados = empleadoService.findAll();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleados> getEmpleadoById(@PathVariable Integer id) throws Exception {
        Optional<Empleados> empleadoOpt = Optional.ofNullable(empleadoService.findById(id));
        return empleadoOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empleados> createEmpleado(@RequestBody Empleados empleado) throws Exception {
        Empleados saved = empleadoService.save(empleado);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleados> updateEmpleado(@PathVariable Integer id,
                                                   @RequestBody Empleados empleado) throws Exception {
        Optional<Empleados> updated = Optional.ofNullable(empleadoService.update(empleado, id));
        return updated
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Integer id) throws Exception {
        boolean deleted = empleadoService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
