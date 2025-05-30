package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Cliente;
import org.emiliano.elbuensaborback.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService extends BaseServiceImpl<Cliente, Long>{

    public ClienteService(ClienteRepository clienteRepository){
        super(clienteRepository);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Cliente update(Cliente entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Cliente save(Cliente entity) {
        return super.save(entity);
    }
}
