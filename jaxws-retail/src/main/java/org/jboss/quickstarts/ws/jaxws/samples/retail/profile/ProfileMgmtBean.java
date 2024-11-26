/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.quickstarts.ws.jaxws.samples.retail.profile;

import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.jws.HandlerChain;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

/**
 *
 * @author rsearls@redhat.com
 */
@Stateless
@WebService(
    name = "ProfileMgmt",
    targetNamespace = "http://org.jboss.ws/samples/retail/profile",
    serviceName = "ProfileMgmtService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@HandlerChain(file = "handler-chain.xml")
public class ProfileMgmtBean {

    @WebMethod
    public DiscountResponse getCustomerDiscount(DiscountRequest request) {

        // Works fine:
        CDI<Object> cdi = CDI.current();

        DiscountResponse dResponse = new DiscountResponse();
        dResponse.setCustomer(request.getCustomer());
        dResponse.setDiscount(10.00);
        return dResponse;
    }
}
