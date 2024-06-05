package com.example.springcrud.util;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageSource messageSource;
    public String getMessage(String code) {
        return getMessage(code, null);
    }
    public String getMessage(String code, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, locale);
    }
}
