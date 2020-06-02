package Spring.repo;

import com.dehbi.springsoap.Role;
import com.dehbi.springsoap.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repo extends JpaRepository<User,Integer> {
    @Query("select u.Roles from User u where u.code=:code")
        public List<Role> getRolesByCode(@Param("code") int code);

}
