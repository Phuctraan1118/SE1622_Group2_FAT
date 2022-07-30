/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.UserCreateDto;
import form.UserCreateForm;
import form.UserDisplayForm;
import form.UserUpdateForm;
import java.util.List;

/**
 *
 * @author hungp
 */
public interface UserService {

    boolean isDupplicated(String username);

    UserCreateDto createUser(UserCreateForm form);

    UserCreateDto updateUser(UserUpdateForm form);

    boolean deleteUser(int userId);

    boolean deleteCustomer(int userId);

    List<UserDisplayForm> searchStaff(String fullName);

    List<UserDisplayForm> searchCustomer(String fullName);

    int getEndPage();

}
