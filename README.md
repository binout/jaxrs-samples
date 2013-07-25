jaxrs-samples
=============

### Goal
This project aims to compare JAX-RS implementations :

* Jersey, bundled with Glassfish
* CXF, bundled with TomEE
* RestEasy, bundled with JBoss
* Restlet, standalone server with JAX-RS extension

### Use case

It's very simple :

1. GET  http://localhost:[port]/products/toto must return 204 NO CONTENT
2. POST http://localhost:[port]/products/toto with body : "{"name":"toto"}" 
3. GET  http://localhost:[port]/products/toto must return "{"name":"toto"}"
 
I use Arquillian to implement this use case as an integration test.

### More detailed...
For an advanced study, you can read the following article by OCTO (in french) :

* [http://blog.octo.com/jax-rs-cxf-vs-jersey-vs-resteasy](http://blog.octo.com/jax-rs-cxf-vs-jersey-vs-resteasy/)
* [http://blog.octo.com/les-implementations-jax-rs-2/](http://blog.octo.com/les-implementations-jax-rs-2/)
