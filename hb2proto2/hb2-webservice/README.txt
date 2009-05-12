Sample application for a cxf based webservice.

Can be configured to use either JAXB (default) or Aegis.
See http://cwiki.apache.org/CXF20DOC/data-binding-architecture.html and
http://cwiki.apache.org/CXF20DOC/databindings.html

Moved the web services to package edu.umich.med.michr.hb2.websvcs in order
to match Honest Broker application organization.

Deployment

I've been able to get "mvn jetty:run" to work consistently, from the command line. However, getting hb2 to run in Tomcat in Eclipse was a little tricky. Adding the app. server via Run As|Run on server and picking Tomcat 6.0 led to an error on startup complaining that the bootstrap loader had loaded JAXB 2.0 and the app wants JAXB 2.1 - the trick was figuring out where to put the libs. I tried the endorsed and ext directories in the JRE of the JDK (for both jdk 1.5 and 1.6) and tomcat lib directories here and there, and everywhere, restarting Eclipse and the server over and over. Finally I looked at the command line params of the Tomcat config in eclipse (open the server and launch config from server view, or from run configurations in the run menu) and discovered on the :

-Djava.endorsed.dirs="C:\dev\apache-tomcat-6.0.14\endorsed"

Wow! Eclipse expects by default an endorsed directory in teh root of the Tomcat 6 home. The directory does not exist in the default install. I added the directory and copied in jaxp-api.jar and jaxb-impl.jar for v2.1 and... Bob's your uncle!

(BTW, the Tomcat 5.5 server adaptor specifies:

-Djava.endorsed.dirs="C:\dev\apache-tomcat-5.5.25\common\endorsed" which is the standard spot.)

>>>Under Jetty 6<<<

http://localhost:8080/cxf-webservices-1.0/webservices/edu.umich.med.michr.hb2.websvcs?wsdl
http://localhost:8080/cxf-webservices-1.0/webservices/edu.umich.med.michr.hb2.websvcs/getMessages

>>>Under Tomcat 6<<<

http://localhost:9080/cxf-webservices/webservices/edu.umich.med.michr.hb2.websvcs?wsdl
http://localhost:9080/cxf-webservices/webservices/edu.umich.med.michr.hb2.websvcs/getMessages










>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
This code is originally from Willie Wheeler's excellent article Web Services with Spring 2.5 and Apache CXF 2.0.

Note: this assumes you have maven2 installed and on your PATH

** (optional) To get the project setup in eclipse run the following: **

mvn eclipse:eclipse -DdownloadSources=true

Then open eclipse and create a new java project | create project from existing source
and specify this directory.  right click on the project in eclipse and go to properties | java build path | libraries | add variable

Add a variable called M2_REPO which points to your maven 2 repository

now everything should be OK in eclipse


** To deploy/run: **

mvn jetty:run

-- or --
mvn install and copy the war to your tomcat webapps dir (or wherever you're deploying)

These are now your URLs of interest:

http://localhost:8080/cxf-webservices-1.0/webservices/contactus?wsdl
http://localhost:8080/cxf-webservices-1.0/webservices/contactus/getMessagesAsString


** Running the JUnit client (ContactUsServiceIntegrationTest) **

once you've got the server running (keep it running!), you can also try the JUnit test
(which does much the same thing as Mr. Wheeler's follow up article on making a client
but then more simply (without the baggage of a webapp).

Either open a new command prompt and run: mvn test
or run the unit test inside eclipse (or your IDE of choice).

