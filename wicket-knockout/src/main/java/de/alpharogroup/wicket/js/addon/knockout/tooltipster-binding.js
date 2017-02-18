ko.bindingHandlers.tooltipster = {
	init : function(element, valueAccessor) {
		var options = valueAccessor() || {};
		$(element).tooltipster(options);
	}
};