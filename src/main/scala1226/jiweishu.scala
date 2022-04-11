import scala.io.StdIn._

object jiweishu {
  def main(args: Array[String]): Unit = {
    print("输入一个数")
    var i = readInt()
    //    方法一
    //    if (i <= 9 && i >= 1) {
    //      printf("%s是1位数",i)
    //    } else if (i <= 99 && i >= 10) {
    //      println(s"$i 是2位数")
    //    } else if (i <= 999 && i >= 100) {
    //      println(s"$i 是3位数")
    //    } else if (i <= 9999 && i >= 1000) {
    //      println(s"$i 是4位数")
    //    }

    //    方法二
    //    var count=0
    //    while (i!=0){
    //      i /=10
    //      count+=1
    //    }
    //    println(count)

    //    方法三
    //    var stri=i.toString
    //    println(stri.length)

    //    方法四
    //    println(String.valueOf(i).length)

    //    方法五
    //    if (i >= 0 & i < 10) {
    //      print(1)
    //    } else if (i < 100) {
    //      print(2)
    //    } else if (i < 1000) {
    //      print(3)
    //    } else if (i < 10000) {
    //      print(4)
    //    } else {
    //      print("not a useful value")
    //    }

    //方法六
    //    var a = 1
    //    var count = 0
    //    while (i > a) {
    //      a *= 10
    //      count += 1
    //    }
    //    println(count)

    //    方法七
    //    for (a <- 1 to 10000) {
    //      if (a == i) {
    //        print(String.valueOf(i).length)
    //      }
    //    }

    //    方法八
    //    for (x <- 1 to 10000) {
    //      if (i == x) {
    //        if (i < 10) {
    //          print(1)
    //        }
    //        else if (i < 100) {
    //          print(2)
    //        } else if (i < 1000) {
    //          print(3)
    //        }
    //        else {
    //          print(4)
    //        }
    //      }
    //    }

  }
}
