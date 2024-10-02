package com.mycompany.respository;

import com.mycompany.user.User;
import org.springframework.data.repository.CrudRepository;

// we need to create a new java interface for the user repository
// we should have this interface extends
public interface UserRepository extends CrudRepository <User, Integer> {
    // click the repository to view the code   and you can see and this identifies some methods ,save all ,five id



    public  Long countById(Integer id);

}
