package com.manning.siia.trip.diary;

import org.junit.Test;
import org.springframework.integration.Message;

import java.lang.management.ManagementFactory;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.Mockito.mock;

/**
 * @author Iwein Fuld
 */
public class ChangeFileNameGeneratorTest {

    private String processId = ManagementFactory.getRuntimeMXBean().getName();
    private final ChangeFileNameGenerator generator =
            new ChangeFileNameGenerator(processId);

    @Test
    public void processIdShouldNotBeNull() {
        assertThat(processId, containsString("@"));
    }

    @Test
    public void filenameShouldContainProcessId() {
        Message<?> message = mock(Message.class);
        assertThat(generator.generateFileName(message), containsString(processId));
    }

    @Test
    public void filenameShouldContainTodaysDate() {
        Message<?> message = mock(Message.class);
        assertThat(
                generator.generateFileName(message),
                containsString(Long.toString(System.currentTimeMillis()))
        );
    }
}
