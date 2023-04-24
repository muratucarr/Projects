package com.infina.MonetaFrontEnd.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MonetaUtilsImpl {


	public String getDate() {
		Date plsComeDate = Calendar.getInstance().getTime();
		DateFormat dateform = new SimpleDateFormat("dd-MM-yyyy");
		return dateform.format(plsComeDate);
	}

}