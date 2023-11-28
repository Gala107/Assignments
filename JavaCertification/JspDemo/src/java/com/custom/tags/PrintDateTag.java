package com.custom.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class PrintDateTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<h3>Current Date: " + new SimpleDateFormat("dd-mm-yyyy hh:mm:ss EEE").format(new Date()) + "</h3>");
	}
}
