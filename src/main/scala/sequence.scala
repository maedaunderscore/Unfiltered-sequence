import unfiltered.request._
import unfiltered.response._

import org.clapper.avsl.Logger

/** unfiltered plan */
class SequentialAccess extends unfiltered.filter.Plan {
  import QParams._

  val logger = Logger(classOf[App])

  type Request = HttpRequest[javax.servlet.http.HttpServletRequest]
  object Session{
    def unapply(r: Request) = Some({
      r.underlying.getSession(true)
    })
  }

  def intent = {
    case Path(Seg("last" :: Nil)) & Session(s)=>
      Ok ~> ResponseString(s.getAttribute("test").asInstanceOf[String])
    case Path(Seg(value :: Nil)) & Session(s)=>
      s.setAttribute("test", value.toString)
      Ok ~> ResponseString(value)
  }
}
