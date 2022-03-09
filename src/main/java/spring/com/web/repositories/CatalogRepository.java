package spring.com.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.com.web.entities.Catalog;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    @Query(value="SELECT * FROM catalog  Where title LIKE %?1 " , nativeQuery=true)
    List<Catalog> search(String keyword);
}