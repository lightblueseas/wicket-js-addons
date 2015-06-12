wicket-js-addons
====================

A parent project for javascript libraries and jquery plugins that can be integrated with the framework wicket.

It holds module-projects that are wrappers for the javascript libraries and jquery plugins.

The wrappers are loosely coupled and can be easily integrated into an existing Apache Wicket application.

The wicket-js-addons-core module project holds the API that all sub-modules uses to build the wrappers. If you want to write your own wrapper you can add this project as dependency.


## Maven projects

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-pnotify project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-pnotify</artifactId>
   <version>6.18.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-popupoverlay project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-popupoverlay</artifactId>
   <version>6.18.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-spin.js project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-spin.js</artifactId>
   <version>6.18.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-toastr project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-toastr</artifactId>
   <version>6.18.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-tooltipster project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-tooltipster</artifactId>
   <version>6.18.0</version>
</dependency>
```
