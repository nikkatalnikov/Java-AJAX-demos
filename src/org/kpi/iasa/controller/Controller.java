package org.kpi.iasa.controller;

import org.kpi.iasa.model.Model;
import org.kpi.iasa.view.View;

import java.util.Scanner;

/**
 * Created by student on 02.05.2020.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        InputInformationService inputInformationService = new InputInformationService(view, sc, model);
        inputInformationService.inputNote();
    }
}
