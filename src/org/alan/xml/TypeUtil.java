/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alan.xml;

/**
 *
 * @author alan
 */
public class TypeUtil {
   public static  String getType(String t){
        if(t.equals("sbyte"))
        {
            return "int64_t";
        }
        return t;
    }
   public static String getFun(String t){
        if(t.equals("int"))
        {
            return "ReadUInt";
        }
        return t;
   }
}
