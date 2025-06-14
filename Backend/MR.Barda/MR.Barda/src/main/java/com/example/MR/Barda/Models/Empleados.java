package com.example.MR.Barda.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpleadoId")
    private Integer empleadoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuarioId", nullable = false)
    private User usuario;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "Cargo", nullable = false, length = 50)
    private String cargo;

    @Column(name = "FechaIngreso")
    private LocalDate fechaIngreso;

    /*
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorarioEmpleado> horarios = new ArrayList<>();  */

}
