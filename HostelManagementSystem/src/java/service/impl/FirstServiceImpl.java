/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import service.FirstService;

/**
 *
 * @author hungp
 */
public class FirstServiceImpl implements FirstService{

    @Override
    public Boolean login() {
        FirstDao firstDao = new FirstDao();
        
        return true;
    }
    
}
