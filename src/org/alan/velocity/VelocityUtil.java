/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alan.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.alan.model.Flow;
import org.alan.model.PacketInfo;
import org.alan.model.Protocol;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 *
 * @author alan
 */
public class VelocityUtil {

    public static String BuildFromXml(String filepath, PacketInfo info) {
        /* first, get and initialize an engine */
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "E:\\work\\code\\netbeans\\quanxian\\XmlParst\\src\\template");

        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        VelocityContext context = new VelocityContext();
//context.put("date", getMyTimestampFunction());
        Template t = ve.getTemplate(filepath);
        List<Flow> flows = info.getFlows();
        List<Protocol> fsList = new ArrayList<Protocol>();
        List<Protocol> tcList = new ArrayList<Protocol>();
        for (int i = 0; i < flows.size(); i++) {
            Flow getFlow = flows.get(i);
            List<Protocol> protocols = getFlow.getProtocols();
            for (int j = 0; j < protocols.size(); j++) {
                if (protocols.get(j).getType().toLowerCase().equals("cs")) {
                    tcList.add(protocols.get(j));
                } else if (protocols.get(j).getType().toLowerCase().equals("sc")) {
                    fsList.add(protocols.get(j));
                }
            }
        }
        context.put("tc", tcList);
        context.put("fs", fsList);
        context.put("info", info);
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        /* show the World */
         return writer.toString();
    }
}
