package com.db.common.util;

import java.util.List;

import com.db.common.vo.PageObject;

public class PageUtil {
	// 如果一个方法向让外界直接访问，加个static
	public static <T> PageObject<T> newPageObject(int rowCount, List<T> records, int pageCurrent, int pageSize) {
		PageObject<T> po = new PageObject<T>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageSize(pageSize);
		po.setPageCurrent(pageCurrent);
		po.setPageCount((rowCount - 1) / pageSize + 1);
		return po;
	}
}
