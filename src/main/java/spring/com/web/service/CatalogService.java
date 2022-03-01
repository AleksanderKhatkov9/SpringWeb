package spring.com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.com.web.entities.Catalog;
import spring.com.web.repositories.CatalogRepository;

import java.util.List;

@Service
@Transactional
public class CatalogService {

    @Autowired
    private CatalogRepository repo;

    public List<Catalog> listAll() {
        return repo.findAll();
    }

    public void save(Catalog catalog) {
        repo.save(catalog);
    }

    public Catalog get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
