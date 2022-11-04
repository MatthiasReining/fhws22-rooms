package de.fhws.basics;

import java.util.Enumeration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class TimeoutListener implements HttpSessionListener {

	public void sessionDestroyed(HttpSessionEvent se) {

		System.out.println("session destroyed");
		
		Enumeration<String> attrs = se.getSession().getAttributeNames();
		
		while (attrs.hasMoreElements()) {
			String name = attrs.nextElement();
			System.out.println("name: " + name + " value: " + se.getSession().getAttribute(name));
			
		}
	}

}
