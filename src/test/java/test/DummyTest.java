package test;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {

  private Dummy dummy = new Dummy();

  protected void run() {
    Assert.assertEquals("Genius", dummy.test("Sachin"));

  }

  @Test public void test1() {
    run();
  }

  @Test public void test2() {
    run();
  }

  @Test public void test3() {
    run();
  }

  @Test public void test4() {
    run();
  }

  @Test public void test5() {
    run();
  }

  @Test public void test6() {
    run();
  }

}
