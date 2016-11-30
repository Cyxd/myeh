package com.cyxd.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import org.xml.sax.SAXException;

public class SystemXMLUtils {
	
	/**
	 * SAX
	 */
	
	private final static String SYSTEM_CONFIG = "/configuration/system-config.xml";
	
//	private static File SYSTEM_CONFIG_FILE = new File(SYSTEM_CONFIG);
	
	private static SAXParserFactory saxParseFactory = SAXParserFactory.newInstance();
	
	private static SAXParser saxParser = null;
	
//	private static XMLReader xmlReader;
	
	/**
	 * DOM
	 */
	private final static SAXReader sax = new SAXReader();
	private static Document doc = null;
	private static Element rootEle = null;
	transient static Element currEle = null;
	
	static{
		try {
			//SAX
			saxParser = saxParseFactory.newSAXParser();
			
//			saxParser.parse(new File(SYSTEM_CONFIG), dh);
//			xmlReader = saxParser.getXMLReader();
			//DOM
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Map<String, String>> getElements(SystemXMLHandler handler){   
        try {
        	//配置文件INT流
        	InputStream ins = SystemXMLUtils.class.getClass().getResourceAsStream(SYSTEM_CONFIG);
			saxParser.parse(ins, handler);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}   
        return handler.getList();
    }
	
	/** 
	 * @Title: getUploadInfoElementById 
	 * @Description: TODO 获取文件上传的配置信息
	 * @param @param eleId
	 * @param @return     
	 * @return Map<String,String>     
	 * @throws 
	 */
	public static Map<String, String> getUploadInfoElementById(String eleId){
		SystemXMLHandler handler = new SystemXMLHandler("goods");
		//配置文件INT流
    	InputStream ins = SystemXMLUtils.class.getClass().getResourceAsStream(SYSTEM_CONFIG);
		try {
			saxParser.parse(ins, handler);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} finally{
			try {
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return handler.getList().get(0);
	}
	
	public static List<Map<String, String>> getElements(String eleName){
		SystemXMLHandler handler = new SystemXMLHandler(eleName);
		//配置文件INT流
    	InputStream ins = SystemXMLUtils.class.getClass().getResourceAsStream(SYSTEM_CONFIG);
        try {
			saxParser.parse(ins, handler);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} finally{
			try {
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return handler.getList();
    }
	
	public static String getElement4Dom(){
		//配置文件INT流
    	InputStream ins = SystemXMLUtils.class.getClass().getResourceAsStream(SYSTEM_CONFIG);
		try {
			doc = sax.read(ins);
			rootEle = doc.getRootElement();
	        return rootEle.getName() + " | " + rootEle.getNamespaceURI() + " | " + doc.getXMLEncoding() + " | " + rootEle.element("system").element("base").elementText("stage");
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally{
			try {
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return StringUtils.EMPTY;
    }
	
	/** 
	 * @Title: getElementText4Dom 
	 * @Description: TODO 使用DOM的方式，获取是指定节点的内容，
	 * 例如：一个"."代表一层
	 * 			system
	 * 			system.base.stage 表示system下面的base的下面的stage的内容
	 * @param @param eleName
	 * @param @return     如果没有内容，则会返回""
	 * @return String     
	 * @throws 
	 */
	public static String getElementText4Dom(String eleName){
		//配置文件INT流
    	InputStream ins = SystemXMLUtils.class.getClass().getResourceAsStream(SYSTEM_CONFIG);
		try {
			doc = sax.read(ins);
			rootEle = doc.getRootElement();
			Element currEle = rootEle;
			if(eleName.indexOf(".") > -1){
				for (String eleN : eleName.split("\\.")) {
					currEle = currEle.element(eleN);
				}
				for (DefaultAttribute attr : (List<DefaultAttribute>)currEle.attributes()) {
					System.out.println(attr.getName() + " | " + attr.getValue());
				}
				return currEle.getText();
			}
			return StringUtils.isBlank(currEle.elementText(eleName)) ? StringUtils.EMPTY : currEle.elementText(eleName);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally{
			try {
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return StringUtils.EMPTY;
	}
	
	public static void main(String[] args) {
		
		/**
		 * SAX 方式
		 */
		
//		for (Map<String, String> map : getElements("root-name")) {
//			for (String key : map.keySet()) {
//				System.out.println("key= " + key);
//				System.out.println("val= " + map.get(key));
//			}
//		}
		
		Map<String,String> uploadRst = getUploadInfoElementById("goods_behavior");
		for (String key : uploadRst.keySet()) {
			System.out.println("key= " + key);
			System.out.println("val= " + uploadRst.get(key));
		}
		
		/**
		 * DOM 方式 
		 */
		System.out.println(getElement4Dom());
		System.out.println(getElementText4Dom("system"));
		System.out.println(getElementText4Dom("system.base.stage"));
		System.out.println(getElementText4Dom("system.custom.upload.root"));
		
		System.out.println(getElementText4Dom("system.base.root-name"));
	}
	

}
