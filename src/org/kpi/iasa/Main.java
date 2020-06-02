package org.kpi.iasa;

import org.kpi.iasa.controller.Controller;
import org.kpi.iasa.model.Model;
import org.kpi.iasa.view.View;

public class Main {

    public static void main(String[] args) {
      Model model = new Model();
      model.connectToDb();
      model.seedDb();
      Controller controller = new Controller(model, new View());
	    controller.processUser();
      model.closeConnection();
    }
}
