package prj0621;

import java.io.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MsgTagSimplehandler extends SimpleTagSupport {
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		out.println("태그내용 안녕하세요");
	}

}
