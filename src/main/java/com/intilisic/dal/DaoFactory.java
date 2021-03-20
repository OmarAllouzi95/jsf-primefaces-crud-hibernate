package com.intilisic.dal;

public class DaoFactory {

	public static final String JDBC = "jdbc";
	public static final String HIBERNATE = "hibernate";

	private DaoFactory() {

	}

	@SuppressWarnings("rawtypes")
	private static Dao dao = null;

	@SuppressWarnings("rawtypes")
	public static Dao getDao(String dbVendor) {
		if (dao == null && dbVendor.equals(JDBC)) {
			dao = new JDBCDaoImplementation();
		} else if (dao == null && dbVendor.equals(HIBERNATE)) {
			dao = new HibernateDaoImplementation();
		}
		return dao;
	}

}
