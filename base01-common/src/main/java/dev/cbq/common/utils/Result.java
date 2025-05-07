package dev.cbq.common.utils;

import org.slf4j.MDC;

import java.util.Optional;

public record Result<T>(Long id, Integer code, String message, T data) {

	private static final String DEFAULT_SUCCESSFUL_MESSAGE = "请求成功";
	private static final String DEFAULT_ERROR_MESSAGE = "发生了一点问题 请联系管理员";
	private static final String DEFAULT_REQUEST_ID = "request-id";

	public static <T> Result<T> success() {
		return new Result<>(requestId(), 200, DEFAULT_SUCCESSFUL_MESSAGE, null);
	}

	public static <T> Result<T> success(String message) {
		return new Result<>(requestId(), 200, message, null);
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(requestId(), 200, DEFAULT_SUCCESSFUL_MESSAGE, data);
	}

	public static <T> Result<T> success(Integer code, String message, T data) {
		return new Result<>(requestId(), code, message, data);
	}

	public static <T> Result<T> notFound(String message) {
		return new Result<>(requestId(), 404, message, null);
	}

	public static <T> Result<T> error() {
		return new Result<>(requestId(), 500, DEFAULT_ERROR_MESSAGE, null);
	}

	public static <T> Result<T> failure(int code, String message) {
		return new Result<>(requestId(), code, message, null);
	}

	public static <T> Result<T> forbidden(String message) {
		return failure(403, message);
	}

	public static <T> Result<T> unauthorized(String message) {
		return failure(401, message);
	}

	private static long requestId() {
		String requestId = Optional.ofNullable(MDC.get(DEFAULT_REQUEST_ID)).orElse("0");
		return Long.parseLong(requestId);
	}

}
