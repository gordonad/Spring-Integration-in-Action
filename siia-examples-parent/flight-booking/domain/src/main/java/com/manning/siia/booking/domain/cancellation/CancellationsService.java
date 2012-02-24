package com.manning.siia.booking.domain.cancellation;

/**
 * @author Marius Bogoevici
 */
public interface CancellationsService {

    CancellationConfirmation cancel(CancellationRequest cancellationRequest);
}
