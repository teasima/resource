/*
 * Created: 2013-9-27
 * This software consists of contributions made by concox R&D.
 * @author: Li Zhongjie
 * JsonUtils.java
 */
package guru.springframework.util;

import java.text.SimpleDateFormat;
import java.util.Map;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonUtils {

	private static ObjectMapper mapper;

	/**
	 * 获取ObjectMapper实例
	 * 
	 * @param createNew
	 *            方式：true，新实例；false,存在的mapper实例
	 * @return
	 */
	public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
		if (createNew) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		//	mapper.setSerializationInclusion(Inclusion.NON_NULL);
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			return mapper;
		} else if (mapper == null) {
			mapper = new ObjectMapper();
			mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		//	mapper.setSerializationInclusion(Inclusion.NON_NULL);
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		}
		return mapper;
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param obj
	 *            准备转换的对象
	 * @return json字符串
	 * @throws Exception
	 */
	public static String beanToJson(Object obj) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(false);
			String json = objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param obj
	 *            准备转换的对象
	 * @param createNew
	 *            ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return json字符串
	 * @throws Exception
	 */
	public static String beanToJson(Object obj, Boolean createNew) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(createNew);
			String json = objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 将json字符串转换成java对象
	 * 
	 * @param json
	 *            准备转换的json字符串
	 * @param cls
	 *            准备转换的类
	 * @return
	 * @throws Exception
	 */
	public static Object jsonToBean(String json, Class<?> cls) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(false);
			Object vo = objectMapper.readValue(json, cls);
			return vo;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 将JsonNode转换成java对象
	 * 
	 * @param json
	 *            准备转换的json字符串
	 * @param cls
	 *            准备转换的类
	 * @return
	 * @throws Exception
	 */
	public static Object jsonToBean(JsonParser json, JavaType javaType) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(false);
			Object vo = objectMapper.readValue(json, javaType);
			return vo;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 将json字符串转换成java对象
	 * 
	 * @param json
	 *            准备转换的json字符串
	 * @param cls
	 *            准备转换的类
	 * @return
	 * @throws Exception
	 */
	public static Object jsonToBean(JsonParser json, Class<?> cls) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(false);

			Object vo = objectMapper.readValue(json, cls);
			return vo;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 将json字符串转换成java对象
	 * 
	 * @param json
	 *            准备转换的json字符串
	 * @param cls
	 *            准备转换的类
	 * @param createNew
	 *            ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return
	 * @throws Exception
	 */
	public static Object jsonToBean(String json, Class<?> cls, Boolean createNew) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(createNew);
			Object vo = objectMapper.readValue(json, cls);
			return vo;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * String对象转成JsonNode对象
	 * 
	 * @author lizhongjie create date 2013-10-10
	 * @param jsonStr
	 * @return
	 */
	public static JsonNode getData(String jsonStr) throws Exception {
		ObjectMapper objectMapper = getMapperInstance(false);
		try {
			JsonNode node = objectMapper.readValue(jsonStr, JsonNode.class);
			return node;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @author lizhongjie create date 2013-10-10
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @return
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		ObjectMapper mapper = getMapperInstance(false);
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	/**
	 * bean to map
	 *
	 * @author Alex
	 */
	public static Map<String, Object> getMapValue(Object myBean) {
		ObjectMapper m = new ObjectMapper();
		Map<String, Object> props = m.convertValue(myBean, Map.class);
		return props;
	}
}
