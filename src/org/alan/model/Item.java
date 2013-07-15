/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alan.model;

import java.util.List;

/**
 *
 * @author alan
 */
public class Item {
    private String type;
    private String code;
    private String enumStr;
    private String text;
    private String readFunc;
    private List<Item> items;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the enumStr
     */
    public String getEnumStr() {
        return enumStr;
    }

    /**
     * @param enumStr the enumStr to set
     */
    public void setEnumStr(String enumStr) {
        this.enumStr = enumStr;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the readFunc
     */
    public String getReadFunc() {
        return readFunc;
    }

    /**
     * @param readFunc the readFunc to set
     */
    public void setReadFunc(String readFunc) {
        this.readFunc = readFunc;
    }
}
