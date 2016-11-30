package com.cyxd.bog.util.analysis.source;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.HandlerMapping;

public class JavaAnalysisHandler {

    Class<?> parentClazz;

    public JavaAnalysisHandler() {
    }

    public JavaAnalysisHandler(Class<HandlerMapping> clazz) {
	this.parentClazz = clazz;
    }

    public static void main(String[] args) {

	JavaAnalysisHandler jah = new JavaAnalysisHandler(HandlerMapping.class);

	System.out.println("Interface implements :");
	try {
	    for (Class<?> clazz : jah.getAssignedClass()) {
		System.out.println(clazz.getName());
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	System.out.println("or abstract class extends :");

    }

    private List<Class<?>> getAssignedClass() throws ClassNotFoundException {
	List<Class<?>> classes = new ArrayList<Class<?>>();
	for (Class<?> cls : getClasses()) {
	    if (parentClazz.isAssignableFrom(cls) && !parentClazz.equals(cls))
		classes.add(cls);
	}
	return classes;
    }

    private List<Class<?>> getClasses() throws ClassNotFoundException {
	String pk = parentClazz.getPackage().getName();
	String path = pk.replace(".", "/");
	ClassLoader classLoader = Thread.currentThread()
		.getContextClassLoader();
	URL url = classLoader.getResource(path);
	return getClasses(new File(url.getFile()), pk);
    }

    private List<Class<?>> getClasses(File classFile, String packageName)
	    throws ClassNotFoundException {
	List<Class<?>> classes = new ArrayList<Class<?>>();
	if (!classFile.exists())
	    return classes;
	for (File clsFile : classFile.listFiles()) {
	    if (clsFile.isDirectory())
		classes.addAll(getClasses(clsFile,
			packageName + "." + clsFile.getName()));
	    String clsFileName = clsFile.getName();
	    System.out.println("full name is" + packageName
			+ "."
			+ clsFileName.substring(0,
				clsFileName.lastIndexOf(".class")));
	    if (clsFileName.endsWith(".class"))
		classes.add(Class.forName(packageName
			+ "."
			+ clsFileName.substring(0,
				clsFileName.lastIndexOf(".class"))));
	}
	return classes;
    }
}
