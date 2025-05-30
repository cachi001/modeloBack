package org.emiliano.elbuensaborback.service;

import org.emiliano.elbuensaborback.entity.DetallePedido;
import org.emiliano.elbuensaborback.repository.DetallePedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService extends BaseServiceImpl<DetallePedido, Long>{


    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository)
    {
        super(detallePedidoRepository);
    }

    @Override
    public DetallePedido save(DetallePedido entity) {
        return super.save(entity);
    }

    @Override
    public DetallePedido update(DetallePedido entity, Long aLong) {
        return super.update(entity, aLong);
    }

    @Override
    public Optional<DetallePedido> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<DetallePedido> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
