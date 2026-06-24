package com.marto.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  @Autowired private LoginService service;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLoginPage() {
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String handleLoginRequest(
      @RequestParam("name") String name,
      ModelMap model,
      @RequestParam("password") String password) {
    if (service.validateUser(name, password)) {
      model.put("name", name);
      model.put("password", password);
      return "welcome";
    }
    model.put("errorMessage", "Invalid Credentials");
    return "login";
  }
}
