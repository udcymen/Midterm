package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eTitle;
import pkgException.PersonException;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void test() throws PersonException {
		int average = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 9, 1);
		Date D = calendar.getTime();
		ArrayList<Staff> sta = new ArrayList<Staff>();
		sta.add(new Staff("", "", "", D, "", "(215)-820-8056", "", "", 0, 10000, new Date(), eTitle.MR));
		sta.add(new Staff("", "", "", D, "", "(215)-820-8056", "", "", 0, 20000, new Date(), eTitle.MR));
		sta.add(new Staff("", "", "", D, "", "(215)-820-8056", "", "", 0, 40000, new Date(), eTitle.MR));
		sta.add(new Staff("", "", "", D, "", "(215)-820-8056", "", "", 0, 60000, new Date(), eTitle.MR));
		sta.add(new Staff("", "", "", D, "", "(215)-820-8056", "", "", 0, 80000, new Date(), eTitle.MR));
		for (Staff s : sta){
			average += s.getSalary();
		}
		average = average / sta.size();
		assertEquals(average, 42000);
	}
	
	@Test (expected = PersonException.class)
	public void testDOB() throws PersonException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1900, 9, 1);
		Date D = calendar.getTime();
		Person P = new Staff("", "", "", D, "", "(215)-820-8056", "", "", 0, 10000, D, eTitle.MR);
	}
	
	@Test (expected = PersonException.class)
	public void testInvalidPhone() throws PersonException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 9, 1);
		Date D = calendar.getTime();
		Person P = new Staff("", "", "", D, "", "2158208056", "", "", 0, 10000, new Date(), eTitle.MR);
	}
	
	


}
