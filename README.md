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

# How to use it

this library generates only js that you can add to a wicket behavior. For instance:

There is a awesome js lib tooltipster.js, You can integrate it and added to a Label you have to create this Label and an instance of the TooltipsterSettings:

`		final Label label = ComponentFactory.newLabel("tooltipTestLabel",
			Model.of("Im example for tooltipster."));
		final TooltipsterSettings tooltipsterSettings = TooltipsterSettings.builder().build();`

Then you set all attributes you need for the js lib tooltipster.js:

`		tooltipsterSettings.getAnimation().setValue("grow");
		tooltipsterSettings.getArrow().setValue(false);
		tooltipsterSettings.getContent().setValue("Loading foo...");`

If you set all attributes you need you give the tooltipsterSettings instance and the markup id from the label to a JsGenerator in this case the TooltipsterJsGenerator:

`		final TooltipsterJsGenerator tooltipsterJsGenerator = new TooltipsterJsGenerator(
			tooltipsterSettings, label.getMarkupId());
		final String js = tooltipsterJsGenerator.generateJs();`

This generates the needed javascript code that you have to add to the label over a Behavior. I have implemented an Behavior(JavascriptAppenderBehavior) that does this:

`		label.add(JavascriptAppenderBehavior.builder().id("tooltip_" + label.getMarkupId())
			.javascript(js).build());
		add(label);`

At the end you add the label to the parent component.

The class JavascriptAppenderBehavior is in the lib jaulp.wicket.behaviors project.
