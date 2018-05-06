package study.java8.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by SF on 2018/4/27.
 */
public class NashornEngineDemo {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        engine.eval("load('log/hello.js')");
    }
}
