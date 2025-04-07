package Me.dio.Avana_bootcamp_2025.service.Impl;

import Me.dio.Avana_bootcamp_2025.domain.model.Repository.UserRepository;
import Me.dio.Avana_bootcamp_2025.domain.model.User;
import Me.dio.Avana_bootcamp_2025.service.Userservice;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements Userservice {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByid(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
           throw  new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreate);
    }
}
