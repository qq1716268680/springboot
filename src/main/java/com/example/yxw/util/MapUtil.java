package com.example.yxw.util;

import java.util.*;

/**
 * 字符串工具
 *
 */
public class MapUtil {

	/**
	 * 判断数据对象是否为Map
	 * 
	 * @param data 判断对象
	 * @return 是否是map
	 */
	public static boolean isMap(Object data) {
		if (data == null) {
			return false;
		} else {
			return data instanceof Map;
		}
	}

	/**
	 * Map判空
	 * 
	 * @param data map对象
	 * @return 是否为空
	 */
	public static boolean isEmpty(Map data) {
		boolean isEmpty = true;
		if (data != null && data.size() > 0) {
			isEmpty = false;
		}
		return isEmpty;
	}

	/**
	 * Map判非空
	 * 
	 * @param data map对象
	 * @return 是否不为空
	 */
	public static boolean isNotEmpty(Map data) {
		return !isEmpty(data);
	}

    /**
     * 对MAP集合按VALUE值进行排序
     * @param map map
     * @return map
     */
	public static Map sortByValue(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());

			}
		});
		Map result = new LinkedHashMap();

		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	/**
	 * 根据Value取Key
	 * @param map
	 * @param value
	 * @return String
	 */
	public static String getKeyByValue(Map map, String value) {
		String keys="";
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object obj = entry.getValue();
			if (obj != null && (obj.equals(value))) {
				keys=(String) entry.getKey();
			}
		}
		return keys;
	}

}
