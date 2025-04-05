package org.product.exception;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        ErrorResponse error;

        if (exception instanceof NotFoundException) {
            error = new ErrorResponse("NOT_FOUND", exception.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        // Add other custom exceptions here...

        // Default fallback
        error = new ErrorResponse("INTERNAL_SERVER_ERROR", "Something went wrong.");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
