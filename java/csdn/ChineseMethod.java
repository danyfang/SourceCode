public class ChineseMethod{
    public static void print(){
        System.out.println("中文方法可以吗");
    }

    public static void main(String[] args){
        print();
        int a = -6;
        for(int i=0; i<32; i++){
            int t = (a & 0x80000000>>>i) >>> (31-i);
            System.out.println(t);
        }
    }
}
