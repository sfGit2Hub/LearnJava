var Runnable = Java.type('java.lang.Runnable');
var Printer = Java.extend(Runnable, {
    run: function() {
        print('printed from a separate thread');
    }
});

var Thread = Java.type('java.lang.Thread');
new Thread(new Printer()).start();

new Thread(function() {
    print('printed from another-1 thread');
}).start();

new Thread(function() {
    print('printed from another-2 thread');
}).start();

new Thread(function() {
    print('printed from another-3 thread');
}).start();