interface TestInterface {

    default String test() {
        return "test";
    }

    default String test1() {
        return "test1";
    }
}

abstract class TestAbstract {

    abstract void testAbstract();

    void test2() {
        System.out.println("test");
    }
}

class Concrete extends TestAbstract implements TestInterface, TestInterface2 {

    @Override
    public String test() {
        return null;
    }

    @Override
    void testAbstract() {

    }
}

interface TestInterface2 {

    default String test() {
        return "test";
    }
}
