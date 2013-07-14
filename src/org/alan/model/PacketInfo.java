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
public class PacketInfo {
    private List<Flow> flows = new ArrayList<Flow>();

    /**
     * @return the flows
     */
    public List<Flow> getFlows() {
        return flows;
    }

    /**
     * @param flows the flows to set
     */
    public void setFlows(List<Flow> flows) {
        this.flows = flows;
    }
}
 
