package com.store.msm.service;

import com.store.msm.dto.UserDTO;
import com.store.msm.mapper.UserMapper;
import com.store.msm.model.User;
import com.store.msm.repository.IUserRepository;
import com.store.msm.repository.IUserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserTypeRepository typeRepository;

    public User createUser(UserDTO dto) {
        User user = UserMapper.convertToEntity(dto, typeRepository.findByName(dto.getType()).get());
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findById(username);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteById(username);
    }
}
