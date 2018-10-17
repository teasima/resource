package a.b;

@Controller
public class HelloController {
	@RequestMapping(value="/home")
	public String home(){
		System.out.println("redirect to home page!");
		return "index";
	}
	
	
	@RequestMapping(value="/home/page")
	@ResponseBody
	public ModelAndView goHome(){
		System.out.println("go to the home page!");
		ModelAndView mode = new ModelAndView();
		mode.addObject("name", "zhangsan");
		mode.setViewName("index");
		return mode;
	} 

}


