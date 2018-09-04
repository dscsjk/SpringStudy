package prj0626;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestContextListener
 *
 */
@WebListener
public class TestContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("book서비스가 종료되었어요. 안녕히가세요..");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("book서비스가 시작되었어요. 안녕하세요..");
    	ServletContext ctx = sce.getServletContext();
    	
    	Book mybook = new Book("자바웹프로그래밍","황희정",20000,"한빛미디어");
    	ctx.setAttribute("book", mybook);
    	System.out.println("TestContextListener 시작됨..");
    	
    }
	
}
