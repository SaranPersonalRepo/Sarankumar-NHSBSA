package com.nhs.framework.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.nhs.framework.reusableComponents.NHSConstants;
/***
 * 
 * @author Sarankumar
 * Description - Below LoggerHelper class is responsible initialize logger
 *
 */
@SuppressWarnings("rawtypes")
public class LoggerHelper {


	private static boolean root = false;

	public static Logger getLogger(Class clas){
		if (root) {
			return Logger.getLogger(clas);
		}
		PropertyConfigurator.configure(NHSConstants.log4jPropertyFilePath);
		root = true;
		return Logger.getLogger(clas);
	}


}
