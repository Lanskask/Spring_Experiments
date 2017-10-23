@Grab("thymeleaf-spring4")
@Grab("org.webjars:jquery:2.0.3-1")

@Controller
class application {

    @RequestMapping("/greeting")
    public String greeting(
        @RequestParam(value="name", required=false, defaultValue="world")
        String name, Model model) {
            model.getAttribute("name", name);
            return "greeting";
    }
}