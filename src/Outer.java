class Outer {
    class Inner {

    }
}

class SubClass extends Outer.Inner {

    public SubClass(Outer outer) {
        outer.super();
    }
}
