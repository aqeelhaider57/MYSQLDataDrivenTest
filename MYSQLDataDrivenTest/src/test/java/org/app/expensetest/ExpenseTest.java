package org.app.expensetest;

import static org.junit.Assert.assertEquals;

import org.app.dao.ExpenseDAO;
import org.app.dto.Expense;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExpenseTest {
	
	private static AnnotationConfigApplicationContext context;
	private static ExpenseDAO expenseDAO;
	private Expense expense;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.app");
		context.refresh();
		expenseDAO = (ExpenseDAO) context.getBean("expenseDAO");
	}
	
	//Expense entries test
	@Test
	public void expenseListCountTest() {
		assertEquals("count number of expense", 3, expenseDAO.List().size());
	}
	
	
	//Expense entry add
	@Test
	public void expenseEntryAddTest() {
		
		expense = new Expense(); 
		
		expense.setId(4);
		expense.setAmoun(200.00);
		expense.setDescription("Grocery Bill");
		expense.setMonth("May");
		expense.setYear("2019");
		
		assertEquals("Entry inserting ", true, expenseDAO.create(expense));
	}
 
	
	//delete bill expense entry by id
	@Test
	public void deleteEntryTest() {
		assertEquals("Entry deleted : ", true, expenseDAO.deleted(4));
	}
	
	//update entry
	@Test
	public void updateTest() {
		expense = new Expense();
		expense.setId(4);
		expense.setAmoun(250.00);
		expense.setDescription("Grocery Bill");
		expense.setMonth("May");
		expense.setYear("2019");
		
		assertEquals("Entry updated : ", true, expenseDAO.update(expense));
	}

}
