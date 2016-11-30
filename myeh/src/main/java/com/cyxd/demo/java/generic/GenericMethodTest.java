package com.cyxd.demo.java.generic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class GenericMethodTest {

    private static final JsonNodeFactory factory = new JsonNodeFactory(false);

    public static void main(String[] arags) {
	Demo<Double> d = new Demo<Double>();

	d.method(3.4);

	Demo.staticMethod("ddddd");

	d.show("haha");
	d.show("oooo");

	d.print(new Integer(4));

	String jsonStr = "{\"code\":200,\"tinfos\":[{\"tname\":\"aa\",\"announcement\":\"aa\",\"owner\":\"v4\",\"maxusers\":50,\"joinmode\":1,\"tid\":3083,\"intro\":\"test\",\"size\":3,\"custom\":\"\",\"mute\":true, \"admins\":[\"v3\"],\"members\":[\"v1\",\"v2\"]},{\"tname\":\"bb\",\"announcement\":\"bb\",\"owner\":\"v4\",\"maxusers\":50,\"joinmode\":1,\"tid\":3084,\"intro\":\"test\",\"size\":3,\"custom\":\"\",\"mute\":false, \"admins\":[\"v3\"],\"members\":[\"v1\",\"v2\"]}]}";

	// ObjectMapper mapper = new ObjectMapper();
	// try {
	// JsonNode root = mapper.readTree(jsonStr);
	// System.out.println(root.get("infos").toString());
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// ObjectNode objNode = factory.objectNode();
	// objNode.putObject(jsonStr);
	//
	// System.out.println(objNode.get(0));
	//
	// System.out.println(objNode.get("\"infos\""));
	//
	// JSONObject json = new JSONObject(jsonStr);
	// System.out.println(json.getJSONArray("json"));
	// System.out.println(json.getString("infos"));
	// System.out.println(json.getJSONObject("infos"));

//	ObjectMapper mapper = new ObjectMapper();
//	try {
//	    JsonNode root = mapper.readTree(jsonStr);
//	    String[] ids = GenericMethodTest.<String>getArraysByIdentifiedChar(root.get("infos"),
//		    "tid");
//	    System.out.println(ids == null);
//	    for (String string : ids) {
//		System.out.println(string);
//	    }
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
	
	
	if(StringUtils.isNotEmpty(jsonStr)){
	    ObjectMapper mapper = new ObjectMapper();
		try {
		    JsonNode root = mapper.readTree(jsonStr);
		    JsonNode r2 = root.get("tinfos");
		    System.out.println("r2 -->" + r2);
		    JsonNode mem = r2.get(0).get("members");
		    if(mem.isArray()){
			List<String> ids = new ArrayList<String>();
			Iterator<JsonNode> iter = mem.elements();
			while(iter.hasNext()){
			    ids.add(iter.next().toString());
			}
			System.out.println(ids);
			String[] ids2 = ids.toArray(new String[ids.size()]);
			Objects.requireNonNull(ids2);
			for (String string : ids2) {
			    System.out.println(string);
			}
			System.out.println(ids2);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

    }
    
    private static String[] getArraysByIdentifiedChar(final JsonNode json, final String identifiedChar) {
	Iterator<JsonNode> iter = json.iterator();
	StringBuilder sbu = new StringBuilder(10);
	while (iter.hasNext()) {
	    JsonNode jit = iter.next();
	    System.out.println("jit -->" + jit + " -->" + jit.get(identifiedChar));
	    sbu.append(jit.get(identifiedChar)).append(",");
	}
	if(sbu.toString().contains(",")){
	    sbu = new StringBuilder(sbu.substring(0, sbu.length()-1));
	    return sbu.toString().split(",");
	}else{
	    return null;
	}
    }

}

class MyGenericMethod<T> {

    @SuppressWarnings("unchecked")
    public T newGeneric() {
	return (T) new ArrayList<T>();
    }

}

class Demo<T> {
    public void method(T t) {
	System.out.println("method :" + t);
    }

    public static <W> void staticMethod(W w) {
	System.out.println("staticMethod :" + w);
    }

    public <K> void show(String str) {
	System.out.println("Show :" + str);
    }

    public <Q> void print(Q q) {
	System.out.println("Print :" + q);
    }
}
