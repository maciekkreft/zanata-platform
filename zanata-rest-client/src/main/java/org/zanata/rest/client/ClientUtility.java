package org.zanata.rest.client;

import java.net.URI;
import java.util.Arrays;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.core.BaseClientResponse;

public class ClientUtility {
    public static void checkResult(ClientResponse<?> response) {
        checkResult(response, null);
    }

    public static void checkResult(ClientResponse<?> response, URI uri) {
        if (response.getResponseStatus() == Response.Status.UNAUTHORIZED) {
            throw new RuntimeException("Incorrect username/password");
        } else if (response.getResponseStatus() == Response.Status.SERVICE_UNAVAILABLE) {
            throw new RuntimeException("Service is currently unavailable. " +
                    "Please check outage notification or try again later.");
        } else if (response.getStatus() >= 399) {
            String annotString = "";
            String uriString = "";
            String entity = "";
            if (response instanceof BaseClientResponse) {
                BaseClientResponse<?> resp = (BaseClientResponse<?>) response;
                annotString =
                        ", annotations: "
                                + Arrays.asList(resp.getAnnotations())
                                        .toString();
            }
            if (uri != null) {
                uriString = ", uri: " + uri;
            }
            try {
                entity = ": " + response.getEntity(String.class);
            } finally {
                // ignore
            }
            String msg =
                    "operation returned "
                            + response.getStatus()
                            + " ("
                            + Response.Status.fromStatusCode(response
                                    .getStatus()) + ")" + entity + uriString
                            + annotString;
            throw new RuntimeException(msg);
        }
    }

    public static void checkResultAndReleaseConnection(
            ClientResponse<?> clientResponse) {
        checkResult(clientResponse, null);
        clientResponse.releaseConnection();
    }
}