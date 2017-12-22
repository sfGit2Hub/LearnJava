package aop;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by SF on 2017/12/15.
 */
public class Proxy {
    public static Object newProxyInstance(Class infce, InvocationHandle handler) throws Exception{
        String methodStr = "";
        String rn = "\r\n";
        Method[] methods = infce.getMethods();
        for (Method method : methods) {
            Class[] argsTypes = method.getParameterTypes();
            String argsStr = "";
            int argsIndex = 0;
            for (int i = 0; i < argsTypes.length; i++) {
                argsStr += argsTypes[i].getName() + " arg" + argsIndex++;
                if (i != argsTypes.length - 1) {
                    argsStr += ", ";
                }
            }
            String jsonPrintStr = "", invokeArgs = "";
            for (int i = 0; i < argsIndex; i++) {
                invokeArgs += ",arg" + i;
                jsonPrintStr += "          System.out.println(JSON.toJSONString(arg"+ i +"));" + rn;
            }
            methodStr += "  @Override" + rn +
                         "  public " + method.getReturnType() + " " + method.getName() + "("+ argsStr +"){" + rn +
                         "      try{" + rn +
                         "          Method md = " + infce.getName() + ".class.getMethod(\"" + method.getName() + "\");" + rn +
                         "          h.invoke(this, md"+ invokeArgs + ");" + rn +
                                    jsonPrintStr +
                         "      }catch(Exception e){e.printStackTrace();}" + rn +
                         "  }" + rn;
        }

//        生成Java文件
        String srcCode = "package aop;" + rn +
                         "import java.lang.reflect.Method;" + rn +
                         "import com.alibaba.fastjson.JSON;" + rn +
                         "import common.use.Person;" + rn +
                         "public class $ProxyT implements " + infce.getName() + "{" + rn +
                         "  public $ProxyT(InvocationHandle h){" + rn +
                         "      this.h = h;"  + rn +
                         "  }" + rn +
                         "  aop.InvocationHandle h;" + rn +
                         methodStr + rn +
                         "}";
        String fileName = "E:/Program Files/sf-demo/LearnJava/java-project/src/main/java/aop/$ProxyT.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(srcCode);
        fw.flush();
        fw.close();

//        将Java文件编译成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
        t.call();
        fileManager.close();

//        加载到内存，并实例化
        URL[] urls = new URL[] {new URL("file:/" + "E:/Program Files/sf-demo/LearnJava/java-project/src/main/java/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class c = urlClassLoader.loadClass("aop.$ProxyT");

        Constructor ctr = c.getConstructor(InvocationHandle.class);
        Object m = ctr.newInstance(handler);
        return m;
    }
}
