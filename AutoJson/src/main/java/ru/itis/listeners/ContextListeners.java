package ru.itis.listeners;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Артём on 02.11.2016.
 */
public class ContextListeners implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:context.xml");
        servletContextEvent.getServletContext().setAttribute("context", applicationContext);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
