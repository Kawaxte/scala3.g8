// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite:
  def add(left: Int, right: Int) = left + right

  test("hello"):
    val result = add(2, 2)
    assert(result == 4)
