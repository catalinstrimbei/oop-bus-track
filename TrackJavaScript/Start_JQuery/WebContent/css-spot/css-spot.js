/** START jQuery Scripting ***********************************************/
$(document).ready(function() {
	$(function() {
		$("#tab_wrapper").tabs();
		$("#tab_wrapper").tabs({
			active : 0
		});
	});

	/* tab1-backgrounds: source code */
	$("li.background-color").hover(function() {
		$(this).css("color", "red");
		$(this).css("background-color", "blue");
		$(this).css("font-style", "italic");
		$(this).text("background-color-red");
	}, function() {
		$(this).css("color", "black");
		$(this).css("background-color", "white");
		$(this).css("font-style", "normal");
		$(this).text("background-color-default");
	});
	
	/* tab3-fonts: source code */
	$("li.font-family").mouseenter(function() {
		$(this).css("color", "red");
		$(this).css("font-family", "Arial");
		$(this).text("font-family: Arial");
	});

	$("li.font-weight").mouseenter(function() {
		$(this).css("color", "red");
		$(this).css("font-weight", "200");
		$(this).text("font-weight: 200");
	});

	/* tab4-links: source code */
	$("#firstLink").hover(function() {
		$(this).css("color", "yellow");
		$(this).css("background-color", "green");
		$(this).css("font-style", "italic");
	}, function() {
		$(this).css("color", "black");
		$(this).css("background-color", "white");
		$(this).css("font-style", "normal");
	});

	/* tab5-lists: source code */
	$("ul.a").hover(function() {
		$(this).css("list-style-type", "square");
	}, function() {
		$(this).css("list-style-type", "circle");
	});
	
	/* tab6-box: source code */
	$("li.border").hover(function() {
		$(this).css("border-width", "5px");
		$(this).css("border-color", "blue");
		$(this).css("color", "red");
	});
	$("li.margins").hover(function() {
		$(this).css("margin-top", "35px");
		$(this).css("margin-bottom", "35px");
		$(this).css("color", "blue");
	}, function() {
		$(this).css("margin-top", "30px");
		$(this).css("margin-bottom", "30px");
		$(this).css("color", "red");
	});	
	$("li.padding").hover(function() {
		$(this).css("background-color", "blue");
		$(this).css("color", "red");
	});	
	
}); /** END jQuery Scripting ***********************************************/

/* tab1-backgrounds: source code */
//object.style.backgroundImage="url(stars.gif)"

/* tab3-fonts: source code */
function changeFont() {
	var lis = document.getElementsByTagName("li");
	for (i in lis) {
		if (lis[i]) {
			if (lis[i].className == "font-style") {
				lis[i].style.color = "red";
				lis[i].style.fontStyle = "normal";
				lis[i].innerHTML = "font-style: normal";
			}
			if (lis[i].className == "font-size") {
				lis[i].style.color = "red";
				lis[i].style.fontSize = "1.2em";
				lis[i].innerHTML = "font-size: 1.2em (20px/16=1.2em)";
			}
		}
	}
}

/* tab4-links: source code */
function changeLink(link) {
	link.style.color = "red";
	link.style.fontStyle = "italic";
}

/* tab5-lists: source code */
function changeList(list) {
	list.style.listStyleType = "lower-roman";
	list.style.fontStyle = "italic";
}

/* tab6-box: source code */
function changeOutline(item) {
	item.style.outlineColor = "blue";
	item.style.color = "red";	
}
