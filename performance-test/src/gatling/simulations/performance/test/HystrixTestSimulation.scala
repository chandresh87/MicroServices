package performance.test

import java.util.Date
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration.Duration
import java.util.concurrent.TimeUnit
import scala.util.Random
import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class HystrixTestSimulation extends Simulation {

  val sessionHeaders = Map("Authorization" -> "Bearer ${authToken}",
                           "Content-Type" -> "application/json")
                           
  val header = Map(
    "Content-Type" -> "application/x-www-form-urlencoded",
    "Authorization" -> "Basic SVRNUDpJVE1Q");
    
  //val auth_token = scenario("POST Authentication")
        
                
  val scn = scenario("Get Person Data").
        exec(
            http("POST OAuth Req")
            .post("http://localhost:8901/oauth/token")
           // .formParam("client_secret", "ITMP")
            //.formParam("client_id", "ITMP")
            .formParam("username", "chandresh.mishra")
            .formParam("password", "password1")
            .formParam("grant_type", "password")
            .formParam("scope", "webclient")
            .headers(header)
            .check(status.is(200)).check(jsonPath("$.access_token").exists.saveAs("authToken"))
            )
       .
       exec(
          http("GetPerson-API")
            .get("http://localhost:5555/api/personservice/getPerson?nino=12345Ac&id=1")
            .headers(sessionHeaders)
            .check(status.is(200))
        )  
        
 
  setUp(scn.inject(atOnceUsers(20))).maxDuration(FiniteDuration.apply(10, "minutes"))
  
}