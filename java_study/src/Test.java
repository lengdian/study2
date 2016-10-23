import java.lang.ref.SoftReference;

public class Test {
    public static void main(String[] args) {
//        System.out.println("hello world");

        Test test=new Test();
        test.say();

        SoftReference<Test> sr=new SoftReference<Test>(test);

        System.out.println(test);

        test=null;

        if(sr.get()!=null){
            Test t1=sr.get();

            t1.say();
        }


    }

    private void say(){
        System.out.println("hi");
    }
}
