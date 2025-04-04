package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    // public User handleGetUser(long user) {
    // return this.userRepository.save(user);
    // }

    public User handleFetchUserById(long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<User> fetchAllUser() {
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User pUser) {
        User currentUser = this.handleFetchUserById(pUser.getId());
        if (currentUser != null) {
            currentUser.setEmail(pUser.getEmail());
            currentUser.setName(pUser.getName());
            currentUser.setPassword(pUser.getPassword());

            currentUser = this.userRepository.save(currentUser);

        }

        return currentUser;
    }

}
