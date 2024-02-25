package com.store.msm.service;

import com.store.msm.dto.UserDTO;
import com.store.msm.exceptions.ItemExitsException;
import com.store.msm.exceptions.ItemNotFoundException;
import com.store.msm.mapper.UserMapper;
import com.store.msm.model.User;
import com.store.msm.repository.IUserRepository;
import com.store.msm.repository.IUserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserTypeRepository typeRepository;

    public UserDTO getUserByName(UserDTO requestDto) {
        User user = this.findByUsername(requestDto.getUsername());
        return UserMapper.convertToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public void createUser(UserDTO dto) {
        if (userRepository.findById(dto.getUsername()).isPresent()) {
            throw new ItemExitsException(dto.getUsername());
        }
        String type = dto.getType();
        User user = UserMapper.convertToEntity(dto,
                typeRepository.findByName(type).orElseThrow(() -> new ItemNotFoundException(type)));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findById(username).orElseThrow(() -> new ItemNotFoundException(username));
    }

    public void deleteUser(UserDTO dto) {
        User user = this.findByUsername(dto.getUsername());
        userRepository.delete(user);
    }
}
