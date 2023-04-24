package com.infina.MonetaFrontEnd.utils;


import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;

@ManagedBean (name ="monetaUtilsImpl")
public class MonetaUtilsImpl implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5149738690197819799L;


	private Date date;
	
	public Date getDate() {
		date = GregorianCalendar.getInstance().getTime();
		return date;
	}

}