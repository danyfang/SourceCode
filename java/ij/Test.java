import dany.fang.flexible.Flexible;
import dany.fang.java.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class Person{
    public Person(){
        System.out.println("This is blabala  // system.gc()");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("this happens before the person dies");
        throw new Exception("then the person dies");
    }
}
public class Test {
    public static void main(String [] args){
        new Intereste(100);
        System.out.println(add());
        System.out.println(add(23,3456,7,67,8,8));
        System.out.println(add(23,54,76,8,88,9));
        Flexible<String> flex = new Flexible("你好啊","郑素素");
        flex.print();
        Flexible<Integer> f =  new Flexible<>(4,5);
        fun(f);
        fun(flex);
        Integer result[] = get(1,2,3,64,453,5334,343);
        for(int temp:result){
            System.out.println(temp);
        }
        Color c = Color.getInstance(0);
        Color d = Color.getInstance(2);
        System.out.println(c);
        System.out.println(d);
        Colo e = Colo.BLUE;
        System.out.println(e.ordinal()+","+e.name());
        for(Colo g:Colo.values()){
            System.out.println(g.ordinal()+","+g.name());
        }
        System.out.println(new Message().toString());
        MyThread st1 = new MyThread("线程A ");
        MyThread st2 = new MyThread("线程B ");
        MyThread st3 = new MyThread("线程C ");
        //st1.start();
        //st2.start();
        //st3.start();
        StringBuffer buf = new StringBuffer("方绪强");
        buf.append("Hello").append("你啊好啊");
        System.out.println(buf);
        System.out.println(buf.reverse());
        String st = buf.toString();
        System.out.println(st);
        Runtime ru = Runtime.getRuntime();
        System.out.println("MAx: = "+ru.availableProcessors());
        System.out.println("MAx: = "+ru.freeMemory());
        System.out.println("MAx: = "+ru.totalMemory());
        System.out.println("MAx: = "+ru.maxMemory());
        System.out.println(System.currentTimeMillis());
        Person p = new Person();
        p = null;
        System.gc();
        Date date = new Date();
        System.out.println(date.getTime());
        long ct = System.currentTimeMillis();
        long ct2 = 0;
        Date dt1 = new Date(ct);
        Date dt2 = new Date(ct2);
        System.out.println(dt1);
        System.out.println(dt2);
        Date dddd = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String stdate = sdf.format(dddd);
        System.out.println(stdate);
        Random rand = new Random();
        for (int i=0;i<100;i++){
            System.out.println(rand.nextInt(100));
        }
        BinaryTree tree = new BinaryTree();
        tree.add(new Student("Yaoyuan",23));
        tree.add(new Student("Qianpeng",24));
        tree.add(new Student("Changbing",26));
        tree.add(new Student("Weibo",25));
        tree.add(new Student("Rafel",27));
        tree.add(new Student("Zitong",28));
        tree.add(new Student("Linna",29));
        tree.add(new Student("Xuqiang",29));
        tree.add(new Student("Xujun",29));
        System.out.println(tree.search(new Student("Xujun",29)));
        System.out.println(tree.search(new Student("Zitong",28)));
        System.out.println(tree.search(new Student("Zitong",22)));
        tree.print();

        String string = "12423sfasf3r34j54343btnkert34tkn4";
        String regex = "[a-zA-Z]+";
        System.out.println(string.replaceAll(regex,""));
        System.out.println(string.matches("[0-9]+"));



        System.out.println("************************");
        Fruit fruit = Factory.getInstance("dany.fang.java.Apple");
        Fruit fruit_2 = Factory.getInstance("dany.fang.java.Orange");
        Fruit fruit_3 = Factory.getInstance("dany.fang.java.Banana");
        fruit.eat();
        fruit_2.eat();
        fruit_3.eat();

    }
    public static int add(int ... data){
        int sum = 0;
        for(int x: data){
            System.out.println(x);
        }
        for (int i=0; i< data.length; i++){
            sum += data[i];
        }
        return sum;
    }
    public static void fun(Flexible<?> temp ){//? 是通配符, 表示任意类型
        temp.print();
    }
    public static <T> T[] get(T... args){//范型方法
        return args;
    }
}
enum Colo{
        RED,GREEN,BLUE;
}
