package me.cain.cfbanner;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CFLogger {
	private static String actionLog = "plugins" + File.separator + "CFBanner"
			+ File.separator + "CFBanner.log";
	private static final DateFormat df = new SimpleDateFormat(
			"yyyy.MM.dd hh:mm:ss ");
	private static String errorLog = "plugins" + File.separator + "CFBanner"
			+ File.separator + "Errors.log";
	private CFBanner parent;

	public CFLogger(CFBanner parentPlugin) {
		this.parent = parentPlugin;
		String pluginFolder = "plugins" + File.separator + "CFBanner";
		if (parentPlugin.getDataFolder() != null) {
			pluginFolder = parentPlugin.getDataFolder().getPath();
		}
		actionLog = pluginFolder + File.separator + "CFBanner.log";
		errorLog = pluginFolder + File.separator + "Errors.log";
	}

	private boolean ErrorLogger(Exception e) {
		try {
			FileWriter fw = new FileWriter(errorLog, true);
			PrintWriter pw = new PrintWriter(fw, false);
			pw.println("--- Error " + e.getMessage() + " at "
					+ df.format(new Date()) + " ---");
			e.printStackTrace(pw);
			pw.println("--- END of Error ---");
			pw.close();
			fw.close();
			return true;
		} catch (Exception e2) {
		}
		return false;
	}

	public void write(Exception e) {
		write(e, true);
	}

	public void write(Exception e, boolean print) {
		if (print) {
			e.printStackTrace();
		}
		if (CFBanner.config.getBoolean("config.logerrors", true)) {
			ErrorLogger(e);
		}
	}

	public void write(String msg) {
		write(actionLog, msg);
	}

	public void write(String file, String msg) {
		parent.console.info("[CFBanner] "+msg);
		try {
			String currentTime = df.format(new Date());
			FileWriter fw = new FileWriter(file, true);
			fw.write(currentTime + " " + msg
					+ System.getProperty("line.separator", "\r\n"));

			fw.flush();
			fw.close();
		} catch (Exception e) {
			ErrorLogger(e);
		}
	}

}