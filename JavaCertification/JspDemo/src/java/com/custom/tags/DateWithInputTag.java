package com.custom.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class DateWithInputTag extends SimpleTagSupport {

	private String format;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<h3>Custom Date: " + new SimpleDateFormat(format).format(new Date()) + "</h3>");
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
