package controllers

import io.swagger.annotations._
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import javax.inject._
import scala.concurrent.ExecutionContextExecutor

@Api(value = "/api/v1/home",
  tags = Array("Home Controller"),
  produces = "application/json")
class HomeController @Inject()(components: ControllerComponents)(implicit val ec: ExecutionContextExecutor) extends AbstractController(components) {

  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Search successful, even if the result array is empty"),
    new ApiResponse(code = 400, message = "Bad request query"),
    new ApiResponse(code = 405, message = "Only POST method is allowed ")
  ))
  def index = Action { implicit request =>
    Ok(views.html.index())
  }


  @ApiOperation(
    value = "Recuperation de Say hello",
    httpMethod = "GET",
    response = classOf[String])
  @ApiImplicitParams(
    Array(new ApiImplicitParam(
      name = "name",
      required = true,
      dataType = "String",
      paramType = "guery")))
  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid name supplied"),
    new ApiResponse(code = 404, message = "Name not found")))
  def sayHello(name: String): Action[AnyContent] = Action {
    Ok(s"hello $name")
  }
}
