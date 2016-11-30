package com.cyxd.bog.base.dao.ext;

import org.apache.commons.lang3.StringUtils;

public class HumpToUnderLineFormat implements TableFormat {

    @Override
    public String getTableName(String type) {
//	return type.toUpperCase();
	return type.toLowerCase();
    }

    @Override
    public String getId() {
	return StringUtils.EMPTY;
    }

    @Override
    public String getColumnName(String filed) {
	return filed.toUpperCase();
    }

}
