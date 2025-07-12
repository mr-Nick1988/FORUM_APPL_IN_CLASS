package telran.java58.accounting.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import telran.java58.accounting.dao.UserRepository;
import telran.java58.accounting.dto.NewUserDto;
import telran.java58.accounting.dto.UpdateUserDto;
import telran.java58.accounting.dto.UserDto;
import telran.java58.accounting.model.User;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto registerUser(NewUserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto removeUser(String user) {
        User userEntity = userRepository.findById(user).orElseThrow();
        userRepository.delete(userEntity);
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto updateUser(String user, UpdateUserDto userDto) {
        User userEntity = userRepository.findById(user).orElseThrow();
        if (userDto.getFirstName() != null) {
            userEntity.setFirstName(userDto.getFirstName());
        }
        if (userDto.getLastName() != null) {
            userEntity.setLastName(userDto.getLastName());
        }
        userRepository.save(userEntity);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto addRole(String user, String role) {
        User userEntity = userRepository.findById(user).orElseThrow();
        userEntity.getRoles().add(role.toUpperCase());
        userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto deleteRole(String user, String role) {
        User userEntity = userRepository.findById(user).orElseThrow();
        userEntity.getRoles().remove(role.toUpperCase());
        userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUser(String user) {
        User userEntity = userRepository.findById(user).orElseThrow();
        return modelMapper.map(userEntity, UserDto.class);
    }
}
