package org.example.javaotel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_SERVER_ERROR(500,"Sunucuda beklenmeyen bir hata oldu. Lütfen tekrar deneyin",HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_ERROR(400,"girilen parametreler hatalıdır. Lütfen kontrol ederek tekrar deneyimn.", HttpStatus.BAD_REQUEST),
    ROOM_NOTFOUND(5001, "Oda Bulunamadı...", HttpStatus.NOT_FOUND),
    ROOM_UNAVAILABLE(5002, "Rezervasyon yapmak istediğiniz oda bu tarihler aralığında doludur.", HttpStatus.BAD_REQUEST),
    ADMIN_NOTFOUND(6000, "Admin kullanıcısı bulunamadı...", HttpStatus.NOT_FOUND),
    RESERVATION_NOTFOUND(7003, "Rezervasyon bulunamadı...", HttpStatus.NOT_FOUND),

    INVALID_TOKEN(9001,"geçersiz token bilgisi",HttpStatus.BAD_REQUEST),
    INVALID_USERNAME_OR_PASSWORD(6002,"Kullanıcı adı ya da şifre hatalıdır",HttpStatus.BAD_REQUEST);


    int code;
    String message;
    HttpStatus httpStatus;
}
