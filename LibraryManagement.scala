object LibraryManagement{

  case class Book(title:String, author:String, isbn: String)

  var library:Set[Book]=Set(
     Book("Hamlet", "William Shakespeare", "97340684"),
     Book("Harry Potter", "J.K.Rowling", "97240927"),
     Book("A Song of Ice and Fire", "George R.R.Martin", "97563948")
  )
  
  def main(args:Array[String]):Unit={
      println("Initial Library Collection:")
      displayLibrary()

      val newBook = Book("Dracula", "Lois Lowry", "97800608")
      addBook(newBook)
      
      println("\nLibrary Collection after adding a new book:")
      displayLibrary()

      removeBookByISBN("97800608")
      println("\nLibrary Collection after removing a book by ISBN:")
      displayLibrary()
      
      println("\nChecking if a book with ISBN 97340684 is in the library:")
      println(isBookInLibrary("97340684"))
      
      println("\nSearching for a book by title '1984':")
      searchBookByTitle("1984")
    
      println("\nDisplaying all books by author 'J.K.Rowling':")
      displayBooksByAuthor("J.K.Rowling")
  }


  def addBook(book:Book):Unit={
     library+=book
  }
 
  def removeBookByISBN(isbn:String):Unit={
     library=library.filterNot(_.isbn==isbn)
  }

  def displayLibrary():Unit={
     library.foreach(book=>println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }
 
  def searchBookByTitle(title:String):Unit={
      library.find(_.title==title) match{
          case Some(book)=>println(s"Found the book ${book.title}")
          case None=>println("Book not found")
      }
  }


  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author == author)
    if (booksByAuthor.nonEmpty) {
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}"))
    } else {
      println("No books found by this author")
    }
  }

}