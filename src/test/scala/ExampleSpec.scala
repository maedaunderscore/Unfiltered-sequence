import org.scalatest.matchers.ShouldMatchers
import org.scalatest.GivenWhenThen
import org.eclipse.jetty.server.session.SessionHandler

class ExampleSpec extends unfiltered.scalatest.jetty.Served 
  with ShouldMatchers with GivenWhenThen {

  def setup = { server =>
    server.current.setSessionHandler(new SessionHandler)
    server.filter(new SequentialAccess) 
  }

  import dispatch._
  val h = new Http
  scenario("hoge"){
    h(host / "hoge" as_str) should be("hoge")
    h(host / "last" as_str) should be("hoge")
    h(host / "fuga" as_str) should be("fuga")
    h(host / "last" as_str) should be("fuga")
  }
}
