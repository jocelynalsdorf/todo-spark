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
	
		model.put("todos", request.session().attribute("todos"));
		return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("tasks",(request, response) -> {
		HashMap<String, Object> model = new HashMap<String, Object>();
		//make all instances availso that all tasks can be shown
		model.put("tasks", Task.all());
		model.put("template", "templates/tesk.vtl");
		 return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


		})

		post("/tasks", (request,response) -> {
			HashMap<String, Object> model = new HashMap<String, Object>();

			String description = request.queryParams("description");
			Todo newTodo = new Todo(description);		
			model.put("template", "templates/success.vtl");
			return new ModelAndView(model, layout);
			}, new VelocityTemplateEngine());
	

	}

}