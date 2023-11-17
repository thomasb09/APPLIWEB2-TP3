package A23.C6.TP3.ServiceREST.tbnh.A23.C6.TP3.ServiceREST.tbnh.modele;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListClientRepository extends CrudRepository<ListClient, Long> {

    List<ListClient> findAll();
}
