package utils

import akka.stream.Materializer
import play.api.mvc.{Filter, RequestHeader, Result}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LoggingFilter @Inject()(implicit val mat: Materializer, ec: ExecutionContext) extends Filter {
  /*var cptCall:Long=0L
  val correlationIdKey = "msg_correlation_id" // TODO: migrate to 'client-name' instead of obsoleted 'msg_correlation_id' field
  val clientNameKey = "client-name"
*/
  def apply(nextFilter: RequestHeader => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {
    val startTime = System.currentTimeMillis
    nextFilter(requestHeader)
      .map { result =>
        val endTime = System.currentTimeMillis
        val requestTime = endTime - startTime

        /*      if ((cptCall % 100==0)||(requestTime>=10)) {
                val correlationId = requestHeader.headers.get(clientNameKey)
                val clientName = requestHeader.headers.get(correlationIdKey)
                val identity = clientName.orElse(correlationId).getOrElse("?")
                logger.warn(s"[$identity] - ${requestHeader.method} ${requestHeader.uri}  ${requestTime}ms  ${result.header.status}")
              }
              cptCall+=1*/
        result

      }

  }
}


