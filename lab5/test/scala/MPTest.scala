import MyProgram.sqrIter
import org.scalatest.FunSuite

class MPTest extends FunSuite {
  test("1^(1/2)=1") {
    assert(sqrIter(1,1).formatted("%.2f") == "1,00")
  }
  test("4^(1/2)=2") {
    assert(sqrIter(1,4).formatted("%.2f") == "2,00")
  }
  test("9^(1/2)=3") {
    assert(sqrIter(1,9).formatted("%.2f") == "3,00")
  }
  test("16^(1/2)=4") {
    assert(sqrIter(1,16).formatted("%.2f") == "4,00")
  }
  test("25^(1/2)=5") {
    assert(sqrIter(1,25).formatted("%.2f") == "5,00")
  }
  test("20^(1/2)=4.47") {
    assert(sqrIter(1,20).formatted("%.2f") == "4,47")
  }
  test("119025^(1/2)=325") {
    assert(sqrIter(1,119025).formatted("%.2f") == "345,00")
  }

}
