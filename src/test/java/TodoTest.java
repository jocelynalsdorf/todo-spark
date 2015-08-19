import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class TodoTest {

	@Rule
  public ClearRule clearRule = new ClearRule();


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

	@Test
	public void isCompleted_isFalseAfterInstantiation() {
	Todo testTodo = new Todo("mow the lawn");
	assertEquals(false, testTodo.isCompleted());
	}	

	@Test
	public void getCreatedAt_iinstantiatesWithCorrectTime() {
	Todo testTodo = new Todo("mow the lawn");
	assertEquals(LocalDateTime.now(), testTodo.getCreatedAt());
	}

	
	// @Test
	// public void find_returnsTodoWithSameID() {
	// Todo firstTodo = new Todo("mow the lawn");
	// Todo secondTodo = new Todo("mow the sky");
	// assertEquals(Todo.find(secondTodo.getId()), secondTodo);
	// }
	// 
	

  @Test
  public void find_returnsNullWhenNoTaskFound_null() {
    assertTrue(Todo.find(999) == null);
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList() {
    Todo myTodo = new Todo("Mow the lawn");
    Todo.clear();
    assertEquals(Todo.all().size(), 0);
  }


}