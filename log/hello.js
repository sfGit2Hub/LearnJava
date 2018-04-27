function hello_word() {
    print('hello world');
}

hello_word();

function jsonJavaBean(obj) {
    print(obj.toString());
}

var Person = Java.type("common.use.Person");
var Sex = Java.type("common.use.Sex");
var person = new Person('abel', 'id-123', Sex.FEMALE);
jsonJavaBean(person);

var logger = java.util.logging.Logger.getLogger('hello.js');
logger.log(java.util.logging.Level.WARNING, 'warning hello world');