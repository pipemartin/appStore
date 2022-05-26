/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import javax.ejb.Stateless;
import models.User;

public interface UserService {
    public User validateUser(String user, String pwd);
    
}
