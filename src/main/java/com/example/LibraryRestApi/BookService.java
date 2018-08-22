        for (Book book:bookRepository.findAll()) {

            if (book.getBookName().equalsIgnoreCase(bookName))
            return book;
        }
        throw new BookNotFoundException("book not found");
    }
}
