package org.example;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public class HelloWorld {
    public static void main(final String[] args) throws Exception {
        final VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        final Template t = ve.getTemplate("helloworld.vm");
        final VelocityContext context = new VelocityContext();
        context.put("name", "World");

        final StringWriter writer = new StringWriter();
        t.merge(context, writer);

        System.out.println(writer);
    }
}
