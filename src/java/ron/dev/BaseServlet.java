/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ron.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import ron.dev.data.dao.Database;
import ron.dev.data.dao.DatabaseDao;

/**
 *
 * @author ACER
 */
public class BaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        DatabaseDao.init(new Database());
    }
    
}
