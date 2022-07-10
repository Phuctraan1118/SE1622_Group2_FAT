/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.RegulationDao;
import dto.RegulationDto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import service.RegulationService;

/**
 *
 * @author hungp
 */
public class RegulationServiceImpl implements RegulationService {

    private RegulationDao regulationDao;

    @Override
    public List<RegulationDto> getAllRegulation() {
        regulationDao = new RegulationDao();
        List<RegulationDto> listRegulation = null;
        try {
            listRegulation = regulationDao.getRegulations();
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRegulation;
    }
}
