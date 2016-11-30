package com.cyxd.bog.base.dao.ext;

import static com.cyxd.bog.base.dao.ext.util.ReflectionUtils.getAllFields;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.cyxd.bog.base.dao.ext.annotation.Column;
import com.cyxd.bog.base.dao.ext.annotation.Table;

public class MySqlProvider {
    
    private TableFormat tableFormat;

    public String insert(Object bean) {
	Class<?> beanClass = bean.getClass();
	String tableName = getTableName(beanClass);
	Field[] fields = getAllFields(beanClass);
	StringBuilder insertSql = new StringBuilder();
	List<String> insertParas = new ArrayList<String>();
	List<String> insertParaNames = new ArrayList<String>();
	insertSql.append("INSERT INTO ").append(tableName).append("(");
	try {
	    for (int i = 0; i < fields.length; i++) {
		Field field = fields[i];
		Column column = field.getAnnotation(Column.class);
		String columnName = "";
		if (column != null) {
		    if (!column.required())
			continue;
		    // columnName = column.value();
		    columnName = field.getName();
		} else {
		    continue;
		}
		if (StringUtils.isEmpty(columnName)) {
		    columnName = tableFormat.getColumnName(field.getName());
		}
		field.setAccessible(true);
		if (field.get(bean) != null) {
		    insertParaNames.add(columnName);
		    insertParas.add("#{" + field.getName() + "}");
		}
	    }
	} catch (Exception e) {
	    new RuntimeException("get insert sql is exceptoin:" + e);
	}
	for (int i = 0; i < insertParaNames.size(); i++) {
	    insertSql.append(insertParaNames.get(i));
	    if (i != insertParaNames.size() - 1)
		insertSql.append(",");
	}
	insertSql.append(")").append(" VALUES(");
	for (int i = 0; i < insertParas.size(); i++) {
	    insertSql.append(insertParas.get(i));
	    if (i != insertParas.size() - 1)
		insertSql.append(",");
	}
	insertSql.append(")");
	return insertSql.toString();
    }

    public String update(Object bean) {
	Class<?> beanClass = bean.getClass();
	String tableName = getTableName(beanClass);
	Field[] fields = getAllFields(beanClass);
	StringBuilder updateSql = new StringBuilder();
	updateSql.append(" update ").append(tableName).append(" set ");
	try {
	    for (int i = 0; i < fields.length; i++) {
		Field field = fields[i];
		Column column = field.getAnnotation(Column.class);
		String columnName = "";
		if (column != null) {
		    if (!column.required())
			continue;
		    // columnName = column.value();
		    columnName = field.getName();
		} else {
		    continue;
		}
		if (StringUtils.isEmpty(columnName)) {
		    columnName = tableFormat.getColumnName(field.getName());
		}
		field.setAccessible(true);
		if (field.get(bean) != null) {
		    updateSql.append(columnName).append("=#{")
			    .append(field.getName()).append("}");
		    if (i != fields.length - 1) {
			updateSql.append(",");
		    }
		}
	    }
	} catch (Exception e) {
	    new RuntimeException("get update sql is exceptoin:" + e);
	}
	updateSql.append(" where ").append(tableFormat.getId() + " =#{id}");
	return updateSql.toString();
    }

    public String delete(Object bean) {
	Class<?> beanClass = bean.getClass();
	String tableName = getTableName(beanClass);
	Field[] fields = getAllFields(beanClass);
	StringBuilder deleteSql = new StringBuilder();
	deleteSql.append(" delete from ").append(tableName).append(" where  ");
	try {
	    for (int i = 0; i < fields.length; i++) {
		Field field = fields[i];
		Column column = field.getAnnotation(Column.class);
		String columnName = "";
		if (column != null) {
		    if (!column.required())
			continue;
		    // columnName = column.value();
		    columnName = field.getName();
		} else {
		    continue;
		}
		if (StringUtils.isEmpty(columnName)) {
		    columnName = tableFormat.getColumnName(field.getName());
		}
		field.setAccessible(true);
		if (field.get(bean) != null) {
		    deleteSql.append(columnName).append("=#{")
			    .append(field.getName()).append("}");
		    if (i != fields.length - 1) {
			deleteSql.append(" and ");
		    }
		}
	    }
	} catch (Exception e) {
	    new RuntimeException("get delete sql is exceptoin:" + e);
	}
	return deleteSql.toString();
    }

    public String findFirst(Object bean) {
	return new MySqlProviderHander(bean).selectSQLBuilder();
    }

    private String getTableName(Class<?> beanClass) {
	String tableName = "";
	Table table = beanClass.getAnnotation(Table.class);
	if (table != null) {
	    tableName = table.value();
	} else {
	    tableName = tableFormat.getTableName(beanClass.getSimpleName());
	    // beanClass.getSimpleName()
	}
	return tableName;
    }

    /**
     * <p>
     * <li>ClassFullName: com.cyxd.bog.base.dao.ext.MySqlProviderHander
     * <li>ClassName: SqlParser
     * <li>CreateDateTime: 2016年10月14日 9:10:57
     *
     * <p>
     * Description:{@link MySqlProvider}
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     *
     * @see
     * @see
     *
     */
    class MySqlProviderHander {
	private Object bean;
	private Class<?> beanClass;

	private Field[] fields;
	private int filedLength;
	private StringBuilder sqlStr;
	private String tableName;

	private TableFormat tableFormat = new HumpToUnderLineFormat();

	private MySqlProviderHander() {
	}

	private MySqlProviderHander(Object bean) {
	    this.bean = bean;
	    this.beanClass = this.bean.getClass();
	    this.tableName = getTableName();
	    this.fields = getAllFields(this.beanClass);
	    this.filedLength = this.fields.length;
	}

	/**
	 * <p>
	 * selectSQLBuilder<br>
	 * Description:拼接查询sql
	 *
	 * @author Slil
	 * @version 1.0.0
	 * @since 1.0.0
	 * 
	 * @return 查询sql
	 * 
	 */
	private String selectSQLBuilder() {
	    List<String> selectParaNames = new ArrayList<String>();
	    List<String> selectParas = new ArrayList<String>();
	    sqlStr.append("select ");
	    try {
		for (int i = 0; i < filedLength; i++) {
		    Field field = fields[i];
		    if (notColumn(field))
			continue;

		    Column column = field.getAnnotation(Column.class);
		    String columnName = "";
		    if (column != null) {
			if (!column.required())
			    continue;
			// columnName = column.value();
			columnName = field.getName();
		    } else {
			continue;
		    }
		    if (StringUtils.isEmpty(columnName)) {
			columnName = tableFormat.getColumnName(field.getName());
		    }
		    field.setAccessible(true);
		    sqlStr.append(field.getName());
		    if (i != fields.length - 1)
			sqlStr.append(",");
		    selectParaNames.add(columnName);
		    selectParas.add("#{" + field.getName() + "}");
		}
		sqlStr.append(" from ").append(tableName).append(" where ");
		for (int i = 0; i < selectParaNames.size(); i++) {
		    sqlStr.append(selectParaNames.get(i)).append("=")
			    .append(selectParas.get(i));
		    if (i != selectParaNames.size() - 1)
			sqlStr.append(" and ");
		}
	    } catch (Exception e) {
		new RuntimeException("get select sql is exceptoin:" + e);
	    }
	    return sqlStr.toString();
	}

	/**
	 * <p>
	 * getTableName<br>
	 * Description: model {@link Table} {@link Table#value()},
	 *
	 * @author Slil
	 * @version 1.0.0
	 * @since 1.0.0
	 * 
	 * @return model 名称
	 * 
	 * @see
	 * @see
	 *
	 */
	private String getTableName() {
	    String tableName = "";
	    Table table = beanClass.getAnnotation(Table.class);

	    if (table != null) {
		tableName = table.value();
	    } else {
		tableName = tableFormat.getTableName(beanClass.getSimpleName());
		// beanClass.getSimpleName()
	    }
	    return tableName;
	}

	/**
	 * <p>
	 * isColumn<br>
	 * Description:
	 *
	 * @author Slil
	 * @version 1.0.0
	 * @since 1.0.0
	 * 
	 * @param field
	 * @return
	 * 
	 * @see
	 * @see
	 *
	 */
	private boolean isColumn(Field field) {
	    return !notColumn(field);
	}

	private boolean notColumn(Field field) {
	    return field.getAnnotation(Column.class) == null;
	}

	private String columnName(Field field) {
	    String columnName = "";
	    if (isColumn(field))
		columnName = field.getName();
	    if (StringUtils.isEmpty(columnName))
		columnName = tableFormat.getColumnName(field.getName());
	    return columnName;
	}

    }

}
