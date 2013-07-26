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

### Summary
<table>
<tr>
    <th></th>
    <th>glassfish-jersey</th>
    <th>jersey</th>
    <th>tomee-cxf</th>
    <th>resteasy</th>
    <th>restlet</th>
</tr>
<tr>
    <th>version</th>
    <td>glassfish 3.1.2</td>
    <td></td>
    <td>tomee 1.5.2</td>
    <td>3.0.2.Final</td>
    <td>2.2-M3</td>
</tr>
<tr>
    <th>documentation</th>
    <td><a href="https://jersey.java.net/documentation/latest/index.html">Jersey User Guide</a></td>
    <td><a href="https://jersey.java.net/documentation/latest/index.html">Jersey User Guide</a></td>
    <td><a href="http://cxf.apache.org/docs/index.html">CXF User Guide</a></td>
    <td><a href="http://docs.jboss.org/resteasy/docs/3.0.2.Final/userguide/html_single/index.html">RestEasy User Guide</a></td>
    <td><a href="http://restlet.org/learn/guide/2.1/">Restlet User Guide</a></td>
</tr>
<tr>
    <th>packaging</th>
    <td>war</td>
    <td>jar</td>
    <td>war</td>
    <td>jar</td>
    <td>jar</td>
</tr>
<tr>
    <th>server</th>
    <td>glassfish</td>
    <td>HttpServer</td>
    <td>tomee</td>
    <td>HttpServer</td>
    <td>org.restlet.Component</td>
</tr>
<tr>
    <th>test</th>
    <td>with arquillian, but long</td>
    <td>fast</td>
    <td>with arquillian, but long</td>
    <td>fast</td>
    <td>fast</td>
</tr>
<tr>
    <th>dependency injection</th>
    <td>weld</td>
    <td>guice</td>
    <td>OpenWebBeans</td>
    <td>no, possible partial guice integration</td>
    <td>no, possible partial guice integration</td>
</tr>

</table>


### More detailed...
For an advanced study, you can read the following article by OCTO (in french) :

* [http://blog.octo.com/jax-rs-cxf-vs-jersey-vs-resteasy](http://blog.octo.com/jax-rs-cxf-vs-jersey-vs-resteasy/)
* [http://blog.octo.com/les-implementations-jax-rs-2/](http://blog.octo.com/les-implementations-jax-rs-2/)
