package dev.cbq.demo02.exception;

import dev.cbq.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {BusinessException.class})
	public Result<String> handleBusinessException(BusinessException ex, WebRequest request) {
		log.info("GlobalExceptionHandler.handleBusinessException {} | request = {}", ex.getMessage(), request);
		return Result.failure(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}


	@ExceptionHandler(value = {Throwable.class})
	public Result<String> handleException(Throwable ex, WebRequest request) {
		log.info("GlobalExceptionHandler.handleException {} | req {}", ex.getMessage(), request.getDescription(false));
		return Result.error();

	}

	@SuppressWarnings("NullableProblems")
	@Override
	@Nullable
	public ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex,
		HttpHeaders headers,
		HttpStatusCode status,
		WebRequest request) {
		log.info("GlobalExceptionHandler.handleMethodArgumentNotValid {}| request = {}", ex.getMessage(), request);
		ErrorResponseException errorResponseException =
			new ErrorResponseException(
				status, ProblemDetail.forStatusAndDetail(status, ex.getMessage()), ex.getCause());
		return handleExceptionInternal(
			errorResponseException,
			errorResponseException.getBody(),
			errorResponseException.getHeaders(),
			errorResponseException.getStatusCode(),
			request);
	}

}
