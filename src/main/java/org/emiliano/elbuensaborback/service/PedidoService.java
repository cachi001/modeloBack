package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.Pedido;
import org.emiliano.elbuensaborback.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService extends BaseServiceImpl<Pedido, Long>{

    public PedidoService(PedidoRepository pedidoRepository)
    {
        super(pedidoRepository);
    }

    @Override
    public Pedido save(Pedido entity) {
        return super.save(entity);
    }

    @Override
    public Pedido update(Pedido entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<Pedido> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Pedido> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
