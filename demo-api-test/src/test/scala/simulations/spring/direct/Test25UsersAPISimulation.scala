package simulations.spring.direct

import com.typesafe.config.Config
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import simulations.ConfExtractor

class Test25UsersAPISimulation extends Simulation {

  val config: Config = ConfExtractor.configGetter("api")

  // http conf
  val httpConf: HttpProtocolBuilder = http.baseUrl(config.getString("url"))
    .header("Accept", value = "application/json")
    .header("content-type", value = "application/json")

   // scenario
   val scn: ScenarioBuilder = scenario("Get all clients with 25 user")
     .exec(http("get all clients request with 25 users")
       .get("/clients")
       .check(status is 200)
     )
     .exec(
       http("get all products request with 25 users")
         .get("/products")
         .check(status is 200)
     )

   // setup
   setUp(scn.inject(atOnceUsers(25))).protocols(httpConf)
}