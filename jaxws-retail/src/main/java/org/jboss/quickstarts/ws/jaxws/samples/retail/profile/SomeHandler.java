package org.jboss.quickstarts.ws.jaxws.samples.retail.profile;

import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.jboss.quickstarts.ws.jaxws.samples.retail.test.SomeProducer.SomeValueContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

public class SomeHandler implements SOAPHandler<SOAPMessageContext> {

    private static final Logger logger = LoggerFactory.getLogger(SomeHandler.class);

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        logger.info("handleMessage called on {} ", this);

        try {
            SomeTarget target = new SomeTarget();
            BeanProvider.injectFields(target);
            logger.info("BeanProvider call succeded: {}", target.value);
        } catch (Exception e) {
            logger.atError()
                  .setCause(e)
                  .log("CDI.current() call failed");
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    public static final class SomeTarget {

        @Inject
        @Named("SomeTargetValue")
        public SomeValueContainer value;
    }
}
