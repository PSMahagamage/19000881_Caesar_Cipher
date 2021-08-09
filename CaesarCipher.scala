import scala.io.StdIn._
object caeserCipher extends App{

  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  def encryption(c:Char, key:Int, a:String):Char = {
    val r1 = a((a.indexOf(c.toUpper)+key) % a.size)
    return r1
  }
  def decryption(c:Char, key:Int, a:String):Char = {
    var i = a.indexOf(c.toUpper)-key
    if (i < 0) {i = 26-Math.abs(i)}
    val r2 = a(i)
    return r2
  }
  def cipher(algo:(Char,Int,String) => Char, s:String, key:Int, a:String):String = {
    val out = s.map(algo(_,key,a))
    return out
  }

      print("\n\n\n\t\t ### LETS USE CAESER CIPHER !!! ### \n\n")
      println("@ SELECT an Option from the list to proceed.\n\t1.DO Encryption\n\t2.DO Decryption\n\t3.EXIT program.")

      print("# Enter the Option number:")
      var in = readInt()
    while(in != 3){
      if(in == 1){
        println("\n@ ENCRYPTION")
        print("# Enter the Shifting KEY:")
        val key = readInt()
        print("# Enter the String which need Encrypt:")
        val msg = readLine()

        val entxt = cipher(encryption,msg,key,alphabet)
        println("The Encrypted Text is :" + entxt )
      }else if(in == 2){
        println("\n@ DECRYPTION")
        print("# Enter the Shifting KEY:")
        val key = readInt()
        print("# Enter the String which need Encrypt:")
        val clu = readLine()

        val detxt = cipher(decryption,clu,key,alphabet)
        println("The Decrypted Text is :" + detxt )
      }else
      {
        println("INVALID INPUT !!! Try Again.")
      }
      println("\n\n@ SELECT an Option from the list to proceed.\n\t1.DO Encryption\n\t2.DO Decryption\n\t3.EXIT program.")
      print("# Enter the Option number:")
      in = readInt()
    }
}
