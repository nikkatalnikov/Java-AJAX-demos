package org.kpi.iasa.controller;

import org.kpi.iasa.model.Model;
import org.kpi.iasa.view.TextConstant;

public class LoginValidator {
  Model model;
  UtilityController utilityController;

  LoginValidator(UtilityController utilityController, Model model) {
    this.model = model;
    this.utilityController = utilityController;
  }

  public void validateLogin(String login) {
    if (model.validateLogin(login)) {
      String password = utilityController.inputStringValueWithScanner (TextConstant.PASSWORD_DATA, RegExContainer.REGEX_LOGIN);
      if (model.validatePassword(password)) {
        System.out.println("You are logged in! Welcome!");
      } else {
        System.out.println("Wrong password, try again");
        validateLogin(login);
      }
    } else {
      System.out.println("Wrong login, try again");
      String nextLoginAttempt = utilityController.inputStringValueWithScanner (TextConstant.LOGIN_DATA, RegExContainer.REGEX_LOGIN);
      validateLogin(nextLoginAttempt);
    }
  }
}