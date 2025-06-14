package com.example.MR.Barda.Service.Impl;

import com.example.MR.Barda.Models.Empleados;
import com.example.MR.Barda.Repo.IEmpleadoRepo;
import com.example.MR.Barda.Repo.IGenericRepo;
import com.example.MR.Barda.Service.IEmpleadoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Flow;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class EmpleadoService extends GenericService<Empleados, Integer> implements IEmpleadoService {
    private final IEmpleadoRepo repo;

    @Override
    protected IGenericRepo<Empleados, Integer> getRepo() {
        return repo;
    }
}
