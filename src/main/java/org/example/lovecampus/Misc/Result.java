package org.example.lovecampus.Misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    public static <T> Result<T> success(String msg,T data) {
        return new Result<T>(200,msg, data);
    }
    public static <T> Result<T> success(String msg) {
        return new Result<T>(200, msg, null);
    }
    public static <T> Result<T> error(String msg) {
        return new Result<T>(500, msg, null);
    }

}
