package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Empresa;
import org.emiliano.elbuensaborback.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService extends BaseServiceImpl<Empresa, Long>{

    public EmpresaService(EmpresaRepository empresaRepository)
    {
        super(empresaRepository);
    }

    @Override
    public Empresa save(Empresa entity) {
        return super.save(entity);
    }

    @Override
    public Empresa update(Empresa entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Empresa> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Empresa> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
