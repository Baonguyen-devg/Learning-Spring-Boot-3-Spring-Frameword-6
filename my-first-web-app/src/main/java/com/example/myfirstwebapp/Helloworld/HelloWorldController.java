package com.example.myfirstwebapp.Helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	//http://localhost:8080/say-hello
	@RequestMapping(value = "/say-hello", method = RequestMethod.GET)
	@ResponseBody
	public String SayHelloWorld() {
		return "Hello, How are you today?";
	}
	
	//http://localhost:8080/say-hello-html
	@RequestMapping(value = "/say-hello-html", method = RequestMethod.GET)
	@ResponseBody
	public String SayHelloWorldHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("Welcome to my first page\n");
		sb.append(SayHelloWorld());
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	//http://localhost:8080/say-hello-jsp
	@RequestMapping(value = "/say-hello-jsp", method = RequestMethod.GET)
	public String SayHelloWorldJsp() {
		return "sayHello";
	}
}
