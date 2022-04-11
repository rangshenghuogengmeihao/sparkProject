object python22 {
  def main(args: Array[String]): Unit = {
    var list_jia=List[String]("a","b","c")
    var list_yi=List[String]("x","y","z")
    for(i<-list_yi;j<-list_yi){
      if(i!=j){
        for (k<-list_yi){
          if(i!=k && j!=k){
            if(i!="x" && k!="x" && k!="z"){
              print("order is a -- %s\t b -- %s\t c--%s".format(i,j,k))
            }
          }
        }
      }
    }
  }
}
