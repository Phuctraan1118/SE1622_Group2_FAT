/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.UserDao;
import dto.UserCreateDto;
import form.UserCreateForm;
import form.UserDisplayForm;
import form.UserUpdateForm;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import service.UserService;

/**
 *
 * @author hungp
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public UserCreateDto createUser(UserCreateForm userCreateForm) {
        boolean isCreated = false;
        userDao = new UserDao();
        try {
            int newId = userDao.getlastedId() + 1;
            userCreateForm.setId(String.valueOf(newId));
            isCreated = userDao.addStaff(userCreateForm);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!isCreated) {
            return null;
        }

        return getUserDto(userCreateForm);
    }

    private UserCreateDto getUserDto(UserCreateForm userCreateForm) {
        UserCreateDto userDto = new UserCreateDto();
        userDto.setUsername(userCreateForm.getUsername());
        userDto.setFullName(userCreateForm.getFullName());
        userDto.setRole(userCreateForm.getRole());
        userDto.setEmail(userCreateForm.getEmail());
        return userDto;
    }

    @Override
    public UserCreateDto updateUser(UserUpdateForm form) {
        userDao = new UserDao();
        boolean isUpdated = false;

        try {
            isUpdated = userDao.updateUser(form);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!isUpdated) {
            return null;
        }

        return getUserDto(form);
    }

    private UserCreateDto getUserDto(UserUpdateForm userUpdateForm) {
        UserCreateDto userDto = new UserCreateDto();
        userDto.setUsername(userUpdateForm.getUsername());
        userDto.setFullName(userUpdateForm.getFullName());
        userDto.setEmail(userUpdateForm.getEmail());
        return userDto;
    }

    @Override
    public boolean deleteUser(String userId) {
        boolean isDeleted = false;
        userDao = new UserDao();
        try {
            isDeleted = userDao.deleteUser(userId);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDeleted;
    }

    @Override
    public List<UserDisplayForm> searchStaff(String fullName) {
        userDao = new UserDao();
        List<UserDisplayForm> listUser = null;
        try {
            listUser = userDao.getListOfStaff(fullName);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }

    @Override
    public List<UserDisplayForm> searchCustomer(String fullName) {
        userDao = new UserDao();
        List<UserDisplayForm> listUser = null;
        try {
            listUser = userDao.getListOfCustomer(fullName);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }

    @Override
    public boolean isDupplicated(String username) {
        userDao = new UserDao();
        boolean isDupplicated = true;
        try {
            isDupplicated = userDao.checkDuplicate(username);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isDupplicated;
    }

}
