package Controller;

import Model.Model;
import View.View;

public abstract class Controller {

    private Model model;

    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
}
