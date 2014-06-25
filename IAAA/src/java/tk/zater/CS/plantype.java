/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.zater.CS;

/**
 *
 * @author zater
 */
public class plantype {
    private int id;
    private String typename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public plantype(int id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public plantype() {
    }
    
}
