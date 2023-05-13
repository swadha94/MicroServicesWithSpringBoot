package com.swadha.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {

	//Give specific URL to REST API using request mapping
	
	@RequestMapping(method = RequestMethod.GET, path = "/hola")
	public String Hola()
	{
		return "HOLA peeps!";
	}
	
	//Using GetMapping instead of request mapping
	@GetMapping(path = "/hello-world")
	public String helloWorld()
	{
		return "HelloWorld";
	}
	
	/* This shows that instead of returning a string if you return a class instance, 
	 * it gets returned in JSON formatter on local host
	*/
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World Bean to JSON");
	}
	
	/* Here {} contains variable name in the path
	 * Need to import @PathVariable
	 * */
	@GetMapping(path = "/hello-world-bean/pathvariable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello World,%s", name));
	}
	
	
	
}
