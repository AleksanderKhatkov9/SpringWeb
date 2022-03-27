package spring.com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.com.web.entities.Catalog;
import spring.com.web.repositories.CatalogRepository;
import spring.com.web.repositories.Pagination;

import java.util.List;

@Service
@Transactional
public class CatalogService implements Pagination {

    @Autowired
    private CatalogRepository repo;

    public List<Catalog> listAll(String keyword) {
        if(keyword !=null){
            return repo.search(keyword);
        }
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


    @Override
    public Page<Catalog> findByPagination(int pageNo, int size) {
            // TODO Auto-generated method stub
            Pageable pageable = PageRequest.of(pageNo-1,size);
            return repo.findAll(pageable);
    }
}
