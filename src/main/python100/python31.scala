object python31 {
  def main(args: Array[String]): Unit = {
    print("please input:")
    var letter = readChar(): Char
    if (letter == 'S') {
      print("please input second letter:\n")
      print("please input:")
      val letter = readChar(): Char

      if (letter == 'a') {
        print("Saturday")
      }
      else if (letter == 'u') {
        print("Sunday")
      } else {
        print("data error")
      }
    }
    else if (letter == 'F') {
      print("Friday")
    }

    else if (letter == 'M') {
      print("Monday")
    }

    else if (letter == 'T') {
      print("please input second letter\n")
      print("please input:")
      letter = readChar(): Char
      if (letter == 'u') {
        print("Tuesday")
      }
      else if (letter == 'h') {
        print("Thursday")
      } else {
        print("data error")
      }
    }
    else if (letter == 'W') {
      print("Wednesday")
    } else {
      print("data error")
    }
  }
}
