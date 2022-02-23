class playerStat(var year: Int, var playerName: String, var country: String, var matches: Int, var runs: Int, var wickets: Int) {}

object playerStat {
//  def Desc[T: Ordering] = implicitly[Ordering[T]].reverse;

  def push_into(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int): playerStat = {
    val playerStat = new playerStat(year, playerName, country, matches, runs, wickets);
    return playerStat;
  }

  def main(args: Array[String]): Unit = {
    val bufferedSource = scala.io.Source.fromFile("/Users/kartikjaiswal/Downloads/player.csv")
    var playerList = List(push_into(2020, "Virat", "India", 34, 2456, 10))

    for (elem <- bufferedSource.getLines){
      val columns = elem.split(",").map(_.trim)
      playerList = playerList :+ push_into(columns(0).toInt, columns(1), columns(2), columns(3).toInt, columns(4).toInt, columns(5).toInt)
    }
    println("Q1. Player with the best highest runs scored.");
    var playerWithHighestRuns = playerList.sortBy(x => x.runs).reverse
    println(playerWithHighestRuns(0).playerName)
    println("======================================")
    println("Q2. Top 5 players by runs scored.")
    for (player <- playerWithHighestRuns.take(5)){
      println(player.playerName)
    }
    println("======================================")
    println("Q3. Top 5 players by wicket taken.")
    var playerWithHighestWicket = playerList.sortBy(x => x.wickets).reverse
    for (player <- playerWithHighestWicket.take(5)) {
      println(player.playerName)
    }
    println("======================================")
    println("Q4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored!")
    playerList = playerList.sortBy(x => x.wickets * 5).sortBy(x => x.runs * 0.05).reverse
    var count: Int = 1
    for (player <- playerList) {
      println(s"Rank $count - " + player.playerName)
      count += 1;
    }
  }
}