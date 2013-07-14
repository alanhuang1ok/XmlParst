/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alan.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan
 */
public class Flow {

    private List<Protocol> protocols=new ArrayList<Protocol>();

    /**
     * @return the protocols
     */
    public List<Protocol> getProtocols() {
        return protocols;
    }

    /**
     * @param protocols the protocols to set
     */
    public void setProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
    }
}
