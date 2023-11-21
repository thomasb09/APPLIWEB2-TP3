package A23.C6.TP3.SeviceREST.TBNH.serviceREST.service;

import A23.C6.TP3.SeviceREST.TBNH.serviceREST.modele.ListClient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListClientRepository extends CrudRepository<ListClient, Long> {

    List<ListClient> findAll();
}
