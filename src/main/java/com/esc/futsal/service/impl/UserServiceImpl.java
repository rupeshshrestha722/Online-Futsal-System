package com.esc.futsal.service.impl;




import com.esc.futsal.entity.User;
import com.esc.futsal.repository.UserRepository;
import com.esc.futsal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    Path path;
    private UserRepository userRepository;
    @Autowired
    private Environment env;


    @Autowired
    public UserServiceImpl(UserRepository uRepository) {
        this.userRepository = uRepository;

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        MultipartFile userImage = user.getUserImage();


        String uploadPath = env.getProperty("upload_folder");

        try {
            byte[] bytes = userImage.getBytes();
            path = Paths.get(uploadPath + user.getUsername() + userImage.getOriginalFilename());


            Files.write(path, bytes);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        user.setImagePath(path.toString());
        user.setUserImage(user.getUserImage());

        userRepository.save(user);

    }
    @Override
    public void editUser(User user) {

        Long id = user.getUserId();
        User eUser = userRepository.findOne(id);

        user.setImagePath(eUser.getImagePath());


        userRepository.save(user);




    }

    @Override
    public void deleteUser(long userId) {
        User user = userRepository.findOne(userId);

        File f = new File(user.getImagePath());
        if (f.exists()) {
            f.delete();
        }


        userRepository.delete(userId);

    }


    @Override
    public User getById(long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public Iterable<User> listUserByFirstName(String firstName) {

        return userRepository.getByFirstName(firstName);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).get(0);
    }


}
