package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingURI extends HttpServlet {

    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>();

    public void init() throws ServletException {
        // 절대경로(fullPath)의 프로퍼티파일 정보를 가져온다. 파일네임 : commandHandlerURI.properties
        String configFile = getInitParameter("configFile");
        String configFilePath = getServletContext().getRealPath(configFile);
        
        Properties prop = new Properties();
        try (FileReader fis = new FileReader(configFilePath)) {
        	// 절대경로의 프로퍼티 파일 포인터를 프로퍼티에 load한다.
            prop.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        }
        /* commandHandlerURI.properties의 내용
        	/join.do=member.command.JoinHandler
        	/login.do=auth.command.LoginHandler
        	/logout.do=auth.command.LogoutHandler
        	/changePwd.do=member.command.ChangePasswordHandler
        	/article/write.do=article.command.WriteArticleHandler
        	/article/list.do=article.command.ListArticleHandler
        	/article/read.do=article.command.ReadArticleHandler
        	/article/modify.do=article.command.ModifyArticleHandler
        */
        Iterator keyIter = prop.keySet().iterator(); // 키, 밸류값을 가져오기 위해 interator 잡기
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();	// 키값을 가져온다.
            // 키값을 가져온다. ->"/article/modify.do"
            String handlerClassName = prop.getProperty(command);
            // 키에 해당하는 밸류 즉 클래스네임을 가져온다.->"article.command.ModifyArticleHandler"
            try {
            	// 가져온 클래스 이름으로 클래스 객체 만들고 인스턴스 생성 하고 핸들러에 매핑
                Class<?> handlerClass = Class.forName(handlerClassName);
                CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
                commandHandlerMap.put(command, handlerInstance);
                
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {

		// 웹 주소 http://localhost:8080/board/article/list.do 로 들어 오는 경우
		// request.getRequestURI()의 값은 "/board/article/list.do" 가 들어 있다.
    	String command = request.getRequestURI();
		
		// request.getContextPath()의 값은 "/board" 가 들어 있다.
		if (command.indexOf(request.getContextPath()) == 0) {
			// request.getContextPath().length()의 값은 6이다.
			command = command.substring(request.getContextPath().length());
			// command의 값은 /article/list.do 이다.
		}
		
        CommandHandler handler = commandHandlerMap.get(command);
        if (handler == null) {
            handler = new NullHandler();
        }
        
        String viewPage = null;
        try {
            viewPage = handler.process(request, response);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        if (viewPage != null) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
        }
    }
}
