package org.emiliano.elbuensaborback.mapper;

import org.emiliano.elbuensaborback.dto.ImagenArticuloRequest;
import org.emiliano.elbuensaborback.entity.ImagenArticulo;
import org.mapstruct.*;

@Mapper(componentModel= "spring", builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ImagenArticuloMapper {


    public abstract ImagenArticulo toEntity (ImagenArticuloRequest dto);

}

