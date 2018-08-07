wicket-js-addons
====================

A parent project for javascript libraries and jquery plugins that can be integrated with the java web framework wicket.

It holds module-projects that are wrappers for the javascript libraries and jquery plugins.

The wrappers are loosely coupled and can be easily integrated into an existing Apache Wicket application.

The wicket-js-addons-core module project holds the API that all sub-modules uses to build the wrappers. If you want to write your own wrapper you can add this project as dependency.

## License

The source code comes under the liberal MIT License, making wicket-js-addons great for all types of wicket applications.

# Build status
[![Build Status](https://travis-ci.org/lightblueseas/wicket-js-addons.svg?branch=master)](https://travis-ci.org/lightblueseas/wicket-js-addons)

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/wicket-js-addons/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/wicket-js-addons)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~wicket-js-addons~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- WICKET-JS-ADDONS version -->
		<wicket-js-addons.version>7.8.0</wicket-js-addons.version>
		<wicket-pnotify.version>${wicket-js-addons.version}</wicket-pnotify.version>
		<wicket-popupoverlay.version>${wicket-js-addons.version}</wicket-popupoverlay.version>
		<wicket-spin.js.version>${wicket-js-addons.version}</wicket-spin.js.version>
		<wicket-toastr.version>${wicket-js-addons.version}</wicket-toastr.version>
		<wicket-tooltipster.version>${wicket-js-addons.version}</wicket-tooltipster.version>
			...
	</properties>

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-pnotify project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-pnotify</artifactId>
   <version>${wicket-pnotify.version}</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-popupoverlay project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-popupoverlay</artifactId>
   <version>${wicket-popupoverlay.version}</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-spin.js project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-spin.js</artifactId>
   <version>${wicket-spin.js.version}</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-toastr project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-toastr</artifactId>
   <version>${wicket-toastr.version}</version>
</dependency>
```

Add the following maven dependency to your project `pom.xml` if you want to import the wicket-tooltipster project:

```xml
<dependency>
   <groupId>de.alpharogroup</groupId>
   <artifactId>wicket-tooltipster</artifactId>
   <version>${wicket-tooltipster.version}</version>
</dependency>
```

## Documentation

  * [How to use existing addons][How to use existing addons]
  * [How to create your own addon from an js lib][How to create your own addon from an js lib]
  
   [How to use existing addons]: https://github.com/lightblueseas/wicket-js-addons/wiki/How-to-use-existing-addons "How to use existing addons"

   [How to create your own addon from an js lib]: https://github.com/lightblueseas/wicket-js-addons/wiki/How-to-create-your-own-addon-from-an-js-lib "How to create your own addon from an js lib"
   
## Want to Help and improve it? ###

The source code for wicket-js-addons are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/wicket-js-addons/fork](https://github.com/lightblueseas/wicket-js-addons/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/wicket-js-addons/pull/new/develop).

## Contacting the Developers

Do not hesitate to contact the wicket-js-addons developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/wicket-js-addons/issues).

## Note

No animals were harmed in the making of this library.

# Donate

If you like this library, please consider a donation through 
<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fwicket-js-addons" target="_blank">
<img src="http://button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0">
</a>

