/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author NV55C
 */
@ManagedBean
@SessionScoped
public class BlockUIController extends Thread implements Serializable{

    /**
     * Creates a new instance of BlockUIController
     */
    public BlockUIController() {
    }
    private static final long serialVersionUID = 20130903L;  
  
     @Override
    public void run()  //METODO RUN PARA EL HILO
    {
           System.out.println ("SOY EL HILO 2");
           doSomething();
     }
    public void doSomething() {  
        try {  
            // simulate a long running request  
            Thread.sleep(3000);  
        } catch (Exception e) {  
            // ignore  
        }  
    }  
    
}
