import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
	public static void main(String[] args){
		staticFileLocation("/public");
		String layout = "templates/layout.vtl";

		get("/", (request,response) -> {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("template", "templates/index.vtl");
		//request.session().attribute("todo");


		model.put("todos", request.session().attribute("todos"));
		return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());


		post("/tasks", (request,response) -> {
			HashMap<String, Object> model = new HashMap<String, Object>();
			//below is saving the name of the array
			ArrayList<Todo> todos = request.session().attribute("todos");

			if (todos == null) {
				todos = new ArrayList<Todo>();
				request.session().attribute("todos", todos);
			}

			String description = request.queryParams("description");
			Todo newTodo = new Todo(description);
			todos.add(newTodo);
			//instead of the code below we add newToDo to the array of todos above
			//request.session().attribute("todo", newTodo);

			//You dont need to put this in model here, do it as just a getter in model in GET
			//model.put("todo", request.session().attribute("todo", newTodo));


			model.put("template", "templates/success.vtl");
			return new ModelAndView(model, layout);
			}, new VelocityTemplateEngine());
	

	}

}