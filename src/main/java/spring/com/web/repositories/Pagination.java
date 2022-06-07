package spring.com.web.repositories;

import org.springframework.data.domain.Page;
import spring.com.web.entities.Catalog;

public interface Pagination {
    Page<Catalog> findByPagination(int pageNo, int size);
}
