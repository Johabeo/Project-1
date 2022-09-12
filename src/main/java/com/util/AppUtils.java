package com.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AppUtils {
	
	public static String getStackTrace(Throwable t) {
	    StringWriter sw = new StringWriter();
	    t.printStackTrace(new PrintWriter(sw));
	    return sw.toString();
	}

}
