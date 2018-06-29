package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
@RequestMapping	("/logins")
public String login()
{
	return "login";
}



@RequestMapping	("/app")
public String app()
{
return "Register";
}

@RequestMapping	("/welcome")
public String fine()
{
	return "abc";
}
@RequestMapping	("/samsung")
public String samsung()
{
	return "samsung";
}

@RequestMapping	("/run")
public String speed()
{
	return "sun";
}

@RequestMapping ("/sachin")
public String array()
{
	return "abcd";
}
@RequestMapping	("/ratheesh")
public String slow()
{
	return "hello";
}

@RequestMapping ("/simple")
public String fast()
{
	return "space";
}
@RequestMapping ("/guru")
public String why()
{
	return "sundar";
}

@RequestMapping("/selvasundar")
public String selva(){
	return "done";
}

@RequestMapping ("/good")
public String product()
{
	return "create";
}

@RequestMapping ("/array")
public String produce()
{
	return "bold";
}
}	




