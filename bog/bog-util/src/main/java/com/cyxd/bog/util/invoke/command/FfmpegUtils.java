package com.cyxd.bog.util.invoke.command;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.util.invoke.command.FfmpegUtils
 * <li>ClassName: FfmpegUtils
 * <li>CreateDateTime: 2016年10月20日 上午10:21:45
 *
 * <p>
 * Description:调用本地环境安装的ffmpeg工具，用以视频转码支持
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see #transform(String)
 * @see #transform(String, String)
 *
 */
public class FfmpegUtils {

    // private final static String PATH =
    // "C:/Users/Administrator.PC/Downloads/videoLib/input-test.flv";
    private final static String PATH = "C:/Users/Administrator.PC/Downloads/videoLib/city.avi";
    private final static String OUTPUT_PATH = "C:/Users/Administrator.PC/Downloads/videoLib/";

    private final static String FFMPEG_PATH_WIN = "e:/ffmpeg-3.1.4-win64-static/bin/ffmpeg.exe";
    private final static String FFMPEG_PATH_INX = "ffmpeg";

    private final static String OS_NAME = "os.name";
    private final static String OS_IDENTIFIED_WIN = "win";
    private final static String OS_IDENTIFIED_INX = "inx";

    private final static String MP4_H264_SUFFIX = ".mp4";

    private final static String FILE_SEPARATOR_ALL = "/";

    private static boolean isWin() {
	return System.getProperty(OS_NAME).toLowerCase()
		.contains(OS_IDENTIFIED_WIN);
    }

    private static boolean isInx() {
	return System.getProperty(OS_NAME).toLowerCase()
		.contains(OS_IDENTIFIED_INX);
    }

    private static String buildMp4FileName(String path) {
	return path.substring(0, path.lastIndexOf(FILE_SEPARATOR_ALL))
		+ FILE_SEPARATOR_ALL + UUID.randomUUID() + MP4_H264_SUFFIX;
    }

    /**
     * <p>transform<br>
     * Description:提供转码
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param path 需要转码的视频绝对路径
     * @return 返回转码之后的视频绝对路径
     * 
     * @see #transform(String, String)
     *
     */
    public static String transform(String path) {
	return transform(path, path);
    }

    public static String transform(String sourcePath, String targetPath) {
	if (!checkfile(sourcePath)) {
	    System.out.println(sourcePath + " is not a file");
	    return null;
	}
	String rstPath = buildMp4FileName(targetPath);
	if (convertToMp4H264(sourcePath, rstPath))
	    return rstPath;
	return null;
    }

    /**
     * <p>getFFmpegPath<br>
     * Description:获取ffmpeg命令可执行地址
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @return
     * 
     * @see
     * @see
     *
     */
    private static String getFFmpegPath() {
	if (isWin())
	    return FFMPEG_PATH_WIN;
	else
	    return FFMPEG_PATH_INX;
    }

    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    /**
     * <p>convertToMp4H264<br>
     * Description:转码核心方法
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param sourceFilePath 需要转码的视频绝对路径
     * @param newFilePath 存放转码后的路径
     * @return 转码是否成功
     * 
     * @see #transform(String, String)
     *
     */
    private static boolean convertToMp4H264(String sourceFilePath,
	    String newFilePath) {
	if (!checkfile(sourceFilePath)) {
	    System.out.println(sourceFilePath + " is not a file");
	    return false;
	}
	List<String> command = new java.util.ArrayList<String>();
	command.add(getFFmpegPath());
	command.add("-i");
	command.add(sourceFilePath);
	command.add("-crf");
	command.add("18");
	command.add("-y");
	command.add(newFilePath);
	try {
	    Process videoProcess = new ProcessBuilder(command)
		    .redirectErrorStream(true).start();
	    new PrintStream(videoProcess.getErrorStream()).start();
	    new PrintStream(videoProcess.getInputStream()).start();
	    videoProcess.waitFor();
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    private static boolean process() {
	int type = checkContentType();
	boolean status = false;
	if (type == 0) {
	    status = processFLV(PATH);// 直接将文件转为flv文件
	} else if (type == 1) {
	    String avifilepath = processAVI(type);
	    if (avifilepath == null)
		return false;// avi文件没有得到
	    status = processFLV(avifilepath);// 将avi转为flv
	}
	return status;
    }

    private static int checkContentType() {
	String type = PATH.substring(PATH.lastIndexOf(".") + 1, PATH.length())
		.toLowerCase();
	// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	if (type.equals("avi")) {
	    return 0;
	} else if (type.equals("mpg")) {
	    return 0;
	} else if (type.equals("wmv")) {
	    return 0;
	} else if (type.equals("3gp")) {
	    return 0;
	} else if (type.equals("mov")) {
	    return 0;
	} else if (type.equals("mp4")) {
	    return 0;
	} else if (type.equals("asf")) {
	    return 0;
	} else if (type.equals("asx")) {
	    return 0;
	} else if (type.equals("flv")) {
	    return 0;
	}
	// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
	// 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
	else if (type.equals("wmv9")) {
	    return 1;
	} else if (type.equals("rm")) {
	    return 1;
	} else if (type.equals("rmvb")) {
	    return 1;
	}
	return 9;
    }

    private static boolean checkfile(String path) {
	File file = new File(path);
	if (!file.isFile()) {
	    return false;
	}
	return true;
    }

    // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
    private static String processAVI(int type) {
	List<String> command = new java.util.ArrayList<String>();
	command.add("e:\\mencoder");
	command.add(PATH);
	command.add("-oac");
	command.add("lavc");
	command.add("-lavcopts");
	command.add("acodec=mp3:abitrate=64");
	command.add("-ovc");
	command.add("xvid");
	command.add("-xvidencopts");
	command.add("bitrate=600");
	command.add("-of");
	command.add("avi");
	command.add("-o");
	command.add("c:\\home\\a.avi");
	try {
	    ProcessBuilder builder = new ProcessBuilder();
	    builder.command(command);
	    builder.start();
	    return "c:\\home\\a.avi";
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    private static boolean processFLV(String oldfilepath) {
	if (!checkfile(PATH)) {
	    System.out.println(oldfilepath + " is not file");
	    return false;
	}
	List<String> command = new java.util.ArrayList<String>();
	command.add("e:/ffmpeg-3.1.4-win64-static/bin/ffmpeg.exe");
	command.add("-i");
	command.add(oldfilepath);
	command.add("-ab");
	command.add("64");
	command.add("-acodec");
	command.add("mp3");
	command.add("-ac");
	command.add("2");
	command.add("-ar");
	command.add("22050");
	command.add("-b");
	command.add("230");
	command.add("-r");
	command.add("24");
	command.add("-y");
	command.add(OUTPUT_PATH + "/demo.mp4");
	try {
	    // ProcessBuilder builder = new ProcessBuilder();
	    Process videoProcess = new ProcessBuilder(command)
		    .redirectErrorStream(true).start();
	    new PrintStream(videoProcess.getErrorStream()).start();
	    new PrintStream(videoProcess.getInputStream()).start();
	    videoProcess.waitFor();
	    // builder.command(command);
	    // builder.start();
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    /**
     * ffmpeg将其他格式转换成其他格式文件（未指定其他任何参数）
     * ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     * 
     * @param prefix
     *            前缀
     * @param srcVideoPath
     *            视频文件(原)
     * @param middlefix
     *            中间的字符转
     * @param srcVideoPath
     *            视频文件(转换后的路径)
     * @param suffix
     *            结束的字符串
     * @return
     */
    public static boolean processFfmpegShellScript(String prefix,
	    String srcVideoPath, String middlefix, String tarVideoPath,
	    String suffix) {
	if (!checkfile(srcVideoPath)) {
	    System.out.println("【" + srcVideoPath + "】  不存在!");
	    return false;
	}

	String ffmpegPath = "";

	List<String> commend = new java.util.ArrayList<String>();

	commend.add(ffmpegPath);

	commend.add("-y");

	commend.add("-i");

	if (prefix != null && !prefix.equals("")) {
	    commend.add(prefix);
	}

	commend.add(srcVideoPath);

	if (middlefix != null && !middlefix.equals("")) {
	    commend.add(middlefix);
	}

	commend.add(tarVideoPath);

	if (suffix != null && !suffix.equals("")) {
	    commend.add(suffix);
	}

	try {
	    ProcessBuilder builder = new ProcessBuilder();
	    builder.command(commend);
	    Process process = builder.start();
	    // doWaitFor(process);
	    process.destroy();
	    if (!checkfile(tarVideoPath)) {
		System.out.println("【" + tarVideoPath
			+ "】 processFfmpegShellScript  转换不成功 !");
		return false;
	    }
	    return true;
	} catch (Exception e) {
	    System.out.println("【" + srcVideoPath
		    + "】 processFfmpegShellScript  转换不成功 !");
	    return false;
	}
    }

}

class PrintStream extends Thread {
    java.io.InputStream __is = null;

    public PrintStream(java.io.InputStream is) {
	__is = is;
    }

    public void run() {
	try {
	    while (this != null) {
		int _ch = __is.read();
		if (_ch != -1)
		    System.out.print((char) _ch);
		else
		    break;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
