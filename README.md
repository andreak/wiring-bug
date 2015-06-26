# wiring-bug
Shows a wiring-bug in Lift-framework

./sbt
compile
container:start

This will start jetty on http://localhost:8090/

This project shows that Lift's Wiring isn't working as expected when the Wiring-content is part of an AJAX-response, generated inside a JsCmd.toJsCmd when toJsCmd is a def. Turning the toJsCmd into a val makes it work (it is evaluated eagerly).
