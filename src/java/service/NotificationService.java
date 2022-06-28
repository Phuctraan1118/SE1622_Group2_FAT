/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import dto.NotificationDto;
import form.NotificationCreateForm;
import java.util.List;

/**
 *
 * @author hungp
 */
public interface NotificationService {

    NotificationDto createNoti(NotificationCreateForm form);

    NotificationDto updateNoti(NotificationCreateForm form);

    boolean deleteNoti(String userId);

    List<NotificationCreateForm> searchNoti(String notificationName);
}
