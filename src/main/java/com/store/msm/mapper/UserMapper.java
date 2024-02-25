package com.store.msm.mapper;

import com.store.msm.dto.UserDTO;
import com.store.msm.model.User;
import com.store.msm.model.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class UserMapper {
    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserDTO convertToDTO(User user) {
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        dto.setType(user.getUserType().getName());
        return dto;
    }

    public static User convertToEntity(UserDTO userDTO, UserType type) {
        User user = modelMapper.map(userDTO, User.class);
        user.setUserType(type);
        return user;
    }
}
