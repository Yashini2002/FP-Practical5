object InventoryManagement{
      
  def main(args:Array[String]):Unit={
          val products=getProductList()
          println("\nProduct List:")
          printProductList(products)
          println(s"\nTotal number of products: ${getTotalProducts(products)}")

  }

  def getProductList():List[String]={
         var products=List.empty[String]
         var input=""
         while(input!="done"){
            input=scala.io.StdIn.readLine("Enter product name: ")
            if(input!="done"){
               products:+=input
            }
         }
         products
  }

   def printProductList(products:List[String]):Unit={
          products.zipWithIndex.foreach{
             case(product,index)=>println(s"${index+1}. $product")
          }
   }


   def getTotalProducts(products:List[String]):Int=products.size

}