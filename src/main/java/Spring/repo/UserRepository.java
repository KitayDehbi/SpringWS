package Spring.repo;


import com.dehbi.springsoap.Role;
import com.dehbi.springsoap.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<Integer, User> users = new HashMap<>();

    @Autowired
    private  Repo userRep ;
    @PostConstruct
    public void initData() {
        List<User> list= userRep.findAll();
        for (User u : list){
            users.put(u.getCode(),u);
        }
    }
    public User findUser(int code) {
        return users.get(code);
    }

    public List<Role> findRoles(int code) {
        return userRep.getRolesByCode(code);
    }
}
