package org.hb2.webservice;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

