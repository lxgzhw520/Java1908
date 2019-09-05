$("input:radio[name=radio-navbar]").bind "click", ->
    value = $(this).val()
    if value == "default"
      $("#navbar").addClass("navbar-default").removeClass("navbar-inverse")
    else if value == "inverse"
      $("#navbar").removeClass("navbar-default").addClass("navbar-inverse")

$("input:radio[name=radio-sidebar]").bind "click", ->
    value = $(this).val()
    if value == "default"
      $("#sidebar").removeClass("sidebar-inverse")
    else if value == "inverse"
      $("#sidebar").addClass("sidebar-inverse")

$("input:radio[name=radio-color]").bind "click", ->
    value = $(this).val()
    if value == "blue"
      $("body").removeClass("flat-green").addClass("flat-blue")
    else if value == "green"
      $("body").removeClass("flat-blue").addClass("flat-green")
