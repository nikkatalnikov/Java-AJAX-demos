package org.kpi.iasa.controller;

import org.kpi.iasa.model.Model;
import org.kpi.iasa.view.View;
import org.kpi.iasa.view.TextConstant;

import java.util.Scanner;

/**
 * Created by student on 02.05.2020.
 */
public class InputInformationService {
    private View view;
    private Scanner sc;
    private Model model;

    public InputInformationService(View view, Scanner sc, Model model) {
        this.view = view;
        this.sc = sc;
        this.model = model;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(sc, view);

        String str = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? RegExContainer.REGEX_NAME_UKR : RegExContainer.REGEX_NAME_LAT;

        utilityController.inputStringValueWithScanner(TextConstant.FIRST_NAME, str);
        String login = utilityController.inputStringValueWithScanner (TextConstant.LOGIN_DATA, RegExContainer.REGEX_LOGIN);

        new LoginValidator(utilityController, model).validateLogin(login);
    }
}
