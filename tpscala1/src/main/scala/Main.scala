import scala.io.Source;
  // Main method
  @main def main: Unit ={
    val file = Source.fromFile("resources/file.txt");

    var connexions: List[Connexion] = List()

    var tmps: List[Long] = List();
    var host1: List[String] = List();
    var host2: List[String] = List();

    println("");
    println("File's data:");
    println("");
    //Read data from file line by line.
    for (line <- file.getLines) {
      println(line);
      val lineContents = line.split(" ");

      var con_Row = new Connexion();
      con_Row.tmps =  lineContents(0).toLong ;
      con_Row.host1 =  lineContents(1) ;
      con_Row.host2 =  lineContents(2) ;
      
      connexions = connexions :+ con_Row ;
    }
    println("");
    println("");

    // question 1
    println("1. Liste des serveurs connectes au serveur host2 a la periode 1366815793: ");
    println("");
    //println(connexions.map(_.tmps));
    //println(connexions.filter(x => x.tmps == "1366815793" && x.host2 == "host2").map(p => "Periode: "+ p.tmps + " Serveur: " + p.host1));
    println(connexions.filter(x => x.tmps == 1366815793 && x.host2 == "host2").map(p => p.host1));
    println("");
    println("");

    // question 2
    println("2. Le serveur qui a genere le plus de connexions pendant cette periode: ");
    println("");

    println(connexions.filter(x => x.tmps == 1366815793 && x.host2 == "host2").map(p => p.host1).groupBy(l => l).map(t => (t._1, t._2.length)).maxBy(it => it._2)._1);
    println("");
    println("");
   
    // question 3
    println("3. Le serveur qui a la connexion la plus recente: ");
    println("");
    println(connexions.map(t => (t.host2,  t.tmps)).maxBy(it => it._2)._1) ;//._1 pour avoir le premier element du tuple
    println("");
    println("");

    file.close();
  }


    
  
