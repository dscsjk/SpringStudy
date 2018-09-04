package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String encoding;
	private String contentType;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding(encoding);
		res.setContentType(contentType);
		System.out.println("한글설정완료");
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}
		System.out.println("encoding값을 가져옴: "+encoding);
		contentType = config.getInitParameter("content_type");
		if (contentType == null) {
			contentType = "text/html;charset=utf-8";
		}
		System.out.println("content_type값을 가져옴: "+contentType);
	}

	@Override
	public void destroy() {
	}

}
