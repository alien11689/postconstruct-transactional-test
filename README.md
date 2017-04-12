# postconstruct-transactional-test
An example code for apache karaf to test if blueprint interceptors are applied for the init-method.

#### Requirements:

* Karaf features, commands to execute in the console:
    ```
    feature:repo-add mvn:org.ops4j.pax.jdbc/pax-jdbc-features/1.1.0/xml/features
    feature:install pax-jdbc-h2 pax-jdbc-config hibernate jpa transaction
    ```
* Config file: `etc/org.ops4j.datasource-pcta-test.cfg`
    ```
    osgi.jdbc.driver.name=H2
    databaseName=test
    user=sa
    password=
    dataSourceName=pcta-test
    ```
* Installation of this bundle after building:
    ```
    install -s mvn:abc/pcta-test/1-SNAPSHOT
    ```
