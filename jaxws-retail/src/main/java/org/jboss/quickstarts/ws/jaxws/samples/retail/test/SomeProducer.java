package org.jboss.quickstarts.ws.jaxws.samples.retail.test;

import java.util.Date;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
public class SomeProducer {

    @Produces
    @RequestScoped
    @Named("SomeTargetValue")
    public SomeValueContainer value() {

        SomeValueContainer svc = new SomeValueContainer();
        svc.value = "xyz-" + new Date();
        return svc;
    }

    public static class SomeValueContainer {
        public String value;

        @Override
        public String toString() {
            return "SomeValueContainer[" + value + "]";
        }
    }
}
