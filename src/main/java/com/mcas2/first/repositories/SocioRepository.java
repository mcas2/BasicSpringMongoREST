package com.mcas2.first.repositories;

import com.mcas2.first.models.SocioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "socios", path = "socios")
public interface SocioRepository extends MongoRepository<SocioModel, String> {
    List<SocioModel> findByNombre(@Param("nombre") String nombre);
    List<SocioModel> findByNombreContaining(@Param("nombre") String nombre);
    SocioModel findByDni(@Param("dni") String dni);
}
