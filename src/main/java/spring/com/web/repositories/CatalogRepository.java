package spring.com.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.com.web.entities.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}