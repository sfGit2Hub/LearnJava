var Person = Java.type("common.use.Person");
var Sex = Java.type("common.use.Sex");

/**
 * JavaBean Inject
 * user is a object from java code inject
 */
print(user);


/**
 * Read File
 */
function readFully(url) {
    var result = "";
    var imports = new JavaImporter(java.net, java.lang, java.io);

    with (imports) {

        var urlObj = null;

        try {
            urlObj = new URL(url);
        } catch (e) {
            // If the URL cannot be built, assume it is a file path.
            urlObj = new URL(new File(url).toURI().toURL());
        }

        var reader = new BufferedReader(new InputStreamReader(urlObj.openStream()));

        var line = reader.readLine();
        while (line != null) {
            result += line + "\n";
            line = reader.readLine();
        }

        reader.close();
    }

    return result;
}
var html = readFully("log/hello.html");
print(html);


/**
 *  load other js file
 */
load('log/greeter.js');
greet('abel');

load('https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.1/moment.min.js');
var now = new moment();
print(now);

/**
*   String Interpolation
*/
var expression = "This variable at string";
var str = "Hello, ${expression}";
print(str);

function jsonJavaBean(obj) {
    print(obj.toString());
    print("current line:", __LINE__);
    /**
     * could throw error and java could get the function stack information
     */
    // throw TypeError;
}


var person = new Person('abel', 'id-123', Sex.FEMALE);
jsonJavaBean(person);

var logger = java.util.logging.Logger.getLogger('hello.js');
logger.log(java.util.logging.Level.WARNING, 'warning hello world');
print(__FILE__, __LINE__, __DIR__);