package ro.sci.studentad.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ro.sci.studentad.domain.SiteUser;

@Repository
public interface SiteUserDAO extends CrudRepository<SiteUser, Long> {

	SiteUser findFirstByOrderByBirthDateDesc();

	SiteUser findByEmail(String email);

}
