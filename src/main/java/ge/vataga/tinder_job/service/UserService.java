package ge.vataga.tinder_job.service;

import ge.vataga.tinder_job.entity.User;
import ge.vataga.tinder_job.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(String username, String password, String name, String role, String skills) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setRole(role);
        user.setSkills(skills);
        return userRepository.save(user);
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(Integer userId, String name, String role, String skills) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setName(name);
            user.setRole(role);
            user.setSkills(skills);
            return userRepository.save(user);
        }
        return null;
    }

    @Transactional
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
