package booky.tn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import booky.tn.DAOentities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName (String name);
}
