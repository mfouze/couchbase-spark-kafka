package controllers

import play.api.Configuration
import play.api.mvc._

import javax.inject._

class HealthCheck @Inject()(config: Configuration, components: ControllerComponents) extends AbstractController(components) {

  def getHealth: Action[AnyContent] = Action { _ =>
    Ok ("Good Application's health")}
}