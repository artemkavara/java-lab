package first;

public class A {
    private C obj;

    public void setObj (C obj){
        this.obj = obj;
    }

    public C getObj (){
        return obj;
    }

    public static void main(String[] args){
        A a = new A();
        C obj2 = a.getObj();
        obj2.setObj();
    }

}

class C{
    public void setObj(){

    }
}
