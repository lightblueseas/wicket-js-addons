wicket-js-addons
====================

A parent project for javascript libraries and jquery plugins that can be integrated with the java web framework wicket.

It holds module-projects that are wrappers for the javascript libraries and jquery plugins.

The wrappers are loosely coupled and can be easily integrated into an existing Apache Wicket application.

The wicket-js-addons-core module project holds the API that all sub-modules uses to build the wrappers. If you want to write your own wrapper you can add this project as dependency.


## Maven projects

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-pnotify project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-pnotify</artifactId>
   <version>7.4.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-popupoverlay project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-popupoverlay</artifactId>
   <version>7.4.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-spin.js project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-spin.js</artifactId>
   <version>7.4.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-toastr project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-toastr</artifactId>
   <version>7.4.0</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-tooltipster project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-tooltipster</artifactId>
   <version>7.4.0</version>
</dependency>
```

## Documentation


  * [How to use existing addons][How to use existing addons]
  
   [How to use existing addons]: https://github.com/lightblueseas/wicket-js-addons/wiki/How-to-use-existing-addons "How to use existing addons"
   
## Want to Help and improve it? ###

The source code for wicket-js-addons are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/wicket-js-addons/fork](https://github.com/lightblueseas/wicket-js-addons/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/wicket-js-addons/pull/new/master).

## Contacting the Developers

Do not hesitate to contact the wicket-js-addons developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/wicket-js-addons/issues).

# Donate

If you like this library, please consider a donation through 
<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fwicket-js-addons" target="_blank">
<img src="http://button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0">
</a>

