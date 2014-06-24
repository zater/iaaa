package tk.zater.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Random;

/**
 *
 * @author zater
 */
public class CreateFileName {

    StringBuffer buf=new StringBuffer();

    public String GetName(String ip) {
        splitip(ip);
        setTimer();
        setRand();
        return buf.toString();

    }

    public void setTimer() {
        buf.append(new Date().getTime());
        

    }

    public void setRand() {
        Random rd = new Random();
        buf.append(rd.nextInt(10000));
    }

    public void splitip(String ip) {
        String sp[] = ip.split("\\.");
        for (int i = 0; i < sp.length; i++) {
            buf.append(addzero(sp[i]));
        }

    }

    public String addzero(String id) {
        StringBuffer buf2 = new StringBuffer();
        for (int i = id.length(); i < 3; i++) {
            buf2.append("0");
        }
        buf2.append(id);
        return buf2.toString();
    }

    
}
