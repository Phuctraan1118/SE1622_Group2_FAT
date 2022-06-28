/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.NotificationDao;
import dto.NotificationDto;
import form.NotificationCreateForm;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import service.NotificationService;

/**
 *
 * @author hungp
 */
public class NotificationServerImpl implements NotificationService {

    private NotificationDao notificationDao;

    @Override
    public NotificationDto createNoti(NotificationCreateForm notificationForm) {
        boolean isCreated = false;
        notificationDao = new NotificationDao();
        try {
            isCreated = notificationDao.addNewNotification(notificationForm);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!isCreated) {
            return null;
        }

        return getNotificationDto(notificationForm);
    }

    private NotificationDto getNotificationDto(NotificationCreateForm notificationForm) {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setName(notificationForm.getName());
        notificationDto.setDetail(notificationForm.getDetail());
        notificationDto.setUsername(notificationForm.getUsername());
        return notificationDto;
    }

    @Override
    public NotificationDto updateNoti(NotificationCreateForm form) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteNoti(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NotificationCreateForm> searchNoti(String fullName) {
        notificationDao = new NotificationDao();
        List<NotificationCreateForm> listNoti = null;
        try {
            listNoti = notificationDao.getNotifications(fullName);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNoti;
    }

}
