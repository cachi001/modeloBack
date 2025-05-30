package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Empleado;
import org.emiliano.elbuensaborback.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService extends BaseServiceImpl<Empleado, Long>{

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        super(empleadoRepository);
    }

    @Override
    public Empleado save(Empleado entity) {
        return super.save(entity);
    }

    @Override
    public Empleado update(Empleado entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Empleado> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Empleado> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
