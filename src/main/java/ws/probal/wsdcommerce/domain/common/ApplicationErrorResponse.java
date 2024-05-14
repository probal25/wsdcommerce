package ws.probal.wsdcommerce.domain.common;

import java.time.LocalDateTime;

public record ApplicationErrorResponse(int status, String message, LocalDateTime timestamp) {
}
