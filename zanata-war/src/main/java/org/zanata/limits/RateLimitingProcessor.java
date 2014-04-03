package org.zanata.limits;

import java.util.concurrent.TimeUnit;

import com.google.common.annotations.VisibleForTesting;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.seam.Component;
import org.zanata.ApplicationConfiguration;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is used by RateLimitingFilter and have access to seam environment.
 *
 * @see org.jboss.seam.servlet.ContextualHttpServletRequest
 *
 * @author Patrick Huang <a
 *         href="mailto:pahuang@redhat.com">pahuang@redhat.com</a>
 */
@Slf4j
public class RateLimitingProcessor {
    // http://tools.ietf.org/html/rfc6585
    public static final int TOO_MANY_REQUEST = 429;

    private final LeakyBucket logLimiter = new LeakyBucket(1, 5,
            TimeUnit.MINUTES);

    public void
            process(String apiKey, HttpResponse response, Runnable taskToRun)
                    throws Exception {
        ApplicationConfiguration appConfig = getApplicationConfiguration();

        if (appConfig.getMaxConcurrentRequestsPerApiKey() == 0
                && appConfig.getMaxActiveRequestsPerApiKey() == 0) {
            // short circuit if we don't want limiting
            taskToRun.run();
            return;
        }

        RateLimitManager rateLimitManager = getRateLimitManager();
        RestCallLimiter rateLimiter = rateLimitManager.getLimiter(apiKey);

        log.debug("check semaphore for {}", this);

        if (!rateLimiter.tryAcquireAndRun(taskToRun)) {
            if (logLimiter.tryAcquire()) {
                log.warn(
                        "{} has too many concurrent requests. Returning status 429",
                        apiKey);
            }
            String errorMessage =
                    String.format(
                            "Too many concurrent request for this API key (maximum is %d)",
                            appConfig.getMaxConcurrentRequestsPerApiKey());
            response.sendError(TOO_MANY_REQUEST, errorMessage);
        }
    }

    @VisibleForTesting
    RateLimitManager getRateLimitManager() {
        return RateLimitManager.getInstance();
    }

    @VisibleForTesting
    ApplicationConfiguration getApplicationConfiguration() {
        return (ApplicationConfiguration) Component
                .getInstance("applicationConfiguration");
    }

}
