//------Encapsulation------
class Encap {
    private int age;
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

class EncapTest {
    public static void main(String[] args) {
        Encap e = new Encap();
        e.setAge(20);
        System.out.println(e.getAge());
    }
}

//------Inheritance------
class Inherit {
    void show() {
        System.out.println("Inherit");
    }
}

class InheritTest extends Inherit {
    void show() {
        System.out.println("InheritTest");
    }
}

//------Polymorphism------
class Poly {
    void show() {
        System.out.println("Poly");
    }
}

class PolyTest extends Poly {
    void show() {
        System.out.println("PolyTest");
    }
}


//------Abstraction------
interface Abstr {
    void show();
}

class AbstrTest implements Abstr {
    public void show() {
        System.out.println("AbstrTest");
    }
}
