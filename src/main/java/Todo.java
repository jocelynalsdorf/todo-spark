import java.time.LocalDateTime;
import java.util.ArrayList;

public class Todo {

public static ArrayList<Todo> instances = new ArrayList<Todo>();

private String mDescription;
private LocalDateTime mCreatedAt;
private int mId;
private boolean mCompleted;



	public Todo(String description){
		mDescription = description;
		mCreatedAt = LocalDateTime.now();
		mId = instances.size();
		instances.add(this);
		mCompleted = false;
	}

	public String getDescription(){
		return mDescription;
	}

	public boolean isCompleted() {
		return mCompleted;
	}

	public LocalDateTime getCreatedAt() {
		return mCreatedAt;
	}

	public int getId() {
		return mId;
	}

	public void completeTask() {
		mCompleted = true;
	}

	public static ArrayList<Todo> all() {
		return instances;
	}

	public static Todo find(int id) {
		try {
			return instances.get(id - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public static void clear() {
		instances.clear();
	}

}