import org.junit.*;
import static org.junit.Assert.*;


public class TodoTest {

	@Test
	public void newTask_instantiatesCorrectly() {
	Todo testTodo = new Todo("mow the lawn");
	assertEquals(true, testTodo instanceof Todo);
	}

	@Test
	public void newTask_instantiatesCorrectlyWithDescription() {
	Todo testTodo = new Todo("mow the lawn");
	assertEquals("mow the lawn", testTodo.getDescription());
	}
	
}