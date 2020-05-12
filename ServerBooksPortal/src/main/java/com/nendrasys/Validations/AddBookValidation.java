package com.nendrasys.Validations;

import com.nendrasys.model.BooksInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddBookValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return BooksInfo.class.isAssignableFrom(aClass);
    }

  @Override
    public void validate(Object obj, Errors error) {

        ValidationUtils.rejectIfEmpty(error, "bookId", "booksInfo.bookId.empty");
        ValidationUtils.rejectIfEmpty(error,"bookName","bookName.empty");
        ValidationUtils.rejectIfEmpty(error, "bookAuthor", "bookAuthor.empty");
        ValidationUtils.rejectIfEmpty(error, "bookDesc", "bookDesc.empty");
        ValidationUtils.rejectIfEmpty(error, "price", "price.empty");
        ValidationUtils.rejectIfEmpty(error, "language", "language.empty");
         BooksInfo user=(BooksInfo)obj;
     /*   if (user.getBookName() != null && user.getBookName().length() < 1 ||
                user.getBookName().length() > 50) {
            error.rejectValue("bookName", "user.bookName.size");
        }

        if (user.getBookAuthor() != null && user.getBookAuthor().length() < 1 &&
                user.getBookAuthor().length() > 50) {
            error.rejectValue("bookAuthor", "user.bookAuthor.size");
        }*/
    }
}
