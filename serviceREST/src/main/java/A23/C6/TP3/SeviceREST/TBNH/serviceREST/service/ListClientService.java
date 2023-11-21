package A23.C6.TP3.SeviceREST.TBNH.serviceREST.service;

import A23.C6.TP3.SeviceREST.TBNH.serviceREST.modele.ListClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListClientService {

    @Autowired
    private ListClientRepository listClientRepository;

    public ListClientService(ListClientRepository listClientRepository) {
        this.listClientRepository = listClientRepository;
    }

    public ListClient save(ListClient listClient) {
        return listClientRepository.save(listClient);
    }

    public List<ListClient> findAll() {
        return listClientRepository.findAll();
    }
}
