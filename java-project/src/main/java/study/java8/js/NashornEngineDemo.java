package study.java8.js;

import common.use.Person;
import common.use.Sex;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SF on 2018/4/27.
 */
public class NashornEngineDemo {
    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        Map<String, Object> scriptVar = new HashMap<>();
        scriptVar.put("user", new Person("abel", "1111", Sex.MALE));
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
//        engine.eval("load('log/hello.js')", new SimpleBindings(scriptVar));
        engine.eval("load('log/thread.js')", new SimpleBindings(scriptVar));
//
//        Invocable invocable = (Invocable) engine;
//        engine.eval(new FileReader("log/greeter.js"));
//        System.out.println(invocable.invokeFunction("greet", "abel"));
//
////        Object json = engine.eval("JSON");
//        Person person = new Person("abel", "2241432", Sex.MALE);
//        Object str = invocable.invokeFunction("JSON.stringify", person);
//        System.out.println(str);
    }
}
