# fixplayground

A FIX protocol demo with Java+QuickFIX/J+Spring Boot. Jaakko Saaristo 2018

- Creates two local Spring Boot (Tomcat) servers for
  - FIX Initiator (investment manager, buyer), and
  - FIX Acceptor (execution broker, seller).
- Initiator provides a REST interface to send commands over a REST client
 
