package com.manning.siia.booking.domain.notifications;

/**
 * @author Iwein Fuld
 */
public interface Notifiable<T> {
    void notify(T notification);
}
