import com.zhen.foo.*;

class RuntimeTest {

    public static void main(String[] args) {
        System.loadLibrary("swig_deprec");

        System.out.println("Compilation Successful");

        Foo f = new Foo();
        System.out.println("1");

        Bar b1 = new Bar();
        System.out.println("2");

        OtherBar b2 = new OtherBar();
        System.out.println("3");

        f.useBar(b1);
        System.out.println("4");

        f.useBar(b2);
        System.out.println("5");
    }

}
