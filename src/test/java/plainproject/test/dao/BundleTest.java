package plainproject.test.dao;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.junit.Test;

import by.andersen.intensive.bakulin.dao.connection.sql.constant.ConnectionConstant;

public class BundleTest {
	
	@Test
	public void testBundle() {
		ResourceBundle bundle = ConnectionConstant.RESOURCE_BUNDLE;
		Enumeration<String> enumeration = bundle.getKeys();
		Iterator<String> iterator = enumeration.asIterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s);
		}
	}
}
