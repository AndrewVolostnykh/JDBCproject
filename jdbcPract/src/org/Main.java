package org;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        model.connection();
        controller.mainMenu();
    }
}
