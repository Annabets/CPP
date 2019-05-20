package sample;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.scene.control.TextField;

public class Calculator implements Runnable {
    private ScriptEngineManager manager;
    private ScriptEngine engine;
    private TextField inputField;
    private TextField outPutField;
    private Object result;

    Calculator(TextField inputField, TextField outPutField) {
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
        this.inputField = inputField;
        this.outPutField = outPutField;
    }

    public String calculate(String expression) {
        try {
            result = engine.eval(expression);
        } catch (ScriptException exception) {
            result = null;
        }
        if (result != null) {
            return result.toString();
        } else {
            return "incorrect expression";
        }
    }

    @Override
    public void run() {
        if (!inputField.getText().isEmpty()) {
            outPutField.setText(calculate(inputField.getText()));
        }
    }
}
