package Me.dio.Avana_bootcamp_2025.service;

import Me.dio.Avana_bootcamp_2025.domain.model.User;

public interface Userservice {

    User findByid(Long id);

    User create(User userToCreate);
}
