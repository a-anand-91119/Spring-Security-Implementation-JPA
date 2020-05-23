package in.notyouraveragedev.jpasecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.notyouraveragedev.jpasecurity.models.User;

@Repository
public interface MyRepository extends JpaRepository<User, Long>{

	// implementation for this method will be created automatically by jpa
	public User findByUsername(String username);
}
