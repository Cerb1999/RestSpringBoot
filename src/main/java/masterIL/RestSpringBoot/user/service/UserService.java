package masterIL.RestSpringBoot.user.service;

import masterIL.RestSpringBoot.user.model.User;
import masterIL.RestSpringBoot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public List<User> listAllUsersByLastname(String lastname) {
        return userRepository.findAllByLastname(lastname);
    }

    public User addUser(User u) {
        return userRepository.save(u);
    }

    public void updateUser(String id, User u) {
        User buser = userRepository.findUserById(id);
        buser.setFirstname(u.getFirstname());
        buser.setLastname(u.getLastname());
        buser.setCivility(u.getCivility());
        userRepository.save(buser);
    }

    public User getById(String id) {
        return userRepository.findUserById(id);
    }

    public void removeUser(String id) {
        userRepository.deleteById(id);
    }
}
