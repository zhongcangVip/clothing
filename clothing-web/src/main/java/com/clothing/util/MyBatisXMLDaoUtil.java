package com.clothing.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.clothing.model.item.Item;
import com.clothing.model.item.ItemCategory;
import com.clothing.model.item.ItemOperator;
import com.clothing.model.item.ItemSku;
import com.clothing.model.item.ItemSupplier;
import com.clothing.model.item.ItemUnit;
import com.clothing.model.user.User;

/**
 * 生成sql及xml脚本
 * 
 * @author yangmin
 * 2018年4月18日 下午3:35:55
 */
public class MyBatisXMLDaoUtil {
	private static String tableName = "t_clothing_" + "user"; // 表名BaDistributor
	private static String projectName = "clothing"; // 项目名称
	@SuppressWarnings("rawtypes")
	private static Class className = User.class;
	public static MyBatisXMLDaoUtil object = new MyBatisXMLDaoUtil();
	private static String modelName = "";
	private static String packName = "";
	private static String packImplName = "";

	public static void main(String[] args) throws SQLException {
		tableName=tableName.toLowerCase();
		modelName = className.getSimpleName();
		packName = className.getPackage().getName();
		packImplName = className.getPackage().getName();
		packName = packName.replace("model", "dao");
		packImplName = packImplName.replace("model", "dao.impl");
		ResultSet rs = object.getResult();
		if (rs != null) {
			object.grenerateResultMap(rs);
			object.grenerateGetModelById();
			object.grenerateGetModelByList();
			object.grenerateInsertXML(rs);
			object.grenerateUpdateXML(rs);
			object.grenerateDeleteXml();
//			object.grenterateDaoFile();
//			object.grenterateDaoImplFile();
//			object.grenterateServiceFile();
//			object.grenterateServiceImplFile();
		} else {
			object.grenerateCreateTableSql();
		}
	}

	/**
	 * 生成service 文件
	 */
	private void grenterateServiceFile() {
		StringBuilder buf = new StringBuilder();
		buf.append("package ").append(packName.replace("dao", "service")).append(";\n");
		buf.append("import java.util.List;\n").append("import java.util.Map;\n")
				.append("import com.bbsuper.service.BaseService;\n").append("import ").append(className.getName())
				.append(";\n");
		buf.append("public interface " + modelName + "Service extends BaseService {\n");
		buf.append("\t public void save" + modelName + "(" + modelName + " info);\n");
		buf.append("\t public void update" + modelName + "(" + modelName + " info);\n");
		buf.append("\t public " + modelName + " get" + modelName + "ById(String id);\n");
		buf.append("\t public List<" + modelName + "> get" + modelName + "ByList(Map<String, Object> params);\n");
		buf.append("}\n");

		String path = this.getServicePath("") + "\\" + modelName + "Service.java";
		saveFile(path, buf.toString());
	}

	/**
	 * 生成daoimpl 文件
	 */
	private void grenterateServiceImplFile() {
		String path = this.getServicePath("impl") + "\\" + modelName + "ServiceImpl.java";
		StringBuilder buf = new StringBuilder();
		buf.append("package ").append(packName.replace("dao", "service")).append(".impl;\n");
		buf.append("import java.util.List;\n").append("import java.util.Map;\n")
				.append("import org.springframework.stereotype.Service;\n")
				.append("import  org.springframework.beans.factory.annotation.Autowired;\n")
				.append("import  com.bbsuper.service.impl.BaseServiceImpl;\n").append("import ")
				.append(className.getName()).append(";\n");
		buf.append("import ").append(packName.replace("dao", "service").replace(".impl", "")).append(".").append(modelName).append("Service;\n");
		buf.append("import ").append(packName).append(".").append(modelName).append("Dao;\n\n");
		buf.append("@Service(\"" + modelName + "ServiceImpl\")\n");
		buf.append("public class " + modelName + "ServiceImpl extends BaseServiceImpl implements " + modelName
				+ "Service {\n");
		buf.append("\t@Autowired\n");
		String daoName=modelName.substring(0,1).toLowerCase()+modelName.substring(1)+"dao";
		buf.append("\tprivate ").append(modelName).append("Dao ").append(daoName).append(";\n");

		buf.append("\tpublic void save" + modelName + "(" + modelName + " info){\n");
		buf.append("\t\tthis."+daoName+".save" + modelName + "(info);\n");
		buf.append("\t}\n");
		buf.append("\tpublic void update" + modelName + "(" + modelName + " info){\n");
		buf.append("\t\tthis."+daoName+".update" + modelName + "(info);\n");
		buf.append("\t}\n");
		buf.append("\tpublic " + modelName + " get" + modelName + "ById(String id){\n");
		buf.append("\t\treturn this."+daoName+".get" + modelName + "ById(id);\n");
		buf.append("\t}\n");
		buf.append("\tpublic List<" + modelName + "> get" + modelName + "ByList(Map<String, Object> params){\n");
		buf.append("\t\treturn this."+daoName+".get" + modelName + "ByList(params);\n");
		buf.append("\t}\n");
		buf.append("}\n");
		saveFile(path, buf.toString());
	}

	/**
	 * 生成dao 文件
	 */
	private void grenterateDaoFile() {
		StringBuilder buf = new StringBuilder();
		buf.append("package ").append(packName).append(";\n");
		buf.append("import java.util.List;\n").append("import java.util.Map;\n")
				.append("import com.bbsuper.dao.BaseDao;\n").append("import ").append(className.getName())
				.append(";\n");
		buf.append("public interface " + modelName + "Dao extends BaseDao {\n");
		buf.append("\t public void save" + modelName + "(" + modelName + " info);\n");
		buf.append("\t public void update" + modelName + "(" + modelName + " info);\n");
		buf.append("\t public " + modelName + " get" + modelName + "ById(String id);\n");
		buf.append("\t public List<" + modelName + "> get" + modelName + "ByList(Map<String, Object> params);\n");
		buf.append("}\n");

		String path = this.getDaoPath() + "\\" + modelName + "Dao.java";
		saveFile(path, buf.toString());
	}

	/**
	 * 生成daoimpl 文件
	 */
	private void grenterateDaoImplFile() {
		String path = this.getDaoPath() + "\\impl\\" + modelName + "DaoImpl.java";
		StringBuilder buf = new StringBuilder();
		buf.append("package ").append(packName).append(".impl;\n");
		buf.append("import java.util.List;\n").append("import java.util.Map;\n")
				.append("import org.springframework.stereotype.Repository;\n")
				.append("import com.bbsuper.dao.impl.BaseDaoImpl;\n")
				.append("import " + packName + "." + modelName + "Dao;\n").append("import ").append(className.getName())
				.append(";\n");
		buf.append("@Repository(\"" + modelName + "DaoImpl\")\n");
		buf.append("public class " + modelName + "DaoImpl extends BaseDaoImpl implements " + modelName + "Dao {\n");
		buf.append("\tpublic void save" + modelName + "(" + modelName + " info){\n");
		buf.append("\t\tthis.insert(\"" + packName+"."+modelName + "Dao.insert" + modelName + "\",info);\n");
		buf.append("\t}\n");
		buf.append("\tpublic void update" + modelName + "(" + modelName + " info){\n");
		buf.append("\t\tthis.insert(\"" + packName+"." +modelName+ "Dao.update" + modelName + "\",info);\n");
		buf.append("\t}\n");
		buf.append("\tpublic " + modelName + " get" + modelName + "ById(String id){\n");
		buf.append(
				"\t\treturn (" + modelName + ")this.selectOne(\"" + packName+"."+modelName + "Dao.get" + modelName + "ById\",id);\n");
		buf.append("\t}\n");
		buf.append("\tpublic List<" + modelName + "> get" + modelName + "ByList(Map<String, Object> params){\n");
		buf.append("\t\treturn (List<" + modelName + ">)this.selectList(\"" + packName+"." +modelName+ "Dao.get" + modelName
				+ "ByList\",params);\n");
		buf.append("\t}\n");
		buf.append("}\n");
		saveFile(path, buf.toString());
	}

	private String getDaoPath() {
		String path = System.getProperty("user.dir");
		String temp = packName.replace(".", "\\");
		path = path + "\\src\\main\\java\\" + temp;
		System.err.println(path);
		File file = new File(path);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		return path;
	}

	private String getServicePath(String st) {
		String path = System.getProperty("user.dir").replace("dao", "service");
		String temp = packName.replace(".", "\\");
		temp = temp.replace("dao", "service");
		path = path + "\\src\\main\\java\\" + temp;
		if (st != null && st.length() > 0) {
			path = path + "\\" + st;
		}
		File file = new File(path);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		System.err.println(path);
		return path;
	}

	/**
	 * 根据字段属性取类属性
	 * 
	 * @param column
	 * @return
	 */
	private Field getPropertyByColumn(String column) {
		Field[] ary = className.getDeclaredFields();
		String str = "";
		Field resultField = null;
		if (column.endsWith("id") && column.startsWith("fk")) {
			str = column.substring(2);
			str = str.substring(0, str.length() - 2);
		} else if (column.startsWith("f")) {
			str = column.substring(1);
		}
		for (int i = 0; i < ary.length; i++) {
			Field field = ary[i];
			if (str.equalsIgnoreCase(field.getName())) {
				resultField = field;
				break;
			}
		}
		return resultField;
	}

	/**
	 * 生成ResultMap
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	private void grenerateResultMap(ResultSet rs) throws SQLException {
		StringBuilder buf = new StringBuilder();
		buf.append("<resultMap id=\"").append(modelName).append("Result\"").append(" type=\"")
				.append(className.getName()).append("\" >").append("\n");
		ResultSetMetaData rm = rs.getMetaData();
		for (int i = 0; i < rm.getColumnCount(); i++) {
			Field field = getPropertyByColumn(rm.getColumnName(i + 1));
			if (field != null && (field.getType().equals(List.class) || field.getType().equals(ArrayList.class)
					|| field.getType().equals(Map.class))) {
				continue;
			}
			String fieldName = this.getFieldName(field);
			String columnName=rm.getColumnName(i + 1);
			if(columnName.equalsIgnoreCase("fid") || columnName.equalsIgnoreCase("fcu")){
				buf.append("\t<result property=\"").append(columnName.equalsIgnoreCase("fid")?"id":"cu").append("\" column=\"")
				.append(columnName).append("\" />\n");
			}else{
			buf.append("\t<result property=\"").append(fieldName == null ? "id" : fieldName).append("\" column=\"")
					.append(columnName).append("\" />\n");
			}
		}
		buf.append("</resultMap>");
		System.err.println(buf.toString());
	}

	/**
	 * 生成insert
	 * 
	 * @param rs
	 */
	private void grenerateInsertXML(ResultSet rs) throws SQLException {
		StringBuilder buf = new StringBuilder();
		buf.append("<insert id=\"insert").append(modelName).append("\" parameterType=\"").append(className.getName())
				.append("\" >\n");
		buf.append("insert into ").append(tableName).append("(");
		StringBuilder sql = new StringBuilder();
		sql.append("\nVALUES(");
		ResultSetMetaData rm = rs.getMetaData();
		for (int i = 0; i < rm.getColumnCount(); i++) {
			Field field = getPropertyByColumn(rm.getColumnName(i + 1));
			if (rm.getColumnName(i + 1).equals("FID") || rm.getColumnName(i + 1).equals("FCU") ) {
				continue;
			}
			if (field != null && (field.getType().equals(List.class) || field.getType().equals(ArrayList.class)
					|| field.getType().equals(Map.class))) {
				continue;
			}
			if(i!=0){
				sql.append(",");
				buf.append(",");
			}
			buf.append("").append(rm.getColumnName(i + 1));
			sql.append("#{").append(getFieldName(field)).append("}");
		}
		buf.append(")");
		sql.append(")");
		buf.append(sql);
		buf.append("\n</insert>\n");
		System.err.println(buf.toString());
	}

	/**
	 * 生成带条件的UPDATE
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	private void grenerateUpdateXML(ResultSet rs) throws SQLException {
		StringBuilder buf = new StringBuilder();
		buf.append("<update id=\"update").append(modelName).append("\" parameterType=\"").append(className.getName())
				.append("\" >\n");
		buf.append("\tupdate ").append(tableName).append("\n\t<set>\n");
		ResultSetMetaData rm = rs.getMetaData();
		for (int i = 0; i < rm.getColumnCount(); i++) {
			if (rm.getColumnName(i + 1).equals("FID")) {
				continue;
			}
			Field field = getPropertyByColumn(rm.getColumnName(i + 1));
			if (field != null && (field.getType().equals(List.class) || field.getType().equals(ArrayList.class)
					|| field.getType().equals(Map.class))) {
				continue;
			}
			String fieldName = getFieldName(field);
			String columnName=rm.getColumnName(i + 1);
			buf.append("\t\t<if test=\"").append(field == null ? "cu" : field.getName()).append("!=null and ")
					.append(field == null ? "cu" : field.getName()).append("!=''\">");
			buf.append(columnName).append("=").append("#{").append(field == null ? "cu" :fieldName).append("},</if>\n");
		}
		buf.append("\t</set>\n");
		buf.append("where fid=#{id}");
		buf.append("\n</update>\n");
		System.err.println(buf.toString());
	}

	/**
	 * 生成DELETEBYID
	 */
	@SuppressWarnings("static-access")
	private void grenerateDeleteXml() {
		StringBuilder buf = new StringBuilder();
		buf.append("<delete id=\"delete").append(modelName).append("ById\" ").append(" parameterType=\"string\" ")
				.append(" >\n\t");
		buf.append("delete  from ").append(this.tableName).append(" where fid=#{id}\n");
		buf.append("</delete>");
		System.err.println(buf.toString());
	}

	/**
	 * 生成SELECTBYID记录
	 */
	private void grenerateGetModelById() {
		StringBuilder buf = new StringBuilder();

		buf.append("\t").append("<select id=\"get").append(modelName).append("ById\"")
				.append(" parameterType=\"string\" ").append(" resultMap=\"").append(modelName).append("Result\" >")
				.append("\n");
		buf.append("\t\t").append(" SELECT T.* \n\t\t\tFROM ").append(tableName).append(" T where T.fid=#{id}")
				.append("\n");
		buf.append("\t</select>");
		System.err.println(buf.toString());
	}

	
	/**
	 * 生成SELECTBYList记录
	 */
	private void grenerateGetModelByList(){
		StringBuilder buf = new StringBuilder();
		
		buf.append("\t")
			.append("<select id=\"get").append(modelName).append("ByList\"")
			.append(" parameterType=\"map\" ")
			.append(" resultMap=\"").append(modelName).append("Result\" >")
			.append("\n");
		buf.append("\t\t")
			.append(" SELECT data.* \n\t\t\tFROM ").append(tableName)
			.append(" data \n \t<where> 1=1 ")
			.append("\n\t </where>");
		buf.append("\t</select>");
		System.err.println(buf.toString());
	}
	
	@SuppressWarnings("static-access")
	public void grenerateCreateTableSql() {
		StringBuilder buf = new StringBuilder();
		buf.append("create table ").append(" t_").append(this.projectName).append("_").append(this.modelName.toLowerCase());
		buf.append("(");
		buf.append("FID int unsigned NOT NULL AUTO_INCREMENT,\n");
		Field[] ary = className.getDeclaredFields();
		for (int i = 0; i < ary.length; i++) {
			Field field = ary[i];
			if (field.getType().equals(List.class) || field.getType().equals(ArrayList.class)
					|| field.getType().equals(Map.class)) {
				continue;
			}
			buf.append("\t").

			append(this.getColumnName(field)).append(" ").append(getCreateJdbcType(field)).append(",\n");
		}
		StringBuilder outBuf = new StringBuilder(buf.substring(0, buf.length() - 2));
		outBuf.append(" ,PRIMARY KEY (`fid`) )");
		outBuf.append(";");
	
		System.err.println(outBuf.toString().toLowerCase());
	}

	private String getFieldName(Field field) {
		if (field == null) {
			return "";
		} else if (field.getType().toString().indexOf(".enums.") > 0) {
			return field.getName();
		} else if (field.getType().equals(BigDecimal.class) || field.getType().equals(int.class)
				|| field.getType().equals(String.class) || field.getType().equals(Integer.class)
				|| field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)
				|| field.getType().equals(Double.class) || field.getType().equals(double.class)
				|| field.getType().equals(Long.class) || field.getType().equals(long.class)
				|| field.getType().equals(Date.class)) {
			return field.getName();
		} else {
			return field.getName() + ".id";
		}
	}

	private String getColumnName(Field field) {
		if (field == null) {
			return "";
		} else if (field.getType().toString().indexOf(".enums.") > 0) {
			return "F" + field.getName();
		} else if (field.getType().equals(BigDecimal.class) || field.getType().equals(int.class)
				|| field.getType().equals(String.class) || field.getType().equals(Integer.class)
				|| field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)
				|| field.getType().equals(Double.class) || field.getType().equals(double.class)
				|| field.getType().equals(Long.class) || field.getType().equals(long.class)
				|| field.getType().equals(Date.class)) {
			return "F" + field.getName();
		} else {
			return "FK" + field.getName() + "ID";
		}
	}

	/**
	 * 取JDBCTYPE类型
	 * 
	 * @param field
	 * @return
	 */
	private String getJdbcType(Field field) {
		if (field == null) {
			return "VARCHAR";
		}
		String jdbcType = "VARCHAR";// 默认
		if (field.getType().equals(BigDecimal.class)) {
			jdbcType = "DOUBLE";
		} else if (field.getType().equals(Date.class)) {
			jdbcType = "datetime";
		} else if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
			jdbcType = "INTEGER";
		} else {
			jdbcType = "VARCHAR";
		}
		return jdbcType;
	}

	private String getCreateJdbcType(Field field) {
		if (field == null) {
			return "varchar(44)";
		}
		String jdbcType = "varchar(44)";// 默认
		if (field.getType().equals(BigDecimal.class) || field.getType().equals(double.class)
				|| field.getType().equals(Double.class)) {
			jdbcType = "double";
		} else if (field.getType().equals(Date.class)) {
			jdbcType = "datetime";
		} else if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
			jdbcType = "int";
		} else if (field.getType().equals(long.class) || field.getType().equals(Long.class)) {
			jdbcType = "double";
		} else {
			jdbcType = "varchar(50)";
		}
		return jdbcType;
	}

	/*
	 * 取得结果集
	 */
	private ResultSet getResult() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clothing?autoReconnect=true&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true",
					"root", "Yangming888");
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from "+tableName);
			System.err.println(rs.getFetchSize());
			return rs;
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}

	private void saveFile(String path, String content) {
		FileOutputStream fop = null;
		File file;
		try {

			file = new File(path);

			// if file doesnt exists, then create it

			if (!file.exists()) {
				

				fop = new FileOutputStream(file);
//				file.createNewFile();
				// get the content in bytes
				byte[] contentInBytes = content.getBytes();

				fop.write(contentInBytes);
				fop.flush();
				fop.close();
				System.out.println(path);
			}else{
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
