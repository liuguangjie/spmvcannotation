package cn.springmvc.util;

import cn.springmvc.i18n.MessageSource;

import java.text.MessageFormat;
import java.util.Locale;

public class UtilMessage {

	public UtilMessage() {
	}

	public static String getMessage(String key, Locale locale) {
		if (MessageSource.getInstance() == null)
			throw new RuntimeException(
					"please use 'com.asiainfo.aiox.common.MessageSource' class instead of spring's ResourceBundleMessageSource etc.");
		try {
			return MessageSource.getInstance().getMessage(key, null, locale);
		} catch (Exception e) {
			System.out.println((new StringBuilder()).append("can't find key:'")
					.append(key).append("' in messages.").append(e).toString());
		}
		return "";
	}

	public static String getMessage(String key, Locale locale, Object args[]) {
		if (MessageSource.getInstance() == null)
			throw new RuntimeException(
					"please use 'com.asiainfo.aiox.common.MessageSource' class instead of spring's ResourceBundleMessageSource etc.");
		try {
			String message = MessageSource.getInstance().getMessage(key, null,
					locale);
			return MessageFormat.format(message, args);
		} catch (Exception e) {
			System.out.println((new StringBuilder()).append("can't find key:'")
					.append(key).append("' in messages.").append(e).toString());
			System.out.println(e);
			return "";
		}
	}
	
}