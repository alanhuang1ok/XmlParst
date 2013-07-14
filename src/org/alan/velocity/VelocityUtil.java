/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alan.velocity;

import java.io.StringWriter;
import org.alan.model.PacketInfo;
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

    public static void BuildFromXml(String filepath ,PacketInfo  info) {
        /* first, get and initialize an engine */
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "E:\\work\\code\\netbeans\\quanxian\\XmlParst\\src\\template");
 
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        VelocityContext context = new VelocityContext();
//context.put("date", getMyTimestampFunction());
        Template t = ve.getTemplate("hellosite.vm");

        context.put("name", "Eiffel Qiu");
        context.put("site", "http://www.j2medev.com");
        context.put("info", info);
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        /* show the World */
        System.out.println(writer.toString());
    }
}
