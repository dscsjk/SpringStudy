package prj0626;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncFilter
 */
@WebFilter("*.jsp")
public class EncFilter implements Filter {
	private String encoding;

    public EncFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
		*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/*
		this.encoding = fConfig.getServletContext().getInitParameter("encoding");
		System.out.println(fConfig.getServletContext().getInitParameter("encoding"));
		*/
		// TODO Auto-generated method stub
	}

}
