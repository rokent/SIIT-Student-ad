package ro.sci.studentad.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ro.sci.studentad.domain.Ad;
import ro.sci.studentad.domain.SiteUser;

@Repository
public interface AdDAO extends PagingAndSortingRepository<Ad, Long> {

	Ad findById(Long id);

	Page<Ad> findByOwnerAndExpirationDateBefore(SiteUser owner, Pageable pageable);

	Ad findFirstByOrderByAddDateDesc();

}
