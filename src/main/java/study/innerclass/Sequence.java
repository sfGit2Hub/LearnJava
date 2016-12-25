package study.innerclass;

/**
 * Created by SF on 2016/5/3.
 */
public class Sequence {
    private Object[] item;
    private int next = 0;

    public Sequence(int size) {
        this.item = new Object[size];
    }

    public void add(Object object) {
        if (next < item.length)
            item[next++] = object;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == item.length;
        }

        @Override
        public Object current() {
            return item[i];
        }

        @Override
        public void next() {
            if (i < item.length)
                i++;
        }

        /**
         * 创建一个内部类之后，都隐式的有对外部类的引用
         * @return 外部类对象的引用
         */
        public Sequence sequence(){
            return Sequence.this;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    /**
     * 匿名内部类方法
     */
    public Selector selector2(){
        return new Selector() {
            private int i = 0;
            private Sequence sequence;
            @Override
            public boolean end() {
                return i == item.length;
            }

            @Override
            public Object current() {
                return item[i];
            }

            @Override
            public void next() {
                if (i < item.length)
                    i++;
            }
        };
    }

    public static void main(String[] args){
        Sequence sequence = new Sequence(10);
        for (int i=0; i<10; i++){
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        /**
         *  .new 创建内部类对象的方法
        * */
//        Sequence.SequenceSelector innerSelector = sequence.new SequenceSelector();
        while (!selector.end()){
            System.out.println("InnerClass-Method:" + selector.current());
            selector.next();
        }
    }
}
