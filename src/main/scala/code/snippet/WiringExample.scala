package code
package snippet

import net.liftweb.http._
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers._
import net.liftweb.util.{Cell, Helpers}

class WiringExample {
  val wiringDialogTemplate = "wiringDialog"

  def render = {
    "#showDialogBroken" #> SHtml.ajaxButton("Broken wiring", () => {
      new JsCmd {
        override def toJsCmd: String = {
          val content = S.runTemplate(List(wiringDialogTemplate)).openOr(<div>Template {wiringDialogTemplate} not found</div>)
          LiftRules.jsArtifacts.setHtml("notWorking", Helpers.stripHead(content)).toJsCmd
        }
      }
    }) &
    "#showDialog" #> SHtml.ajaxButton("Working wiring", () => {
      new JsCmd {
        override val toJsCmd: String = {
          val content = S.runTemplate(List(wiringDialogTemplate)).openOr(<div>Template {wiringDialogTemplate} not found</div>)
          LiftRules.jsArtifacts.setHtml("working", Helpers.stripHead(content)).toJsCmd
        }
      }
    })
  }


  def dialog = {
    val cell = Cell[String]("I'm wiring content, replaced successfully!")
    ".sum *" #> WiringUI.asText(cell)
  }

}